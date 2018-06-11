package com.n1kredline;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Mine extends DeclineFigure {

    private Texture mineImage;
    private Sound explosionSound;

    public Mine(){
        super();

        mineImage = new Texture(Gdx.files.internal("mine.png"));
        explosionSound = Gdx.audio.newSound(Gdx.files.internal("explosion.mp3"));

    }
    @Override
    public void contact() {

    }

    @Override
    public void fallingFigure() {

    }

    @Override
    public void playAudio() {

    }

    @Override
    public void destroy() {

    }

    public void draw(SpriteBatch batch) {

            super.draw(batch, mineImage);

    }
}
