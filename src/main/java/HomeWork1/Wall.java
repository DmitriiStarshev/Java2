package HomeWork1;

public class Wall implements Barriers {
    private int wallHeight;

    public Wall(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    public int getWallHeight() {
        return wallHeight;
    }

    public void setWallHeight(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    public int getJumpToTheWall(Actions jumper) {
        return jumper.jump(this);
    }

    public void overcame(Competitable competitable) {
        competitable.jump(wallHeight);
    }
}


