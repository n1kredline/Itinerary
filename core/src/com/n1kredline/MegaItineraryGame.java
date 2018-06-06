package com.n1kredline;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MegaItineraryGame extends ApplicationAdapter {

    private Spaceship spaceship;

    private Texture spaceshipImage;
    private Texture starImage;
    private Texture heartImage;
    private Texture mineImage;

    private Sound explosionSound;
    private Sound heartSound;
    private Sound starSound;
    private Music spacesMusic;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private ItineraryInputController itineraryInputController;

    public void fileCreate() {
        spaceshipImage = new Texture(Gdx.files.internal("spaceship.png"));
        starImage = new Texture(Gdx.files.internal("star.png"));
        heartImage = new Texture(Gdx.files.internal("heart.png"));
        mineImage = new Texture(Gdx.files.internal("mine.png"));

        explosionSound = Gdx.audio.newSound(Gdx.files.internal("explosion.mp3"));
        heartSound = Gdx.audio.newSound(Gdx.files.internal("heart.mp3"));
        starSound = Gdx.audio.newSound(Gdx.files.internal("star.mp3"));
        spacesMusic = Gdx.audio.newMusic(Gdx.files.internal("spaces.mp3"));
    }

    @Override
    public void create() {
        fileCreate();

        spaceship = new Spaceship();

        spacesMusic.setLooping(true);
        spacesMusic.play();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch = new SpriteBatch();

        itineraryInputController = new ItineraryInputController(spaceship);
        Gdx.input.setInputProcessor(itineraryInputController);
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