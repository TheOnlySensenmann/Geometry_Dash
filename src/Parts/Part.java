package Parts;

import java.awt.*;
import java.awt.event.MouseEvent;

public interface Part {
    public void update(double delta);
    public void render(Graphics g);
    public void mousePressed(MouseEvent e);
    public void mouseReleased(MouseEvent e);
}
