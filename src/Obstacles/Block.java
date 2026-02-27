package Obstacles;
import Runners.*;
import LevelHandlers.*;
import Parts.*;
import Obstacles.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Block extends Obstacle{
    private static final String IMG_PATH_NAME = "block.png";
    private static final ObstacleTypes OBSTACLE_TYPE = ObstacleTypes.BLOCK;


    public Block(ObstacleTypes obstacleType, String imageFileName, int x, int y) {
        super(obstacleType, imageFileName, x, y);
    }


}
