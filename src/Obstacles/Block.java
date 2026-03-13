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
    public Block(int x, int y) {
        super(ObstacleTypes.BLOCK, x, y);
    }


    public Block(LevelObjects levelObject) {
        super(ObstacleTypes.BLOCK, levelObject.getX(), levelObject.getY());
    }


}
