package com.example.tetris.models;

import android.graphics.Color;
import android.graphics.Point;

import com.example.tetris.constants.FieldConstants;
import androidx.annotation.NonNull;

import java.util.Random;

public class Block {
    private int shapeIndex;
    private int frameNumber;
    private BlockColor color;
    private Point position;

    private Block(int shapeIndex, BlockColor blockColor) {
        this.frameNumber = 0;
        this.shapeIndex = shapeIndex;
        this.color = blockColor;
        this.position = new Point(FieldConstants.COLUMN_COUNT.getValue() / 2, 0);
    }

    public static Block createBlock() {
        Random random = new Random();
        int shapeIndex = random.nextInt(Shape.values().length);
        BlockColor blockColor = BlockColor.values()
                [random.nextInt(BlockColor.values().length)];

        Block block = new Block(shapeIndex, blockColor);
        block.position.x = block.position.x - Shape.values()
                [shapeIndex].getStartPosition();
        return block;
    }

    public enum BlockColor {
        PURPLE(Color.rgb(150, 0, 205), (byte) 2),
        GREEN(Color.rgb(0, 128, 0), (byte) 2),
        ORANGE(Color.rgb(255, 140, 0), (byte) 2),
        SILVER(Color.rgb(196, 202, 206), (byte) 2),
        RED(Color.rgb(128, 0, 0), (byte) 2);

        BlockColor(int rgbValue, byte byteValue) {
            this.rgbValue = rgbValue;
            this.byteValue = byteValue;
        }

        private final int rgbValue;
        private final byte byteValue;
    }

    public static int getColor(byte value) {
        for (BlockColor color : BlockColor.values()) {
            if (value == color.byteValue) {
                return color.rgbValue;
            }
        }
        return -1;
    }

    public final void setState(int frame, Point position) {
        this.frameNumber = frame;
        this.position = position;
    }

    @NonNull
    public final byte[][] getShape(int frameNumber) {
        return Shape.values()[shapeIndex].getFrame(frameNumber).as2dByteArray();
    }

    public Point getPosition() {
        return this.position;
    }

    public final int getFrameCount() {
        return Shape.values()[shapeIndex].getFrameCount();
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public int getColor() {
        return color.rgbValue;
    }

    public byte getStaticValue() {
        return color.byteValue;
    }
}
