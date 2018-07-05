package com.n1kredline;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class FallingFigure extends Figure {

    private Texture image;
    private Sound sound;

    private boolean active = true;

    public FallingFigure(Texture image, Sound sound) {
        super(image);
        this.image = image;
        this.sound = sound;
    }

    public void contactWithSpaceship(Spaceship spaceship) {
        playAudio();
    }

    public void fall(FallingFigure drop, float speed) {
        drop.y -= Math.round(speed * Gdx.graphics.getDeltaTime());
    }

    public void playAudio() {
        sound.play();
    }

    public boolean destroy(FallingFigure drop) {
        if (drop.y + drop.height < 0) {
            return true;
        }
        return false;
    }

    public void draw(SpriteBatch batch) {

        batch.draw(image, super.x, super.y, super.width, super.height);
    }

    public boolean overlaps(Figure r) {
        return x < r.x + r.width && x + width > r.x && y < r.y + r.height && y + height > r.y;
    }

    public void deactive(){
        active = false;
    }

    public boolean getActive(){
        return active;
    }

}