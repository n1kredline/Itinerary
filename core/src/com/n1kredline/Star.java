package com.n1kredline;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;

import java.util.Iterator;

public class Star extends DeclineFigure {

    private Texture starImage;
    private Sound starSound;

    public Star() {
        super();

        starImage = new Texture(Gdx.files.internal("star.png"));
        starSound = Gdx.audio.newSound(Gdx.files.internal("star.mp3"));

        super.width = (int) (Gdx.graphics.getWidth() * 0.25f);
        super.height = super.width * starImage.getHeight() / starImage.getWidth();
        super.x = MathUtils.random(0, 800 - 64);
        super.y = Gdx.graphics.getHeight();

    }

    @Override
    public void contact() {

    }

    @Override
    public void fallingFigure() {
        Iterator<Star> iter = stardrops.iterator();
        while (iter.hasNext()) {
            Star stardrop = iter.next();
            stardrop.y -= 200 * Gdx.graphics.getDeltaTime();
            if (stardrop.y + 64 < 0) iter.remove();
        }
    }

    public void draw(SpriteBatch batch) {

        super.draw(batch, starImage);

    }

    @Override
    public void playAudio() {

    }

    @Override
    public void destroy() {

    }
}
