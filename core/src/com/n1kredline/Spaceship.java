package com.n1kredline;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class Spaceship {

    private final float LEFT;
    private final float CENTRE;
    private final float RIGHT;

    private float position;
    private int life;

    private Rectangle spaceship;
    private Texture spaceshipImage;

    public Spaceship() {

        spaceship = new Rectangle();

        spaceshipImage = new Texture(Gdx.files.internal("spaceship.png"));

        spaceship.width = Gdx.graphics.getWidth() * 0.25f;
        spaceship.height = spaceship.width * spaceshipImage.getHeight() / spaceshipImage.getWidth();
        spaceship.x = Gdx.graphics.getWidth() / 2 - spaceship.width / 2;
        spaceship.y = Gdx.graphics.getHeight() * 0.04f;

        LEFT = Gdx.graphics.getWidth() / 6 - spaceship.width / 2;
        CENTRE = Gdx.graphics.getWidth() / 2 - spaceship.width / 2;
        RIGHT = Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 6 - spaceship.width / 2;

        position = CENTRE;
        life = 0;
    }

    public void draw(SpriteBatch batch) {

        batch.draw(spaceshipImage, position, spaceship.y, spaceship.width, spaceship.height);
    }

    public Rectangle getSpaceship() {
        return spaceship;
    }

    public void leftController() {
        if (position == CENTRE) {
            position = LEFT;
        } else if (position == RIGHT) {
            position = CENTRE;
        }
    }

    public void righrController() {
        if (position == CENTRE) {
            position = RIGHT;
        } else if (position == LEFT) {
            position = CENTRE;
        }
    }
}