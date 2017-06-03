package huds;


import com.awesome.jackgiant.GameMain;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

import helpers.GameInfo;
import scenes.Gameplay;
import scenes.Highscore;
import scenes.Options;

public class MainMenuButtons {

    private GameMain game;
    private Stage stage;
    private Viewport gameViewport;

    private ImageButton playBtn;
    private ImageButton hightscoreBtn;
    private ImageButton optionsBtn;
    private ImageButton quitBtn;
    private ImageButton musicBtn;

    public MainMenuButtons(GameMain game){
        this.game = game;

        gameViewport = new FitViewport(GameInfo.WIDTH, GameInfo.HEIGHT,
                new OrthographicCamera());

        stage = new Stage(gameViewport, game.getBatch());

        Gdx.input.setInputProcessor(stage);

        createAndPositionButtons();

        addAllListeners();

        stage.addActor(playBtn);
        stage.addActor(hightscoreBtn);
        stage.addActor(optionsBtn);
        stage.addActor(quitBtn);
        stage.addActor(musicBtn);
    }

    void createAndPositionButtons(){
        playBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/Main Menu/Start Game.png"))));

        hightscoreBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/Main Menu/Highscore.png"))));

        optionsBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/Main Menu/Options.png"))));

        quitBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/Main Menu/Quit.png"))));

        musicBtn = new ImageButton(new SpriteDrawable(new Sprite(
                new Texture("Buttons/Main Menu/Music On.png"))));

        playBtn.setPosition(GameInfo.WIDTH / 2 - 80, GameInfo.HEIGHT / 2 + 50,
                Align.center);


        hightscoreBtn.setPosition(GameInfo.WIDTH / 2 - 60, GameInfo.HEIGHT / 2 - 20,
                Align.center);


        optionsBtn.setPosition(GameInfo.WIDTH / 2 -40, GameInfo.HEIGHT / 2 - 90,
                Align.center);


        quitBtn.setPosition(GameInfo.WIDTH / 2 - 20, GameInfo.HEIGHT / 2 - 160,
                Align.center);


        musicBtn.setPosition(GameInfo.WIDTH - 35, 35, Align.center);



    }

    void addAllListeners(){
        playBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new Gameplay(game));
            }
        });

        hightscoreBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new Highscore(game));
            }
        });

        optionsBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new Options(game));
            }
        });

        quitBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

            }
        });

        musicBtn.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {

            }
        });
    }

    public Stage getStage(){
        return this.stage;
    }

}
