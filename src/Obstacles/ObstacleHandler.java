package Obstacles;

import LevelHandlers.*;
import Parts.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ObstacleHandler implements Part {

    ArrayList<Obstacle> obstacles;

    public ObstacleHandler(Level level) {
        obstacles = new ArrayList<>();
        for(int i = 0; i< level.getObjects().size(); i++){
            obstacles.add(getObstacleClassFromLevelObject(level.getObjects().get(i)));

        }

    }



    private Obstacle getObstacleClassFromLevelObject(LevelObjects object) {
        switch (object.getType()) {
            case "BLOCK":
                return new Block(object);
            case "SPIKE":
                return new Spike(object);
            default:
                throw new IllegalArgumentException("Invalid obstacle type");
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
