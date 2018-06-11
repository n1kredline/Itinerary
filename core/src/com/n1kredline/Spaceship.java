package com.n1kredline;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Spaceship extends Figure {

    private final int LEFT;
    private final int CENTER;
    private final int RIGHT;

    private int life;

    private Texture spaceshipImage;
    private String name = "spaceship.png";

    public Spaceship() {
        super(Strname, );

        spaceshipImage = new Texture(Gdx.files.internal("spaceship.png"));

        super.width = (int) (Gdx.graphics.getWidth() * 0.25f);
        super.height = super.width * spaceshipImage.getHeight() / spaceshipImage.getWidth();
        super.x = Gdx.graphics.getWidth() / 2 - super.width / 2;
        super.y = (int) (Gdx.graphics.getHeight() * 0.04f);

        LEFT =  Gdx.graphics.getWidth() / 6 - super.width / 2;
        CENTER = Gdx.graphics.getWidth() / 2 - super.width / 2;
        RIGHT = Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 6 - super.width / 2;

        life = 0;

    }

    public void draw(SpriteBatch batch) {

        super.draw(batch, spaceshipImage);

    }

    public void stepLeft() {
        if (super.x == CENTER) {
            super.x = LEFT;
        } else if (super.x == RIGHT) {
            super.x = CENTER;
        }
    }

    public void stepRight() {
        if (super.x == CENTER) {
            super.x = RIGHT;
        } else if (super.x == LEFT) {
            super.x = CENTER;
        }
    }
}