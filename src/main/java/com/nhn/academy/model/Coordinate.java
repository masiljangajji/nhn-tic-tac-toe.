package com.nhn.academy.model;

/**
 * 좌표를 나타내는 Class.
 */
public class Coordinate {

    private final int yidx;
    private final int xidx;

    public Coordinate(int yidx, int xidx) {
        this.yidx = yidx;
        this.xidx = xidx;
    }

    public int getY() {
        return yidx;
    }

    public int getX() {
        return xidx;
    }
}
