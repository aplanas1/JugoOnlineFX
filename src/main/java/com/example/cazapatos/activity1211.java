package com.example.cazapatos;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
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
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

public class activity1211 extends Application {
    
    Label lbl = new Label();
    Label lblscore = new Label();
     
    int flag, flag2, flag3, flag4, flag5, flag6 = 0;

    int gamealive = 1;
    
    Image splash = new Image(getClass().getResourceAsStream("pics/SplashScreen.jpg"));
    ImageView splashscreen = new ImageView();
    
    Image wood = new Image(getClass().getResourceAsStream("pics/bg.jpg"));
    ImageView background = new ImageView();
    
    Image target = new Image(getClass().getResourceAsStream("pics/pointer.png"));
    ImageView targett = new ImageView(target);
    
    Image bird = new Image(getClass().getResourceAsStream("pics/b.gif"));
    Image birdx = new Image(getClass().getResourceAsStream("pics/blood.png"));
    ImageView birda = new ImageView(bird);
    
    FadeTransition ft = new FadeTransition(Duration.millis(3000), birda);
    Path path = new Path();
    PathTransition pathTransition = new PathTransition();
    
    Image bird2 = new Image(getClass().getResourceAsStream("pics/b.gif"));
    Image bird2x = new Image(getClass().getResourceAsStream("pics/blood.png"));
    ImageView birdb = new ImageView(bird2);
    
    FadeTransition ft2 = new FadeTransition(Duration.millis(3000), birdb);
    Path path2 = new Path();
    PathTransition pathTransition2 = new PathTransition();
    
    Image bird3 = new Image(getClass().getResourceAsStream("pics/x.gif"));
    Image bird3x = new Image(getClass().getResourceAsStream("pics/blood.png"));
    ImageView birdc = new ImageView(bird3);
    
    FadeTransition ft3 = new FadeTransition(Duration.millis(3000), birdc);
    Path path3 = new Path();
    PathTransition pathTransition3 = new PathTransition();
    
    Image bird4 = new Image(getClass().getResourceAsStream("pics/b.gif"));
    Image bird4x = new Image(getClass().getResourceAsStream("pics/blood.png"));
    ImageView birdd = new ImageView(bird4);
    
    FadeTransition ft4 = new FadeTransition(Duration.millis(3000), birdd);
    Path path4 = new Path();
    PathTransition pathTransition4 = new PathTransition();
    
    Image bird5 = new Image(getClass().getResourceAsStream("pics/b.gif"));
    Image bird5x = new Image(getClass().getResourceAsStream("pics/blood.png"));
    ImageView birde = new ImageView(bird5);
    
    FadeTransition ft5 = new FadeTransition(Duration.millis(3000), birde);
    Path path5 = new Path();
    PathTransition pathTransition5 = new PathTransition();
    
    Image bird6 = new Image(getClass().getResourceAsStream("pics/x.gif"));
    Image bird6x = new Image(getClass().getResourceAsStream("pics/blood.png"));
    ImageView birdf = new ImageView(bird6);
    
    FadeTransition ft6 = new FadeTransition(Duration.millis(3000), birdf);
    Path path6 = new Path();
    PathTransition pathTransition6 = new PathTransition();
    
    Button btn = new Button();
//    Button btn2 = new Button();
    Button btnrestart = new Button();
    
    Image gameover = new Image(getClass().getResourceAsStream("pics/go.png"));
    ImageView gmeovr = new ImageView(gameover);
    
    @Override
    public void start(Stage primaryStage) {
        
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
        background.setFitWidth(500); background.setFitHeight(500);
        background.setOpacity(0);
        
        splashscreen.setImage(splash);
        splashscreen.setX(5); splashscreen.setY(50);
        splashscreen.setFitWidth(500); splashscreen.setFitHeight(500);
        
        targett.setX(85); targett.setY(80);
        targett.setFitWidth(500); targett.setFitHeight(500);
        
                 
        birda.setX(5); birda.setY(60);
        birda.setFitWidth(150);birda.setFitHeight(150);
        
        
        ft.setFromValue(1.0);
        ft.setToValue(0.0);
        ft.setCycleCount(1);
        
        
        path.getElements().add(new MoveTo(80,100));
        path.getElements().add(new CubicCurveTo(465, 0, 345, 120, 200, 120));
        path.getElements().add(new CubicCurveTo(89, 123, 123, 240, 234, 240));
//        path.getElements().add(new HLineTo(550));
        pathTransition.setDuration(Duration.seconds(5));
        pathTransition.setPath(path);
        pathTransition.setNode(birda);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
//        pathTransition.setAutoReverse(true);
        
       birda.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                if (flag == 0 && gamealive == 1){
                pathTransition.stop();
                ft.play();
                birda.setImage(birdx);
                score(5);
                }
                flag = 1;
                }
    
        });
       
        birdb.setX(5); birdb.setY(60);
        birdb.setFitWidth(150);birdb.setFitHeight(150);
        
        ft2.setFromValue(1.0);
        ft2.setToValue(0.0);
        ft2.setCycleCount(1);
        
        
        path2.getElements().add(new MoveTo(80,100));
        path2.getElements().add(new HLineTo(550));
        pathTransition2.setDuration(Duration.seconds(3));
        pathTransition2.setPath(path2);
        pathTransition2.setNode(birdb);
        pathTransition2.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition2.setCycleCount(Timeline.INDEFINITE);
//        pathTransition.setAutoReverse(true);
        
       birdb.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                if (flag2 == 0 && gamealive == 1){
                pathTransition2.stop();
                ft2.play();
                birdb.setImage(bird2x);
                score(5);
                }
                flag2 = 1;
                }
    
        });
       
        birdc.setX(5); birdc.setY(60);
        birdc.setFitWidth(80);birdc.setFitHeight(80);
        
        ft3.setFromValue(1.0);
        ft3.setToValue(0.0);
        ft3.setCycleCount(1);
        
        
        path3.getElements().add(new MoveTo(80,100));
        path3.getElements().add(new CubicCurveTo(54, 544, 234, 345, 344, 345));
        path3.getElements().add(new CubicCurveTo(567, 23, 645, 234, 344, 234));
        pathTransition3.setDuration(Duration.seconds(2));
        pathTransition3.setPath(path3);
        pathTransition3.setNode(birdc);
        pathTransition3.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition3.setCycleCount(Timeline.INDEFINITE);
//        pathTransition.setAutoReverse(true);
        
       birdc.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                if (flag3 == 0 && gamealive == 1){
//                pathTransition3.stop();
//                ft3.play();
                birdc.setImage(bird3x);
                score(5);
                gameover();
                }
                flag3 = 1;
                }
    
        });
       
        birdd.setX(5); birdd.setY(250);
        birdd.setFitWidth(150);birdd.setFitHeight(150);
        
        ft4.setFromValue(1.0);
        ft4.setToValue(0.0);
        ft4.setCycleCount(1);
        
        
        path4.getElements().add(new MoveTo(80,100));
        path4.getElements().add(new CubicCurveTo(524, 54, 24, 145, 4, 0));
        path4.getElements().add(new CubicCurveTo(0, 23, 0, 34, 423, 234));
        pathTransition4.setDuration(Duration.seconds(5));
        pathTransition4.setPath(path4);
        pathTransition4.setNode(birdd);
        pathTransition4.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition4.setCycleCount(Timeline.INDEFINITE);
//        pathTransition.setAutoReverse(true);
        
       birdd.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                if (flag4 == 0 && gamealive == 1){
                pathTransition4.stop();
                ft4.play();
                birdd.setImage(bird4x);
                score(15);
                }
                flag4 = 1;
                }
    
        });
       
        birde.setX(5); birde.setY(60);
        birde.setFitWidth(150);birde.setFitHeight(150);
        
        ft5.setFromValue(1.0);
        ft5.setToValue(0.0);
        ft5.setCycleCount(1);
        
        
        path5.getElements().add(new MoveTo(80,100));
        path5.getElements().add(new HLineTo(855));
        pathTransition5.setDuration(Duration.seconds(6));
        pathTransition5.setPath(path5);
        pathTransition5.setNode(birde);
        pathTransition5.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition5.setCycleCount(Timeline.INDEFINITE);
//        pathTransition.setAutoReverse(true);
        
       birde.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                if (flag5 == 0 && gamealive == 1){
                pathTransition5.stop();
                ft5.play();
                birde.setImage(bird5x);
                score(10);
                }
                flag5 = 1;
                }
    
        });
       
        birdf.setX(5); birdf.setY(60);
        birdf.setFitWidth(180);birdf.setFitHeight(180);
        
        ft6.setFromValue(1.0);
        ft6.setToValue(0.0);
        ft6.setCycleCount(1);
        
        
        path6.getElements().add(new MoveTo(80,100));
        path6.getElements().add(new HLineTo(455));
        pathTransition6.setDuration(Duration.seconds(1));
        pathTransition6.setPath(path6);
        pathTransition6.setNode(birdf);
        pathTransition6.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition6.setCycleCount(Timeline.INDEFINITE);
//        pathTransition.setAutoReverse(true);
        
       birdf.setOnMouseClicked(new EventHandler<MouseEvent>() {
            
            @Override
            public void handle(MouseEvent event) {
                if (flag6 == 0 && gamealive == 1){
//                pathTransition3.stop();
//                ft3.play();
                birdf.setImage(bird6x);
                score(15);
                gameover();
                }
                flag6 = 1;
                }
    
        });
       
         
       
        btn.setText("START GAME");
        btn.setLayoutX(250); btn.setLayoutY(420);
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                if(btn.getOpacity() == 1){
//                    startgame();
                  pathTransition.play();
                  pathTransition2.play();
                  pathTransition3.play();
                  pathTransition4.play();
                  pathTransition5.play();
                  pathTransition6.play();
                  background.setOpacity(1);
                  background.toBack();
                  splashscreen.setOpacity(0);
                  splashscreen.toBack();
                  btn.setOpacity(0);
                  btn.toBack();
                }
            }
        }); 
        
       
//        btn2.setText("Stop");
//        btn2.setLayoutX(50); btn2.setLayoutY(5);
//        btn2.setOnAction(new EventHandler<ActionEvent>() {
//            
//            @Override
//            public void handle(ActionEvent event) {
////              ft.stop();
//                pathTransition.stop();
//                pathTransition2.stop();
//                pathTransition3.stop();
//                
//            }
//        });
        
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
        
        Pane root = new Pane();
        root.getChildren().addAll(gmeovr, btnrestart, lbl, lblscore, background, birda, birdb, birdc, birdd, birde, birdf, splashscreen, btn);
        
        Scene scene = new Scene(root, 510, 500);
        scene.setCursor(new ImageCursor(target,250,50));
        
        primaryStage.setTitle("Hello World!");
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
        
        }
     
      public void gameover(){
            pathTransition.stop();
            pathTransition2.stop();
            pathTransition3.stop();
            pathTransition4.stop();
            pathTransition5.stop();
            pathTransition6.stop();
            gamealive = 0;
            gmeovr.setOpacity(1);
            gmeovr.toFront();
            btnrestart.setOpacity(1);
            btnrestart.toFront();
    }
      
      public void restartgame(){
             
             flag = 0;
             flag2 = 0;
             flag3 = 0;
             flag4 = 0;
             flag5 = 0;
             flag6 = 0;
             gamealive = 1;            
             pathTransition.play();
             pathTransition2.play();
             pathTransition3.play();
             pathTransition4.play();
             pathTransition5.play();
             pathTransition6.play();
             birda.setOpacity(1);
             birdb.setOpacity(1);
             birdc.setOpacity(1);
             birdd.setOpacity(1);
             birde.setOpacity(1);
             birdf.setOpacity(1);
             gmeovr.setOpacity(0);
             gmeovr.toBack();
             btnrestart.setOpacity(0);
             btnrestart.toBack();
             birda.setImage(bird);
             birdb.setImage(bird2);
             birdc.setImage(bird3);
             birdd.setImage(bird4);
             birde.setImage(bird5);
             birdf.setImage(bird6);
             ft.stop();
             ft2.stop();
             ft3.stop();
             ft4.stop();
             ft5.stop();
             ft6.stop();
             lblscore.setText("0");
      }
      
}
