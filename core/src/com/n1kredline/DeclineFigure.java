package com.n1kredline;

import com.badlogic.gdx.graphics.Texture;

public abstract class DeclineFigure extends Figure {

    public DeclineFigure(String nameImage) {
        super(nameImage);
    }

    public abstract void contact();

    public abstract void fallingFigure();

    public abstract void playAudio();

    public abstract void destroy();

}