package org.oaksoft.tutorial.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import org.oaksoft.tutorial.controller.WalkingVirtualController;

import java.util.HashSet;
import java.util.Set;

public class WalkingHandler extends InputAdapter {

    private WalkingVirtualController controller;

    private Set<Integer> currentPressedButtons;

    public WalkingHandler(WalkingVirtualController controller) {
        this.controller = controller;
        currentPressedButtons = new HashSet<>();
    }

    @Override
    public boolean keyDown(int keycode) {

        controller.isWalking = true;

        switch (keycode) {
            case Input.Keys.W:
                controller.currentDirection = WalkingVirtualController.Direction.NORTH;
                currentPressedButtons.add(Input.Keys.W);
                break;

            case Input.Keys.S:
                controller.currentDirection = WalkingVirtualController.Direction.SOUTH;
                currentPressedButtons.add(Input.Keys.S);
                break;

            case Input.Keys.D:
                controller.currentDirection = WalkingVirtualController.Direction.EAST;
                currentPressedButtons.add(Input.Keys.D);
                break;

            case Input.Keys.A:
                controller.currentDirection = WalkingVirtualController.Direction.WEST;
                currentPressedButtons.add(Input.Keys.A);
                break;
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {

        currentPressedButtons.remove(keycode);

        if (currentPressedButtons.isEmpty()) {
            controller.isWalking = false;
        }

        return true;
    }
}