package com.juztoss.shapes;

import com.juztoss.Game;

/**
 * Created by Kirill on 5/16/2016.
 */
public class TShape extends AbstractShape {
    private boolean[][] mContent;

    public TShape(Game game) {
        super(game);
    }

    @Override
    void reset() {
        super.reset();

        mContent = new boolean[3][3];
        mContent[0][0] = false;
        mContent[1][0] = false;
        mContent[2][0] = false;
        mContent[0][1] = false;
        mContent[1][1] = true;
        mContent[2][1] = false;
        mContent[0][2] = true;
        mContent[1][2] = true;
        mContent[2][2] = true;
    }

    @Override
    protected boolean[][] getContent() {
        return mContent;
    }

    @Override
    protected void setContent(boolean[][] content) {
        mContent = content;
    }
}
