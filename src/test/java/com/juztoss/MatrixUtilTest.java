package com.juztoss;

import com.juztoss.utils.MatrixUtil;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Kirill on 5/16/2016.
 */
public class MatrixUtilTest {
    @Test
    public void transpose() throws Exception {
        {
            boolean[][] input = new boolean[1][1];
            input[0][0] = true;
            boolean[][] output = MatrixUtil.transpose(input);
            Assert.assertEquals(1, output.length);
            Assert.assertEquals(1, output[0].length);
            Assert.assertEquals(true, output[0][0]);
        }

        {
            boolean[][] input = new boolean[2][2];
            input[0][0] = true; input[0][1] = false;
            input[1][0] = true; input[1][1] = false;

            boolean[][] output = MatrixUtil.transpose(input);
            Assert.assertEquals(2, output.length);
            Assert.assertEquals(2, output[0].length);
            Assert.assertEquals(true, output[0][0]); Assert.assertEquals(true, output[0][1]);
            Assert.assertEquals(false, output[1][0]); Assert.assertEquals(false, output[1][1]);
        }

        {
            boolean[][] input = new boolean[3][2];
            input[0][0] = true; input[0][1] = false;
            input[1][0] = true; input[1][1] = false;
            input[2][0] = true; input[2][1] = false;

            boolean[][] output = MatrixUtil.transpose(input);
            Assert.assertEquals(2, output.length);
            Assert.assertEquals(3, output[0].length);
            Assert.assertEquals(true, output[0][0]); Assert.assertEquals(true, output[0][1]); Assert.assertEquals(true, output[0][2]);
            Assert.assertEquals(false, output[1][0]); Assert.assertEquals(false, output[1][1]); Assert.assertEquals(false, output[1][2]);
        }
    }

    @Test
    public void rotateRight() throws Exception {
        {
            boolean[][] input = new boolean[1][1];
            input[0][0] = true;
            boolean[][] output = MatrixUtil.rotateRight(input);
            Assert.assertEquals(1, output.length);
            Assert.assertEquals(1, output[0].length);
            Assert.assertEquals(true, output[0][0]);
        }

        {
            boolean[][] input = new boolean[2][2];
            input[0][0] = true; input[0][1] = false;
            input[1][0] = true; input[1][1] = false;

            boolean[][] output = MatrixUtil.rotateRight(input);
            Assert.assertEquals(2, output.length);
            Assert.assertEquals(2, output[0].length);
            Assert.assertEquals(true, output[0][0]); Assert.assertEquals(true, output[0][1]);
            Assert.assertEquals(false, output[1][0]); Assert.assertEquals(false, output[1][1]);
        }

        {
            boolean[][] input = new boolean[3][2];
            input[0][0] = true; input[0][1] = false;
            input[1][0] = true; input[1][1] = false;
            input[2][0] = true; input[2][1] = false;

            boolean[][] output = MatrixUtil.rotateRight(input);
            Assert.assertEquals(2, output.length);
            Assert.assertEquals(3, output[0].length);
            Assert.assertEquals(true, output[0][0]); Assert.assertEquals(true, output[0][1]); Assert.assertEquals(true, output[0][2]);
            Assert.assertEquals(false, output[1][0]); Assert.assertEquals(false, output[1][1]); Assert.assertEquals(false, output[1][2]);
        }
    }

    @Test
    public void rotateLeft() throws Exception {
        {
            boolean[][] input = new boolean[1][1];
            input[0][0] = true;
            boolean[][] output = MatrixUtil.rotateLeft(input);
            Assert.assertEquals(1, output.length);
            Assert.assertEquals(1, output[0].length);
            Assert.assertEquals(true, output[0][0]);
        }

        {
            boolean[][] input = new boolean[2][2];
            input[0][0] = true; input[0][1] = false;
            input[1][0] = true; input[1][1] = false;

            boolean[][] output = MatrixUtil.rotateLeft(input);
            Assert.assertEquals(2, output.length);
            Assert.assertEquals(2, output[0].length);
            Assert.assertEquals(false, output[0][0]); Assert.assertEquals(false, output[0][1]);
            Assert.assertEquals(true, output[1][0]); Assert.assertEquals(true, output[1][1]);
        }

        {
            boolean[][] input = new boolean[3][2];
            input[0][0] = true; input[0][1] = false;
            input[1][0] = true; input[1][1] = false;
            input[2][0] = true; input[2][1] = false;

            boolean[][] output = MatrixUtil.rotateLeft(input);
            Assert.assertEquals(2, output.length);
            Assert.assertEquals(3, output[0].length);
            Assert.assertEquals(false, output[0][0]); Assert.assertEquals(false, output[0][1]); Assert.assertEquals(false, output[0][2]);
            Assert.assertEquals(true, output[1][0]); Assert.assertEquals(true, output[1][1]); Assert.assertEquals(true, output[1][2]);
        }
    }

}