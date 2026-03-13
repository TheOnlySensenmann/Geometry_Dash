package Obstacles;

import LevelHandlers.*;
import Parts.*;
import Runners.GameLoop;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ObstacleHandler implements Part {

    private ArrayList<Obstacle> obstacles;
    private GameLoop gameLoop;

    private int currentStartIndexForObstacles;
    private int currentEndIndexForObstacles;

    public ObstacleHandler(Level level, GameLoop gameLoop) {
        this.currentStartIndexForObstacles = 0;
        this.currentEndIndexForObstacles = 0;
        this.gameLoop = gameLoop;
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
        return switch (object.getType()) {
            case "BLOCK" -> new Block(object);
            case "SPIKE" -> new Spike(object);
            default -> throw new IllegalArgumentException("Invalid obstacle type");
        };
    }



    @Override
    public void update(double delta) {
        double currentX = gameLoop.getBlockPosition();

        while(obstacles.get(currentStartIndexForObstacles).x < currentX){
            currentStartIndexForObstacles++;
        }
        while(obstacles.get(currentEndIndexForObstacles).x < currentX + gameLoop.getBlocksOnScreenWith()){
            currentEndIndexForObstacles++;
        }
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
