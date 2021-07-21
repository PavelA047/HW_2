package hw_16072021;

public class Track implements Obstacle {
    int length;

    public Track(int length) {
        this.length = length;
        if (length < 0) {
            System.out.println("Incorrect track");
        }
    }

    @Override
    public boolean start(JumpRunnable jr) {
        return jr.run(this);
    }
}
