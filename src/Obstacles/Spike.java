package Obstacles;

import LevelHandlers.LevelObjects;

public class Spike extends Obstacle{
    public Spike(LevelObjects levelObject) {
        super(ObstacleTypes.SPIKE, levelObject.getX(),  levelObject.getY());
    }
}
