package Parts;
import Runners.*;
import LevelHandlers.*;

import Obstacles.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Background implements Part {
    private static final String imgPath = "/img/Background.jpg";
    private static URL url = Background.class.getResource(imgPath);

    private static final BufferedImage background;
    private static final int imgNeeded = 4;

    private int imgHeight;
    private int imgWidth;
    private double startingPosition;
    private GameLoop gameLoop;

    static {
        try {
            assert url != null;
            background = ImageIO.read(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public Background(GameLoop gameLoop) {
        imgHeight = gameLoop.getScreenHeight();
        double scale = (double) gameLoop.getScreenWidth() / background.getHeight();
        imgWidth = (int)(background.getWidth() * scale);
        this.startingPosition = 0;
        this.gameLoop = gameLoop;
        System.out.println(imgWidth + " " + imgHeight);
        System.out.println(gameLoop.getScreenWidth() + " " + gameLoop.getScreenHeight());
    }

    @Override
    public void update(double delta) {
        double position = gameLoop.getPosition();
        startingPosition = -1*position % imgWidth - imgWidth;
    }

    @Override
    public synchronized void render(Graphics g) {
        for (int i = 0; i < imgNeeded; i++) {
            g.drawImage(background, (int) startingPosition + (i * imgWidth), 0, imgWidth, imgHeight, null);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }


}
