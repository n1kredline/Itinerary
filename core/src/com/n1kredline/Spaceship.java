package com.n1kredline;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Spaceship extends Figure {

    private Texture spaceshipImage;

    private static final int LEFT = Gdx.graphics.getWidth() / 6 - ((int)(Gdx.graphics.getWidth() * 0.25f) / 2);
    private static final int CENTER = Gdx.graphics.getWidth() / 2 - ((int)(Gdx.graphics.getWidth() * 0.25f) / 2);
    private static final int RIGHT = Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 6 - ((int)(Gdx.graphics.getWidth() * 0.25f) / 2);

    private int life = 1;
    private int score = 0;

    public Spaceship(Texture spaceshipImage) {
        super(spaceshipImage);

        this.spaceshipImage = spaceshipImage;

        super.width = (int) (Gdx.graphics.getWidth() * 0.25f);
        super.height = super.width * spaceshipImage.getHeight() / spaceshipImage.getWidth();
        super.x = CENTER;
        super.y = (int) (Gdx.graphics.getHeight() * 0.04f);

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

    public void contactHeart(){
        life += 1;
    }

    public void contactStar(){
        score += 10;
    }

    public void contactMine(){
        life -= 1;
    }

    public int getLife(){
        return life;
    }
}