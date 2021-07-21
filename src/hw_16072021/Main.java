package hw_16072021;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<JumpRunnable> jumpRunnables = new ArrayList<>();
        Man sportsman = new Man("UsainBolt", 100_000, 3);
        Cat usualCat = new Cat("Murka", 300, 2);
        Robot droid = new Robot("R2-D2", 1_000_000, 10);
        jumpRunnables.add(sportsman);
        jumpRunnables.add(usualCat);
        jumpRunnables.add(droid);

        Obstacle[] obstacles = {
                new Track(3000),
                new Wall(3)
        };

        for (Obstacle obstacle : obstacles) {
            jumpRunnables.removeIf(jumpRunnable -> !obstacle.start(jumpRunnable));
        }
    }
}
