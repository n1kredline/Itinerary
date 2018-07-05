package com.n1kredline;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

public class MegaItineraryGame extends ApplicationAdapter {

    private Spaceship spaceship;

    private Texture spaceshipImage;
    private Texture starImage;
    private Texture mineImage;
    private Texture heartImage;

    private Music spacesMusic;
    private Sound starSound;
    private Sound explosionSound;
    private Sound heartSound;

    private OrthographicCamera camera;
    private SpriteBatch batch;
    private ItineraryInputController itineraryInputController;

    private Array<FallingFigure> figures;

    private float speed = 45;

    public void fileCreate() {

        spaceshipImage = new Texture(Gdx.files.internal("spaceship.png"));
        starImage = new Texture(Gdx.files.internal("star.png"));
        mineImage = new Texture(Gdx.files.internal("mine.png"));
        heartImage = new Texture(Gdx.files.internal("heart.png"));

        spacesMusic = Gdx.audio.newMusic(Gdx.files.internal("spaces.mp3"));

        starSound = Gdx.audio.newSound(Gdx.files.internal("star.mp3"));
        explosionSound = Gdx.audio.newSound(Gdx.files.internal("explosion.mp3"));
        heartSound = Gdx.audio.newSound(Gdx.files.internal("heart.mp3"));


    }

    @Override
    public void create() {
        fileCreate();

        spaceship = new Spaceship(spaceshipImage);

        spacesMusic.setLooping(true);
        spacesMusic.play();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch = new SpriteBatch();

        itineraryInputController = new ItineraryInputController(spaceship);
        Gdx.input.setInputProcessor(itineraryInputController);

        figures = new Array<FallingFigure>();

        spawn();

    }

    private void spawn() {
        int x = (int) (Math.random() * 17);
        if(x <= 7){
            figures.add(new Star(starImage, starSound));
        }else if (x <= 15){
            figures.add(new Mine(mineImage, explosionSound));
        }else if(x == 16){
            figures.add(new Heart(heartImage, heartSound));
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        spaceship.draw(batch);
        for (FallingFigure drop : figures) {
            drop.draw(batch);
        }
        batch.end();

        Iterator<FallingFigure> iter = figures.iterator();
        while (iter.hasNext()) {
            FallingFigure drop = iter.next();
            drop.fall(drop, speed);
            if(drop.y < Gdx.graphics.getHeight() * 0.7 && drop.getActive()){
                spawn();
                drop.deactive();
            }
            if (drop.destroy(drop)) {
                iter.remove();
            }
            if (drop.overlaps(spaceship)) {
                drop.contactWithSpaceship(spaceship);
                iter.remove();
            }
        }
        speed += 0.1f;
        if (spaceship.getLife() < 1) {
            System.exit(0);
        }
    }

    @Override
    public void dispose() {
        starImage.dispose();
        spaceshipImage.dispose();
        mineImage.dispose();
        heartImage.dispose();
        starSound.dispose();
        explosionSound.dispose();
        heartSound.dispose();
        spacesMusic.dispose();
        batch.dispose();
    }
}