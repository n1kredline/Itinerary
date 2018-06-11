package com.n1kredline;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Heart extends DeclineFigure {

    private Texture heartImage;
    private Sound heartSound;

    public Heart() {
        super();

        heartImage = new Texture(Gdx.files.internal("heart.png"));
        heartSound = Gdx.audio.newSound(Gdx.files.internal("heart.mp3"));

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

        super.draw(batch, heartImage);

    }
}
