package com.n1kredline;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class MegaItineraryGame extends ApplicationAdapter {

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

	private Rectangle spaceship;

	public void fileCreate () {
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
	public void create () {
		fileCreate();

		spacesMusic.setLooping(true);
		spacesMusic.play();

		camera = new OrthographicCamera();
		camera.setToOrtho(false, 480, 800);

		batch = new SpriteBatch();

		spaceship = new Rectangle();
		spaceship.width = Gdx.graphics.getWidth() * 0.25f;
		spaceship.height = spaceship.width * spaceshipImage.getHeight()/spaceshipImage.getWidth();
		spaceship.x = Gdx.graphics.getWidth() / 2 - spaceship.width / 2;
		spaceship.y = Gdx.graphics.getHeight() * 0.04f;

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();

		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		batch.draw(spaceshipImage,spaceship.x,spaceship.y,spaceship.width,spaceship.height);

		batch.setProjectionMatrix(camera.combined);
		batch.draw(spaceshipImage,Gdx.graphics.getWidth() / 6 - spaceship.width / 2, spaceship.y,spaceship.width,spaceship.height);

		batch.setProjectionMatrix(camera.combined);
		batch.draw(spaceshipImage,Gdx.graphics.getWidth() - Gdx.graphics.getWidth() / 6 - spaceship.width / 2,spaceship.y,spaceship.width,spaceship.height);
		batch.end();

/*		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) spaceship.x -= Gdx.graphics.getWidth() / 3 - spaceship.width / 2;
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) spaceship.x += Gdx.graphics.getWidth() / 3 - spaceship.width / 2;

        if(spaceship.x < 0) spaceship.x = Gdx.graphics.getWidth() / 3 - spaceship.width / 2;
        if(spaceship.x > Gdx.graphics.getWidth() - 64) spaceship.x = 800 - 64;
*/	}

	@Override
	public void dispose () {

	}
}