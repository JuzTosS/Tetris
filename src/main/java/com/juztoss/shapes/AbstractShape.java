package com.juztoss.shapes;

import com.juztoss.Action;
import com.juztoss.Game;
import com.juztoss.utils.MatrixUtil;

/**
 * Created by 1 on 26.04.2016.
 */
public abstract class AbstractShape {
    private Game mGame;
    private int mX;
    private int mY;

    AbstractShape(Game game) {

        mGame = game;
        reset();
    }

    protected abstract boolean[][] getContent();

    protected abstract void setContent(boolean[][] content);

    void reset() {
        mX = Game.FIELD_WIDTH / 2;
        mY = 0;
    }

    public void draw() {
        for (int y = 0; y < getContent().length; y++) {
            for (int x = 0; x < getContent()[y].length; x++) {
                if (getContent()[y][x])
                    mGame.draw(mX + x, mY + y);
            }
        }
    }

    public void erase() {
        for (int y = 0; y < getContent().length; y++) {
            for (int x = 0; x < getContent()[y].length; x++) {
                if (getContent()[y][x])
                    mGame.erase(mX + x, mY + y);
            }
        }
    }

    public boolean canDoAction(Action action) {
        if (action == Action.LEFT) {
            for (int y = 0; y < getContent().length; y++) {
                for (int x = 0; x < getContent()[y].length; x++) {
                    boolean value = getContent()[y][x];
                    if (value && mGame.get(mX + x - 1, mY + y))
                        return false;
                }
            }
            return true;
        } else if (action == Action.RIGHT) {
            for (int y = 0; y < getContent().length; y++) {
                for (int x = 0; x < getContent()[y].length; x++) {
                    boolean value = getContent()[y][x];
                    if (value && mGame.get(mX + x + 1, mY + y))
                        return false;
                }
            }
            return true;
        } else if (action == Action.DOWN || action == Action.DROP) {
            for (int y = 0; y < getContent().length; y++) {
                for (int x = 0; x < getContent()[y].length; x++) {
                    boolean value = getContent()[y][x];
                    if (value && mGame.get(mX + x, mY + y + 1))
                        return false;
                }
            }
            return true;
        } else if (action == Action.ROTATE) {
            boolean[][] rotated = MatrixUtil.rotateRight(getContent());
            for (int y = 0; y < rotated.length; y++) {
                for (int x = 0; x < rotated[y].length; x++) {
                    boolean value = rotated[y][x];
                    if (value && mGame.get(mX + x, mY + y))
                        return false;
                }
            }
            return true;
        }
        return false;
    }

    public void doAction(Action action) {
        if (!canDoAction(action))
            return;

        if (action == Action.LEFT)
            mX--;
        else if (action == Action.RIGHT)
            mX++;
        else if (action == Action.DOWN)
            mY++;
        else if (action == Action.DROP) {
            while (canDoAction(action))
                mY++;
        } else if (action == Action.ROTATE)
            setContent(MatrixUtil.rotateRight(getContent()));
    }
}
