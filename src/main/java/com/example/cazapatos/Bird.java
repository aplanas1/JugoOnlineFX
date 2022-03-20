package com.example.cazapatos;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class Bird {
    Image bird;
    Image blood;
    ImageView birdo;
    int flag;

    FadeTransition ft;
    Path path;
    PathTransition pathTransition;

    public Bird() {
        this.bird = new Image(getClass().getResourceAsStream("pics/b.gif"));
        this.blood = new Image(getClass().getResourceAsStream("pics/blood.png"));
        this.birdo = new ImageView(bird);
        this.flag = 0;
        this.ft = new FadeTransition(Duration.millis(3000), birdo);
        this.path = new Path();
        this.pathTransition = new PathTransition();
    }

    public Image getBird() {
        return bird;
    }

    public void setBird(Image bird) {
        this.bird = bird;
    }

    public Image getBlood() {
        return blood;
    }

    public void setBlood(Image blood) {
        this.blood = blood;
    }

    public ImageView getBirdo() {
        return birdo;
    }

    public void setBirdo(ImageView birdo) {
        this.birdo = birdo;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public FadeTransition getFt() {
        return ft;
    }

    public void setFt(FadeTransition ft) {
        this.ft = ft;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public PathTransition getPathTransition() {
        return pathTransition;
    }

    public void setPathTransition(PathTransition pathTransition) {
        this.pathTransition = pathTransition;
    }
}
