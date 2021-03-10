package com.mebk.survivorbird;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;

import java.util.Random;

public class Flash extends ApplicationAdapter {
	SpriteBatch batch;
	Texture background;
	Texture bird;
	float birdX = 0;
	float birdY = 0;
	int gameState = 0;
	float velocity = 0;
	float gravity = 0.1f;
	Texture dusman1;
	Texture dusman2;
	Texture dusman3;

	int dusmanSetiSayim =4;
	float[] dusmanX = new float[dusmanSetiSayim];

	float distance =0;
	float dusmanHizi=2;
	Random random;
	float[] enemyOffSet = new float[dusmanSetiSayim];
	float[] enemyOffSet2 = new float[dusmanSetiSayim];
	float[] enemyOffSet3 = new float[dusmanSetiSayim];
	Circle birdCircle;
	Circle[] enemyCircles;
	Circle[] enemyCircles2;
	Circle[] enemyCircles3;
int score=0;
int scoredDusman=0;
BitmapFont font;

	@Override
	public void create () {
		batch =	new SpriteBatch();
		background = new Texture("arkaplan.png");
		bird = new Texture("biz.png");
		birdX = Gdx.graphics.getWidth() / 9;
		birdY = Gdx.graphics.getHeight() / 3;
		dusman1 = new Texture("dusman.png");
		dusman2 = new Texture("dusman.png");
		dusman3 = new Texture("dusman.png");
		distance =Gdx.graphics.getWidth() /2;
		random = new Random();
		birdCircle = new Circle();
		enemyCircles = new Circle[dusmanSetiSayim];
		enemyCircles2 = new Circle[dusmanSetiSayim];
		enemyCircles3 = new Circle[dusmanSetiSayim];

font = new BitmapFont();
font.setColor(Color.WHITE);
font.getData().setScale(4);
		for (int i=0; i<dusmanSetiSayim; i++) {

			enemyOffSet[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
			enemyOffSet2[i] = (random.nextFloat() - 0.5f)* (Gdx.graphics.getHeight() - 200);
			enemyOffSet3[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);

			dusmanX[i] = Gdx.graphics.getWidth() + i * distance;

			enemyCircles[i]=new Circle();
			enemyCircles2[i]=new Circle();
			enemyCircles3[i]=new Circle();




		}



	}

	@Override
	public void render () {
		batch.begin();

		batch.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


		if (gameState == 1) {

			if (dusmanX[scoredDusman] < Gdx.graphics.getWidth() / 9) {
				score++;

				if (scoredDusman < dusmanSetiSayim - 1) {
					scoredDusman++;
				} else {
					scoredDusman = 0;
				}

			}

			for (int i = 0; i < dusmanSetiSayim; i++) {

				if (dusmanX[i] < Gdx.graphics.getWidth() / 15) {

					enemyOffSet[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
					enemyOffSet2[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
					enemyOffSet3[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);

					dusmanX[i] = dusmanX[i] + dusmanSetiSayim * distance;

				} else {

					dusmanX[i] -= dusmanHizi;
				}


				batch.draw(dusman1, dusmanX[i], Gdx.graphics.getHeight() / 2 + enemyOffSet[i], Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() / 10);
				batch.draw(dusman2, dusmanX[i], Gdx.graphics.getHeight() / 2 + enemyOffSet2[i], Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() / 10);
				batch.draw(dusman3, dusmanX[i], Gdx.graphics.getHeight() / 2 + enemyOffSet3[i], Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() / 10);

				enemyCircles[i] = new Circle(dusmanX[i] + Gdx.graphics.getWidth() / 30, Gdx.graphics.getHeight() / 2 + enemyOffSet[i] + Gdx.graphics.getHeight() / 20, Gdx.graphics.getWidth() / 30);
				enemyCircles2[i] = new Circle(dusmanX[i] + Gdx.graphics.getWidth() / 30, Gdx.graphics.getHeight() / 2 + enemyOffSet2[i] + Gdx.graphics.getHeight() / 20, Gdx.graphics.getWidth() / 30);
				enemyCircles3[i] = new Circle(dusmanX[i] + Gdx.graphics.getWidth() / 30, Gdx.graphics.getHeight() / 2 + enemyOffSet3[i] + Gdx.graphics.getHeight() / 20, Gdx.graphics.getWidth() / 30);
			}


			if (Gdx.input.justTouched()) {
				velocity = -7;

			}


			if (birdY > 0 ) {
				velocity = velocity + gravity;
				birdY = birdY - velocity;
			}else{
				gameState=2;
			}

		} else if (gameState ==0) {
			if (Gdx.input.justTouched()) {
				gameState = 1;

			}

		}
		else if (gameState ==2) {
			if (Gdx.input.justTouched()) {
				gameState = 1;

				birdY = Gdx.graphics.getHeight() / 3;

				for (int i=0; i<dusmanSetiSayim; i++) {

					enemyOffSet[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);
					enemyOffSet2[i] = (random.nextFloat() - 0.5f)* (Gdx.graphics.getHeight() - 200);
					enemyOffSet3[i] = (random.nextFloat() - 0.5f) * (Gdx.graphics.getHeight() - 200);

					dusmanX[i] = Gdx.graphics.getWidth() + i * distance;

					enemyCircles[i]=new Circle();
					enemyCircles2[i]=new Circle();
					enemyCircles3[i]=new Circle();

				}velocity=0; scoredDusman=0; score=0;

			}
		}


		batch.draw(bird, birdX, birdY, Gdx.graphics.getWidth() / 15, Gdx.graphics.getHeight() / 10);
		font.draw(batch,String.valueOf(score),100,200);

		batch.end();

		birdCircle.set(birdX + Gdx.graphics.getWidth() / 30, birdY + Gdx.graphics.getHeight() / 20, Gdx.graphics.getWidth() / 30);

		for (int i = 0; i < dusmanSetiSayim; i++) {
			if (Intersector.overlaps(birdCircle, enemyCircles[i]) || Intersector.overlaps(birdCircle, enemyCircles2[i]) || Intersector.overlaps(birdCircle, enemyCircles3[i])) {
				gameState = 2;
			}
		}
	}
	@Override
	public void dispose () {

	}
}
