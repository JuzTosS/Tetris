package com.juztoss.shapes;

import com.juztoss.Game;

/**
 * Created by Kirill on 5/16/2016.
 */
public class IShape extends AbstractShape {
    private boolean[][] mContent;

    public IShape(Game game) {
        super(game);
    }

    @Override
    void reset() {
        super.reset();
        mContent = new boolean[4][1];
        mContent[0][0] = true;
        mContent[1][0] = true;
        mContent[2][0] = true;
        mContent[3][0] = true;
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
