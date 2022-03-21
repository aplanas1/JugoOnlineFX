package com.example.cazapatos;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game extends Application {

    Pane root = new Pane();

    Label lbl = new Label();
    Label lblscore = new Label();

    Label top = new Label();
    Label top1 = new Label();
    Label top2 = new Label();
    Label top3 = new Label();

    Label char1 = new Label();
    Label char2 = new Label();
    Label char3 = new Label();
    Button plus1 = new Button();
    Button plus2 = new Button();
    Button plus3 = new Button();
    Button menos1 = new Button();
    Button menos2 = new Button();
    Button menos3 = new Button();

    String nombre;

    int score = 0;
    int gamealive = 1;

    char letra = 65;
    char letra2 = 65;
    char letra3 = 65;

    int complete = 0;
    Image splash = new Image(getClass().getResourceAsStream("pics/splash.jpg"));
    ImageView splashscreen = new ImageView();
    
    Image wood = new Image(getClass().getResourceAsStream("pics/bg.jpg"));
    ImageView background = new ImageView();
    
    Image target = new Image(getClass().getResourceAsStream("pics/pointer.png"));
    ImageView targett = new ImageView(target);

    Bird bird1 = new Bird();
    Bird bird2 = new Bird();
    Bird bird3 = new Bird();
    Bird bird4 = new Bird();
    Canary canary1 = new Canary();
    Canary canary2 = new Canary();
    
    Button btn = new Button();
    Button btnrestart = new Button();
    
    Image gameover = new Image(getClass().getResourceAsStream("pics/splash.jpg"));
    ImageView gmeovr = new ImageView(gameover);

    public Game() throws IOException {
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        
        lbl.setLayoutX(5); lbl.setLayoutY(5);
        lbl.setText("SCORE:");
        lbl.setFont(new Font("Chiller",30));
        lbl.setTextFill(Color.RED);
        
        lblscore.setLayoutX(100); lblscore.setLayoutY(5);
        lblscore.setText("0");
        lblscore.setFont(new Font("Chiller",30));
        lblscore.setTextFill(Color.RED);
       
        gmeovr.setX(85); gmeovr.setY(80);
        gmeovr.setFitWidth(300); gmeovr.setFitHeight(300);
        gmeovr.setOpacity(0);
        
        background.setImage(wood);
        background.setX(5); background.setY(50);
        background.setFitWidth(1280); background.setFitHeight(720);
        background.setOpacity(0);
        
        splashscreen.setImage(splash);
        splashscreen.setX(5); splashscreen.setY(50);
        splashscreen.setFitWidth(1280); splashscreen.setFitHeight(720);
        
        targett.setX(85); targett.setY(80);
        targett.setFitWidth(500); targett.setFitHeight(500);

        char1.setLayoutX(100); char1.setLayoutY(200);
        char1.setText(Character.toString(letra));
        char1.setFont(new Font("Chiller",30));
        char1.setTextFill(Color.RED);
        char1.setOpacity(1);
        char2.setLayoutX(150); char2.setLayoutY(200);
        char2.setText(Character.toString(letra2));
        char2.setFont(new Font("Chiller",30));
        char2.setTextFill(Color.RED);
        char2.setOpacity(1);
        char3.setLayoutX(200); char3.setLayoutY(200);
        char3.setText(Character.toString(letra3));
        char3.setFont(new Font("Chiller",30));
        char3.setTextFill(Color.RED);
        char3.setOpacity(1);

        plus1.setText("+");
        plus1.setLayoutX(100); plus1.setLayoutY(150);
        plus1.setOpacity(1);
        plus1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(plus1.getOpacity() == 1){
                    if(letra==90)letra-=26;
                    letra++;
                    char1.setText(Character.toString(letra));
                }
            }
        });
        menos1.setText("-");
        menos1.setLayoutX(100); menos1.setLayoutY(250);
        menos1.setOpacity(1);
        menos1.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(menos1.getOpacity() == 1){
                    if(letra==65)letra+=26;
                    letra--;
                    char1.setText(Character.toString(letra));
                }
            }
        });

        plus2.setText("+");
        plus2.setLayoutX(150); plus2.setLayoutY(150);
        plus2.setOpacity(1);
        plus2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(plus2.getOpacity() == 1){
                    if(letra2==90)letra2-=26;
                    letra2++;
                    char2.setText(Character.toString(letra2));
                }
            }
        });
        menos2.setText("-");
        menos2.setLayoutX(150); menos2.setLayoutY(250);
        menos2.setOpacity(1);
        menos2.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(menos2.getOpacity() == 1){
                    if(letra2==65)letra2+=26;
                    letra2--;
                    char2.setText(Character.toString(letra2));
                }
            }
        });

        plus3.setText("+");
        plus3.setLayoutX(200); plus3.setLayoutY(150);
        plus3.setOpacity(1);
        plus3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(plus3.getOpacity() == 1){
                    if(letra3==90)letra3-=26;
                    letra3++;
                    char3.setText(Character.toString(letra3));
                }
            }
        });
        menos3.setText("-");
        menos3.setLayoutX(200); menos3.setLayoutY(250);
        menos3.setOpacity(1);
        menos3.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if(menos3.getOpacity() == 1){
                    if(letra3==65)letra3+=26;
                    letra3--;
                    char3.setText(Character.toString(letra3));
                }
            }
        });

        // BIRDS
        // START BIRD 1
        bird1.getBirdo().setX(5);
        bird1.getBirdo().setY(60);
        bird1.getBirdo().setFitWidth(150);
        bird1.getBirdo().setFitHeight(150);

        bird1.getFt().setFromValue(1.0);
        bird1.getFt().setToValue(0.0);
        bird1.getFt().setCycleCount(1);

        bird1.getPath().getElements().add(new MoveTo(-10,100));
        bird1.getPath().getElements().add(new HLineTo(1400));
        bird1.getPathTransition().setDuration(Duration.seconds(2));
        bird1.getPathTransition().setPath(bird1.getPath());
        bird1.getPathTransition().setNode(bird1.getBirdo());
        bird1.getPathTransition().setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        bird1.getPathTransition().setCycleCount(Timeline.INDEFINITE);

        bird1.getBirdo().setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (bird1.getFlag() == 0 && gamealive == 1){
                    bird1.getPathTransition().stop();
                    bird1.getFt().play();
                    bird1.getBirdo().setImage(bird1.getBlood());
                    score(5);
                    complete++;
                    if (complete == 4) {
                        next();
                    }
                }
                bird1.setFlag(1);
            }

        });
        // END BIRD 1

        // START BIRD 2
        bird2.getBirdo().setX(5);
        bird2.getBirdo().setY(60);
        bird2.getBirdo().setFitWidth(150);
        bird2.getBirdo().setFitHeight(150);

        bird2.getFt().setFromValue(1.0);
        bird2.getFt().setToValue(0.0);
        bird2.getFt().setCycleCount(1);

        bird2.getPath().getElements().add(new MoveTo(-10,100));
        bird2.getPath().getElements().add(new HLineTo(1400));
        bird2.getPathTransition().setDuration(Duration.seconds(9));
        bird2.getPathTransition().setPath(bird2.getPath());
        bird2.getPathTransition().setNode(bird2.getBirdo());
        bird2.getPathTransition().setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        bird2.getPathTransition().setCycleCount(Timeline.INDEFINITE);

        bird2.getBirdo().setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (bird2.getFlag() == 0 && gamealive == 1){
                    bird2.getPathTransition().stop();
                    bird2.getFt().play();
                    bird2.getBirdo().setImage(bird2.getBlood());
                    score(5);
                    complete++;
                    if (complete == 4) {
                        next();
                    }
                }
                bird2.setFlag(1);
            }

        });
        // END BIRD 2

        // START BIRD 3
        bird3.getBirdo().setX(5);
        bird3.getBirdo().setY(60);
        bird3.getBirdo().setFitWidth(150);
        bird3.getBirdo().setFitHeight(150);

        bird3.getFt().setFromValue(1.0);
        bird3.getFt().setToValue(0.0);
        bird3.getFt().setCycleCount(1);

        bird3.getPath().getElements().add(new MoveTo(-10,100));
        bird3.getPath().getElements().add(new HLineTo(1400));
        bird3.getPathTransition().setDuration(Duration.seconds(7));
        bird3.getPathTransition().setPath(bird3.getPath());
        bird3.getPathTransition().setNode(bird3.getBirdo());
        bird3.getPathTransition().setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        bird3.getPathTransition().setCycleCount(Timeline.INDEFINITE);

        bird3.getBirdo().setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (bird3.getFlag() == 0 && gamealive == 1){
                    bird3.getPathTransition().stop();
                    bird3.getFt().play();
                    bird3.getBirdo().setImage(bird3.getBlood());
                    score(15);
                    complete++;
                    if (complete == 4) {
                        next();
                    }
                }
                bird3.setFlag(1);
            }

        });
        // END BIRD 3

        // START BIRD 4
        bird4.getBirdo().setX(5);
        bird4.getBirdo().setY(60);
        bird4.getBirdo().setFitWidth(150);
        bird4.getBirdo().setFitHeight(150);

        bird4.getFt().setFromValue(1.0);
        bird4.getFt().setToValue(0.0);
        bird4.getFt().setCycleCount(1);

        bird4.getPath().getElements().add(new MoveTo(-10,100));
        bird4.getPath().getElements().add(new HLineTo(1400));
        bird4.getPathTransition().setDuration(Duration.seconds(12));
        bird4.getPathTransition().setPath(bird4.getPath());
        bird4.getPathTransition().setNode(bird4.getBirdo());
        bird4.getPathTransition().setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        bird4.getPathTransition().setCycleCount(Timeline.INDEFINITE);

        bird4.getBirdo().setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (bird4.getFlag() == 0 && gamealive == 1){
                    bird4.getPathTransition().stop();
                    bird4.getFt().play();
                    bird4.getBirdo().setImage(bird4.getBlood());
                    score(10);
                    complete++;
                    if (complete == 4) {
                        next();
                    }
                }
                bird4.setFlag(1);
            }

        });
        // END BIRD 4

        // START CANARY 1
        canary1.getBirdo().setX(5);
        canary1.getBirdo().setY(60);
        canary1.getBirdo().setFitWidth(150);
        canary1.getBirdo().setFitHeight(150);

        canary1.getFt().setFromValue(1.0);
        canary1.getFt().setToValue(0.0);
        canary1.getFt().setCycleCount(1);

        canary1.getPath().getElements().add(new MoveTo(-10,100));
        canary1.getPath().getElements().add(new HLineTo(1400));
        canary1.getPathTransition().setDuration(Duration.seconds(4));
        canary1.getPathTransition().setPath(canary1.getPath());
        canary1.getPathTransition().setNode(canary1.getBirdo());
        canary1.getPathTransition().setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        canary1.getPathTransition().setCycleCount(Timeline.INDEFINITE);

        canary1.getBirdo().setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (canary1.getFlag() == 0 && gamealive == 1){
                    canary1.getPathTransition().stop();
                    canary1.getFt().play();
                    canary1.getBirdo().setImage(canary1.getBlood());
                    score(15);
                    gameover();
                }
                canary1.setFlag(1);
            }

        });
        // END CANARY 1

        // START CANARY 2
        canary2.getBirdo().setX(5);
        canary2.getBirdo().setY(60);
        canary2.getBirdo().setFitWidth(150);
        canary2.getBirdo().setFitHeight(150);

        canary2.getFt().setFromValue(1.0);
        canary2.getFt().setToValue(0.0);
        canary2.getFt().setCycleCount(1);

        canary2.getPath().getElements().add(new MoveTo(-10,100));
        canary2.getPath().getElements().add(new HLineTo(1400));
        canary2.getPathTransition().setDuration(Duration.seconds(5));
        canary2.getPathTransition().setPath(canary2.getPath());
        canary2.getPathTransition().setNode(canary2.getBirdo());
        canary2.getPathTransition().setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        canary2.getPathTransition().setCycleCount(Timeline.INDEFINITE);

        canary2.getBirdo().setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (canary2.getFlag() == 0 && gamealive == 1){
                    canary2.getPathTransition().stop();
                    canary2.getFt().play();
                    canary2.getBirdo().setImage(canary2.getBlood());
                    score(15);
                    gameover();
                }
                canary2.setFlag(1);
            }

        });
        // END CANARY 2
       
        btn.setText("START GAME");
        btn.setLayoutX(250); btn.setLayoutY(420);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(btn.getOpacity() == 1){
                    char1.setOpacity(0);
                    char2.setOpacity(0);
                    char3.setOpacity(0);

                    plus1.setOpacity(0);
                    menos1.setOpacity(0);
                    plus2.setOpacity(0);
                    menos2.setOpacity(0);
                    plus3.setOpacity(0);
                    menos3.setOpacity(0);

                    nombre = Character.toString(letra) + Character.toString(letra2) + Character.toString(letra3);
                    System.out.println(nombre);

                    bird1.getPathTransition().play();
                    bird2.getPathTransition().play();
                    bird3.getPathTransition().play();
                    bird4.getPathTransition().play();
                    canary1.getPathTransition().play();
                    canary2.getPathTransition().play();
                    background.setOpacity(1);
                    background.toBack();
                    splashscreen.setOpacity(0);
                    splashscreen.toBack();
                    btn.setOpacity(0);
                    btn.toBack();
                }
            }
        });
        
        btnrestart.setText("RESTART GAME");
        btnrestart.setLayoutX(200); btnrestart.setLayoutY(390);
        btnrestart.setOpacity(0);
        btnrestart.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(btnrestart.getOpacity() == 1){
                    restartgame();
                }
            }
        });

        Font theFont2 = Font.font( "Helvetica", FontWeight.BOLD, 54 );

        top.setText("RANKING:");
        top.setLayoutX(800); top.setLayoutY(200);
        top.setOpacity(0);
        top.setFont( theFont2);
        top.setTextFill(Color.RED);

        top1.setLayoutX(800); top1.setLayoutY(300);
        top1.setOpacity(0);
        top1.setFont( theFont2);
        top1.setTextFill(Color.WHITE);
        top2.setLayoutX(800); top2.setLayoutY(380);
        top2.setOpacity(0);
        top2.setFont( theFont2);
        top2.setTextFill(Color.WHITE);
        top3.setLayoutX(800); top3.setLayoutY(460);
        top3.setOpacity(0);
        top3.setFont( theFont2);
        top3.setTextFill(Color.WHITE);

        root.getChildren().addAll(gmeovr, btnrestart, lbl, lblscore, background, bird1.getBirdo(), bird2.getBirdo(), bird3.getBirdo(), bird4.getBirdo(), canary1.getBirdo(), canary2.getBirdo(), splashscreen, btn);
        root.getChildren().addAll(char1, plus1, menos1);
        root.getChildren().addAll(char2, plus2, menos2);
        root.getChildren().addAll(char3, plus3, menos3);
        root.getChildren().addAll(top, top1, top2, top3);
        Scene scene = new Scene(root, 1280, 720);
        scene.setCursor(new ImageCursor(target,250,50));
        
        primaryStage.setTitle("Cazapatos!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    public void score(int iskor){
        lblscore.setText(Integer.toString(Integer.parseInt(lblscore.getText()) + iskor));
        score += iskor;
    }

    public void next() {
        complete = 0;
        top.setOpacity(0);
        top1.setOpacity(0);
        top2.setOpacity(0);
        top3.setOpacity(0);

        bird1.setFlag(0);
        bird2.setFlag(0);
        bird3.setFlag(0);
        bird4.setFlag(0);
        canary1.setFlag(0);
        canary2.setFlag(0);

        gamealive = 1;

        bird1.getPathTransition().play();
        bird2.getPathTransition().play();
        bird3.getPathTransition().play();
        bird4.getPathTransition().play();
        canary1.getPathTransition().play();
        canary2.getPathTransition().play();

        bird1.getBirdo().setOpacity(1);
        bird2.getBirdo().setOpacity(1);
        bird3.getBirdo().setOpacity(1);
        bird4.getBirdo().setOpacity(1);
        canary1.getBirdo().setOpacity(1);
        canary2.getBirdo().setOpacity(1);

        gmeovr.setOpacity(0);
        gmeovr.toBack();
        btnrestart.setOpacity(0);
        btnrestart.toBack();

        bird1.getBirdo().setImage(bird1.getBird());
        bird2.getBirdo().setImage(bird2.getBird());
        bird3.getBirdo().setImage(bird3.getBird());
        bird4.getBirdo().setImage(bird4.getBird());
        canary1.getBirdo().setImage(canary1.getBird());
        canary2.getBirdo().setImage(canary2.getBird());

        bird1.getFt().stop();
        bird2.getFt().stop();
        bird3.getFt().stop();
        bird4.getFt().stop();
        canary1.getFt().stop();
        canary2.getFt().stop();
    }

    public void gameover(){

        bird1.getBirdo().setOpacity(0);
        bird1.getPathTransition().stop();
        bird2.getBirdo().setOpacity(0);
        bird2.getPathTransition().stop();
        bird3.getBirdo().setOpacity(0);
        bird3.getPathTransition().stop();
        bird4.getBirdo().setOpacity(0);
        bird4.getPathTransition().stop();
        canary1.getBirdo().setOpacity(0);
        canary1.getPathTransition().stop();
        canary2.getBirdo().setOpacity(0);
        canary2.getPathTransition().stop();

        List<Scores> topList = sendData();

        top.setOpacity(1);
        if (topList.size() >= 1) {
            top1.setText(topList.get(0).toString());
            top1.setOpacity(1);
            if (topList.size() >= 2) {
                top2.setText(topList.get(1).toString());
                top2.setOpacity(1);
                if (topList.size() >= 3) {
                    top3.setText(topList.get(2).toString());
                    top3.setOpacity(1);
                }
            }
        }

        gamealive = 0;
        gmeovr.setOpacity(1);
        gmeovr.toFront();
        btnrestart.setOpacity(1);
        btnrestart.toFront();

    }

    public List<Scores> sendData(){
        List<Scores> scoreList = new ArrayList<>();
        List<Scores> ordenador = new ArrayList<>();

        Client client = new Client("localhost",5555);
        client.callServer(nombre, score);
        client.run();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ordenador = client.getListado();

        while(ordenador.size() > 0){
            int posNotaMaxA = 0;
            for (int i = 0; i < ordenador.size(); i++) {
                if(ordenador.get(i).score > ordenador.get(posNotaMaxA).score){
                    posNotaMaxA = i;
                }

            }
            scoreList.add(ordenador.get(posNotaMaxA));
            ordenador.remove(posNotaMaxA);

        }

        for (Scores score: scoreList) {
            System.out.println(score.toString());
        }
        return scoreList;
    }
      
    public void restartgame(){

        top.setOpacity(0);
        top1.setOpacity(0);
        top2.setOpacity(0);
        top3.setOpacity(0);

        bird1.setFlag(0);
        bird2.setFlag(0);
        bird3.setFlag(0);
        bird4.setFlag(0);
        canary1.setFlag(0);
        canary2.setFlag(0);

        gamealive = 1;

        bird1.getPathTransition().play();
        bird2.getPathTransition().play();
        bird3.getPathTransition().play();
        bird4.getPathTransition().play();
        canary1.getPathTransition().play();
        canary2.getPathTransition().play();

        bird1.getBirdo().setOpacity(1);
        bird2.getBirdo().setOpacity(1);
        bird3.getBirdo().setOpacity(1);
        bird4.getBirdo().setOpacity(1);
        canary1.getBirdo().setOpacity(1);
        canary2.getBirdo().setOpacity(1);

        gmeovr.setOpacity(0);
        gmeovr.toBack();
        btnrestart.setOpacity(0);
        btnrestart.toBack();

        bird1.getBirdo().setImage(bird1.getBird());
        bird2.getBirdo().setImage(bird2.getBird());
        bird3.getBirdo().setImage(bird3.getBird());
        bird4.getBirdo().setImage(bird4.getBird());
        canary1.getBirdo().setImage(canary1.getBird());
        canary2.getBirdo().setImage(canary2.getBird());

        bird1.getFt().stop();
        bird2.getFt().stop();
        bird3.getFt().stop();
        bird4.getFt().stop();
        canary1.getFt().stop();
        canary2.getFt().stop();

        lblscore.setText("0");
        score = 0;
    }
      
}
