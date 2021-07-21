package hw_16072021_week;

public class Main {
    public static void main(String[] args) {
        System.out.println(getWorkingHours(DayOfWeek.FRIDAY));
    }

    public static int getWorkingHours(DayOfWeek d) {
        int hoursStill = 0;
        if (d == DayOfWeek.SUNDAY) {
            System.out.print("It is Weekend, working time ahead: ");
            return 0;
        }
        for (DayOfWeek w : DayOfWeek.values()) {
            hoursStill += w.getHours();
        }
        for (DayOfWeek w : DayOfWeek.values()) {
            if (d != w) {
                hoursStill -= w.getHours();
            } else return hoursStill;
        }
        return hoursStill;
    }
}