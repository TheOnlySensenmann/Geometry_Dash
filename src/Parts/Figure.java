package Parts;
import Runners.*;
import LevelHandlers.*;
import Parts.*;
import Obstacles.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

public class Figure implements Part {
    private static HashMap<Figures, BufferedImage> images;
    private static final int size = GameLoop.BLOCK_SIZE;
    private final static String blockPath = "/img/Figure_Block.jpg";
    private static URL url = Figure.class.getResource(blockPath);

    private static final int x = 500;
    private static final double jumpSeconds = 0.5;
    private static final double jumpHeight = 10000;
    private static final double degreesPerJump = 180;
    private static final double degreesPerSecond = degreesPerJump / jumpSeconds;
    private static final int POSSIBLE_LANDS = 90;


    private boolean mousePressed = false;
    private boolean jump = false;
    private double jumpCounter = 0;
    private double degrees = 0;
    private boolean up = true;
    private double y;

    private GameLoop gameLoop;



    private Figures selectedFigure = Figures.BLOCK;
    static{
        images = new HashMap<>();
        try {
            assert url != null;
            images.put(Figures.BLOCK, ImageIO.read(url));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Figure(GameLoop gameLoop) {
        this.gameLoop = gameLoop;
        y = gameLoop.getCurrentY() - size;
    }

    @Override
    public void update(double delta) {
        if(degrees >= 360){
            degrees = degrees - 360;
        }
        if(mousePressed && !jump){
            startJump();
            up = true;
        }
        if(jump){
            jumpCounter+=delta;

            if((int)y + size >= gameLoop.getCurrentY() && !up){
                endJump();
                return;
            }
            if(jumpCounter > jumpSeconds/2){
                up = false;
                jumpCounter = 0;
            }

            degrees += degreesPerSecond*delta;

            if(up){
                double difference = jumpHeight*(jumpCounter - jumpSeconds/2)*delta;
                if(difference > 0){
                    throw new RuntimeException("Jump out of bounds!");
                }
                y += difference;
            } else {
                y += jumpHeight*((jumpCounter))*delta;
            }

        }
    }

    void startJump() {
        if (!jump) {
            jump = true;
            jumpCounter = 0.0;
        }
    }


    private void endJump(){
        jump = false;
        up = true;
        y = gameLoop.getCurrentY() - size;
        jumpCounter = 0;
        int degreesToRight = (int) (degrees%POSSIBLE_LANDS);
        if(degreesToRight < POSSIBLE_LANDS/2){
            degrees -= degreesToRight;
        } else {
            degrees -= degreesToRight - POSSIBLE_LANDS;
        }
    }

    @Override
    public synchronized void render(Graphics g) {


        Graphics2D g2d = (Graphics2D) g;

        AffineTransform old = g2d.getTransform();

        g2d.rotate(Math.toRadians(degrees), x  + (size/ 2.0), y + ((double) size / 2.0));

        g2d.drawImage(images.get(selectedFigure), x, (int)y, size,size, null);

        g2d.setTransform(old);

    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mousePressed = false;
    }


}
