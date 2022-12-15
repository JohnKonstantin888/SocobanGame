package com.javarush.task.task34.task3410.controller;

import com.javarush.task.task34.task3410.model.Direction;
import com.javarush.task.task34.task3410.model.GameObjects;
import com.javarush.task.task34.task3410.model.Model;
import com.javarush.task.task34.task3410.view.View;

public class Controller implements EventListener {
    private View view;
    private Model model;

    public static void main(String[] args) {
        Controller controller = new Controller();
    }

    public Controller() {
        this.view = new View(this);
        this.model = new Model();

        this.view.init();
        this.model.restart();

        this.view.setEventListener(this);
        this.model.setEventListener(this);
    }

    public GameObjects getGameObjects() {
        return this.model.getGameObjects();
    }

    @Override
    public void move(Direction direction) {
        this.model.move(direction);
        this.view.update();
    }

    @Override
    public void restart() {
        this.model.restart();
        this.view.update();
    }

    @Override
    public void startNextLevel() {
        this.model.startNextLevel();
        this.view.update();
    }

    @Override
    public void levelCompleted(int level) {
        this.view.completed(level);
    }
}
