package com.juztoss;


import com.juztoss.shapes.*;

import java.util.*;

/**
 * Created by 1 on 26.04.2016.
 */
public class Game extends TimerTask implements Input.IInputReceiver {

    private static final int FRAME_TIMEOUT = 1000;

    public static final int FIELD_WIDTH = 10;
    private boolean mField[][];

    private AbstractShape mCurrentShape;
    private Input mInput;
    private Timer mTimer = new Timer(true);
    private ShapesGenerator mGenerator;

    public static final int FIELD_HEIGHT = 20;

    @Override
    public void run() {
        doStepDown();
    }

    @Override
    public void receive(int character) {
        switch (character) {
            case 97://A key
                doAction(Action.LEFT);
                break;
            case 100://D key
                doAction(Action.RIGHT);
                break;
            case 115://S key
                doAction(Action.DROP);
                break;
            case 114://R key
                doAction(Action.ROTATE);
        }
    }

    public void start() {

        mGenerator = new ShapesGenerator(this);
        mInput = new Input(this);
        new Thread(mInput).start();
        mField = new boolean[FIELD_WIDTH][FIELD_HEIGHT];

        mTimer.scheduleAtFixedRate(this, 0, FRAME_TIMEOUT);
    }

    private void doStepDown() {
        dropLines();
        doAction(Action.DOWN);
        addNewShapeIfNeeded();
        drawField();
    }

    private void dropLines() {
        for (int y = FIELD_HEIGHT-1; y >= 0; y--) {
            boolean isLineFull = true;
            for (int x = 0; x < FIELD_WIDTH; x++) {
                if(!mField[x][y])
                {
                    isLineFull = false;
                    break;
                }
            }
            if(isLineFull)
            {
                dropLine(y);
                y++;
            }
        }
    }

    private void dropLine(int lineY) {
        for (int y = lineY; y >= 0; y--) {
            for (int x = 0; x < FIELD_WIDTH; x++) {
                if(y <= 1)
                    mField[x][y] = false;
                else
                    mField[x][y] = mField[x][y - 1];
            }
        }
    }

    private void addNewShapeIfNeeded() {
        if (mCurrentShape == null) {
            Class<? extends AbstractShape> shapeClass = Math.random() > 0.5 ? QShape.class : (Math.random() > 0.5 ? IShape.class : TShape.class);
            mCurrentShape = mGenerator.getNew();

            //Clear the field on loosea
            if(!mCurrentShape.canDoAction(Action.DOWN))
                clearFiled();

            mCurrentShape.draw();
        }
    }

    private void clearFiled() {
        for (int i = 0; i < FIELD_HEIGHT; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                mField[j][i] = false;
            }
        }
    }

    private void drawField() {
        for (int i = -1; i < FIELD_HEIGHT + 1; i++) {
            for (int j = -1; j < FIELD_WIDTH + 1; j++) {
                if (i < 0 || i >= FIELD_HEIGHT || j < 0 || j >= FIELD_WIDTH)
                    System.out.print("O");
                else if (mField[j][i])
                    System.out.print("#");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    private synchronized void doAction(Action action) {
        if (mCurrentShape == null)
            return;

        mCurrentShape.erase();
        if (action == Action.DOWN && !mCurrentShape.canDoAction(action)) {
            mCurrentShape.draw();
            mCurrentShape = null;
            drawField();
            return;
        }
        mCurrentShape.doAction(action);
        mCurrentShape.draw();
        drawField();
    }

    public void erase(int x, int y) {
        if (x < 0 || x >= FIELD_WIDTH || y < 0 || y >= FIELD_HEIGHT)
            return;
        mField[x][y] = false;
    }

    public void draw(int x, int y) {
        if (x < 0 || x >= FIELD_WIDTH || y < 0 || y >= FIELD_HEIGHT)
            return;
        mField[x][y] = true;
    }

    public boolean get(int x, int y) {
        if (x < 0 || x >= FIELD_WIDTH || y < 0 || y >= FIELD_HEIGHT)
            return true;

        return mField[x][y];
    }
}
