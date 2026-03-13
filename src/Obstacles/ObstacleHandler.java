package Obstacles;

import LevelHandlers.*;
import Parts.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;

public class ObstacleHandler implements Part {

    ArrayList<Obstacle> obstacles;

    public ObstacleHandler(Level level) {
        obstacles = new ArrayList<>();
        for(int i = 0; i< level.getObjects().size(); i++){
            obstacles.add(getObstacleClassFromLevelObject(level.getObjects().get(i)));
        }

        obstacles.sort((o1, o2) -> {
            if(o1.x == o2.x){
                return Integer.compare(o1.y, o2.y);
            }
            return Integer.compare(o1.x, o2.x);
        });
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
