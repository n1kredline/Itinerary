package com.n1kredline;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Mine extends FallingFigure {

    private Texture mineImage;

    public Mine(Texture mineImage, Sound explosionSound) {
        super(mineImage, explosionSound);

        this.mineImage = mineImage;

        int[] mas = new int[3];
        mas[0] = Gdx.graphics.getWidth() / 6 - ((int) (Gdx.graphics.getWidth() * 0.25f) / 2);
        mas[1] = Gdx.graphics.getWidth() / 2 - ((int) (Gdx.graphics.getWidth() * 0.25f) / 2);
        mas[2] = Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 6 - ((int) (Gdx.graphics.getWidth() * 0.25f) / 2);

        int x = (int) (Math.random() * 3);

        super.width = (int) (Gdx.graphics.getWidth() * 0.25f);
        super.height = super.width * mineImage.getHeight() / mineImage.getWidth();
        super.x = mas[x];
        super.y = Gdx.graphics.getHeight() - super.height;

    }

    @Override
    public void contactWithSpaceship(Spaceship spaceship) {
        super.contactWithSpaceship(spaceship);
        spaceship.contactMine();
    }

    @Override
    public void draw(SpriteBatch batch) {

        super.draw(batch, mineImage);

    }
}