package Runners;

import LevelHandlers.*;
import Parts.*;
import Obstacles.*;

import javax.swing.*;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;

import Parts.Part;
import com.google.gson.Gson;

public class GameLoop implements Runnable{
    private static final int FPS = 60;
    public static final int BLOCK_SIZE = 100;
    private static final double stepsPerSecond = 1000.0;
    private static final double groundPercent = 85.5;




    private int screenWidth;
    private int screenHeight;
    private int standardY;
    private Panel panel;

    private double position = 0;
    private int blockPosition;
    private double currentY;



    private Level level;


    public Level getLevel() {
        return level;
    }

    public GameLoop(Panel panel) {
        this.panel = panel;
        this.screenWidth = panel.getWidth();
        this.screenHeight = panel.getHeight();
        while(screenWidth == 0 || screenHeight == 0) {
            this.screenWidth = panel.getWidth();
            this.screenHeight = panel.getHeight();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        position = 0;
        standardY = (int) ((groundPercent/100)*screenHeight);
        currentY = standardY;

        Gson gson = new Gson();

        try (InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("maps/map1.json")) {

            if (is == null) {
                throw new IllegalStateException("Map not found!");
            }

            try (Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8)) {
                level = gson.fromJson(reader, Level.class);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    private void updateGameLoop(double delta){
        this.position += delta*stepsPerSecond;

        blockPosition = (int)(position/BLOCK_SIZE);


        for (Part part : panel.getParts()) {
            part.update(delta);
        }

    }


    @Override
    public void run() {
        final long OPTIMAL_TIME = 1_000_000_000 / (long)FPS;

        long lastTime = System.nanoTime();

        int FPSCounter = 0;
        long lastOneSecond = System.nanoTime();

        while (true) {
            if(System.nanoTime() - lastOneSecond >= 1_000_000_000) {
                lastOneSecond = System.nanoTime();
                System.out.println(FPSCounter + " FPS");
                FPSCounter = 0;
            }
            FPSCounter++;

            long now = System.nanoTime();
            long delta = now - lastTime;
            lastTime = now;

            double deltaSeconds = delta / 1_000_000_000.0;

            updateGameLoop(deltaSeconds);

            SwingUtilities.invokeLater(panel::repaint);


            long sleepTime = OPTIMAL_TIME - (System.nanoTime() - now);
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime / 1_000_000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }

    public double getPosition() {
        return position;
    }

    public int getBlockPosition() {
        return blockPosition;
    }

    public double getCurrentY() {
        return currentY;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getStandardY() {
        return standardY;
    }


}
