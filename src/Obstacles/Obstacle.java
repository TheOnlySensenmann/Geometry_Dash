package Obstacles;

import Parts.Part;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Obstacle {
    public int hitboxX;
    public int hitboxY;
    public int hitboxWidth;
    public int hitboxHeight;
    public int x;
    public int y;

    public final BufferedImage image;
    public final ObstacleTypes obstacleType;
    public final String imageFileName;

    public Obstacle(ObstacleTypes obstacleType, String imageFileName, int x, int y) {
        this.obstacleType = obstacleType;
        this.imageFileName = imageFileName;
        this.x = x;
        this.y = y;

        try {
            image = ImageIO.read(new File(imageFileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
