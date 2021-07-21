package hw_16072021;

public class Robot implements JumpRunnable {
    private final String name;
    private final int maxRun;
    private final int maxJump;

    public Robot(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }

    @Override
    public boolean jump(Wall wall) {
        if (wall.height < 0) return false;
        if (maxJump >= wall.height) {
            System.out.println(name + " jump successfully");
            return true;
        } else {
            System.out.println(name + " can't jump, he is gone");
        }
        return false;
    }

    @Override
    public boolean run(Track track) {
        if (track.length < 0) return false;
        if (maxRun >= track.length) {
            System.out.println(name + " run successfully");
            return true;
        } else {
            System.out.println(name + " can't run, he is gone");
        }
        return false;
    }
}