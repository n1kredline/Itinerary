package com.n1kredline;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;

public class ItineraryInputController implements InputProcessor {

    private Spaceship spaceship;

    public ItineraryInputController(Spaceship spaceship) {
        this.spaceship = spaceship;
    }

    @Override
    public boolean keyDown(int keycode) {
        if (keycode == Input.Keys.LEFT) {
            spaceship.leftController();
        } else if (keycode == Input.Keys.RIGHT) {
            spaceship.righrController();
        }

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
