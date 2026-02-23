package Obstacles;

import Runners.GameLoop;

public enum ObstacleTypes {
    BLOCK(0,0,GameLoop.BLOCK_SIZE,GameLoop.BLOCK_SIZE),
    SPIKE(5, 5, 20, 40);


    int hitboxY;
    int hitboxX;
    int hitboxWidth;
    int hitboxHeight;

    ObstacleTypes(int hitboxY, int hitboxX, int hitboxWidth, int hitboxHeight){
        this.hitboxY = hitboxY;
        this.hitboxX = hitboxX;
        this.hitboxWidth = hitboxWidth;
        this.hitboxHeight = hitboxHeight;
    }


}
