package com.n1kredline;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

public class MegaItineraryGame extends ApplicationAdapter {

    private Spaceship spaceship;
    private Star star;
    private Mine mine;
    private Heart heart;

    private Music spacesMusic;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private ItineraryInputController itineraryInputController;

    private Array<DeclineFigure> figures;
    private long lastDropTime;

    public void fileCreate() {

        spacesMusic = Gdx.audio.newMusic(Gdx.files.internal("spaces.mp3"));
    }

    @Override
    public void create() {
        fileCreate();

        spaceship = new Spaceship();
        star = new Star();
        mine = new Mine();
        heart = new Heart();

        spacesMusic.setLooping(true);
        spacesMusic.play();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch = new SpriteBatch();

        itineraryInputController = new ItineraryInputController(spaceship);
        Gdx.input.setInputProcessor(itineraryInputController);

        figures = new Array<DeclineFigure>();
        spawn();
    }

    private void spawn() {
        Rectangle raindrop = new Rectangle();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        spaceship.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {

    }
}