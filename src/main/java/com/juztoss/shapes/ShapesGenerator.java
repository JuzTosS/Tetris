package com.juztoss.shapes;

import com.juztoss.Game;

import java.lang.reflect.Constructor;
import java.util.*;

/**
 * Created by Kirill on 5/20/2016.
 */
public class ShapesGenerator {
    private static final List<Class<? extends AbstractShape>> SHAPES = new ArrayList<>();

    static {
        SHAPES.add(QShape.class);
        SHAPES.add(IShape.class);
        SHAPES.add(TShape.class);
        SHAPES.add(SShape.class);
        SHAPES.add(ZShape.class);
        SHAPES.add(LShape.class);
        SHAPES.add(JShape.class);
    }


    ShapesPool mShapesPool = new ShapesPool();
    Random mRandomGenerator = new Random();
    Game mGame;

    public ShapesGenerator(Game game) {
        mGame = game;
    }

    public AbstractShape getNew() {
        Class<? extends AbstractShape> shapeClass = SHAPES.get(mRandomGenerator.nextInt(SHAPES.size()));
        return mShapesPool.get(shapeClass, mGame);
    }

    private class ShapesPool {

        private Map<Class<? extends AbstractShape>, AbstractShape> mPool = new HashMap<>();

        public AbstractShape get(Class<? extends AbstractShape> shapeClass, Game game) {
            try {
                if (mPool.get(shapeClass) == null) {
                    Constructor<? extends AbstractShape> constructor = shapeClass.getConstructor(Game.class);
                    mPool.put(shapeClass, constructor.newInstance(game));
                }

                AbstractShape shape = mPool.get(shapeClass);
                shape.reset();
                return shape;

            } catch (Exception e) {
                //Ignore error
            }
            return null;
        }
    }

}
