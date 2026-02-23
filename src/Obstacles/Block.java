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
    private static final BufferedImage blockImage;




    static {
        try {
            blockImage = ImageIO.read(new File(IMG_PATH_NAME));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Block(ObstacleTypes obstacleType, String imageFileName, int x, int y) {
        super(obstacleType, imageFileName, x, y);
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
