package hw_16072021_week;

public enum DayOfWeek {
    SUNDAY(0), MONDAY(8), TUESDAY(8), WEDNESDAY(8), THURSDAY(8), FRIDAY(7),
    SATURDAY(4);
    private final int hours;

    DayOfWeek(int hours) {
        this.hours = hours;
    }

    public int getHours() {
        return hours;
    }
}
