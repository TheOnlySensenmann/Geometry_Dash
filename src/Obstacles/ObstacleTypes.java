package Obstacles;

import Runners.GameLoop;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public enum ObstacleTypes {
    BLOCK(0,0,GameLoop.BLOCK_SIZE,GameLoop.BLOCK_SIZE, "img/Obstacles/Block.jpg"),;
    //SPIKE(5, 5, 20, 40, "Obstacles/spike.png"),;


    int hitboxY;
    int hitboxX;
    int hitboxWidth;
    int hitboxHeight;
    BufferedImage image;

    ObstacleTypes(int hitboxY, int hitboxX, int hitboxWidth, int hitboxHeight, String imagePath){
        this.hitboxY = hitboxY;
        this.hitboxX = hitboxX;
        this.hitboxWidth = hitboxWidth;
        this.hitboxHeight = hitboxHeight;

        try(InputStream input = getClass().getClassLoader().getResourceAsStream(imagePath)){
            this.image = ImageIO.read(input);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
