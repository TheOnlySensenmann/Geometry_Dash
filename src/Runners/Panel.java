package Runners;

import LevelHandlers.*;
import Parts.*;
import Obstacles.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

public class Panel extends JPanel {
    private final JFrame frame;

    private final List<Part> parts;

    private MouseInput mouseInput;
    private GameLoop gameLoop;

    private boolean first = true;

    public Panel() {
        parts = new LinkedList<>();




        mouseInput = new MouseInput(this);
        frame = new JFrame();
        frame.setTitle("Geometry Dash");
        frame.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        this.addMouseListener(mouseInput);
        this.setBackground(Color.BLACK);


        frame.add(this, BorderLayout.CENTER);




    }

    public List<Part> getParts() {
        return parts;
    }


    void mousePressed(MouseEvent e) {
        parts.forEach(gameLoop -> gameLoop.mousePressed(e));
    }

    void mouseReleased(MouseEvent e) {
        parts.forEach(gameLoop -> gameLoop.mouseReleased(e));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        synchronized (parts) {
            parts.forEach(part ->  part.render(g));
        }
    }

    public void startGameLoop(){
        gameLoop = new GameLoop(this);

        parts.add(new Background(gameLoop));
        parts.add(new Figure(gameLoop));
        parts.add(new ObstacleHandler(gameLoop));



        new Thread(gameLoop).start();
    }
}