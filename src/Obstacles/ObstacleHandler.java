package Obstacles;

import LevelHandlers.*;
import Parts.*;
import Runners.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ObstacleHandler implements Part {

    ArrayList<Obstacle> obstacles;

    public ObstacleHandler(Level level) {
        obstacles = new ArrayList<>();

    }



    private Class getObstacleClassFromString(String obstacleType) {
        switch (obstacleType) {
            case "BLOCK":
                return Block.class;
            case "SPIKE":
                return Spike.class;
        }

    }



    @Override
    public void update(double delta) {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }
}
