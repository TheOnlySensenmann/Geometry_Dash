package LevelHandlers;

public class LevelObjects {
    private final String type;
    private final int x;
    private final int y;

    public LevelObjects(String type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y = y;
    }

    public String getType() {
        return type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
