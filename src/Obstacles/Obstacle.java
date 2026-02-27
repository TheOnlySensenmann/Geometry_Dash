package Obstacles;

import Parts.Part;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Obstacle {
    public int x;
    public int y;

    public final ObstacleTypes obstacleType;

    public Obstacle(ObstacleTypes obstacleType, int x, int y) {
        this.obstacleType = obstacleType;
        this.x = x;
        this.y = y;
    }

}
