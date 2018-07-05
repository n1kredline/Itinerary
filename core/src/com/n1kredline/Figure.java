package com.n1kredline;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.awt.Rectangle;

public abstract class Figure extends Rectangle{

    public Figure(Texture image){

        super.width = (int) (Gdx.graphics.getWidth() * 0.25f);
        super.height = super.width * image.getHeight() / image.getWidth();

    }

    public void draw(SpriteBatch batch, Texture image){

        batch.draw(image, super.x, super.y, super.width, super.height);

    }
}