package org.oaksoft.tutorial.controller;

public class WalkingVirtualController {

    public Direction currentDirection = Direction.NORTH;

    public boolean isWalking = false;

    public enum Direction {
        NORTH, SOUTH, EAST, WEST
    }
}
