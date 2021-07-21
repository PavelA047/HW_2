package hw_16072021;

public class Wall implements Obstacle {
    int height;

    public Wall(int height) {
        this.height = height;
        if (height < 0) {
            System.out.println("Incorrect wall");
        }
    }

    @Override
    public boolean start(JumpRunnable jr) {
        return jr.jump(this);
    }
}
