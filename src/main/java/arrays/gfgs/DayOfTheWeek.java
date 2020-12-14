package arrays.gfgs;

import java.util.Calendar;

public class DayOfTheWeek {

    private final String[] days = {
            "Sunday",
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thusday",
            "Friday",
            "Saturday"
    };

    public static void main(String[] args) {
        DayOfTheWeek dayOfTheWeek = new DayOfTheWeek();
        System.out.println(dayOfTheWeek.dayOfTheWeek(11, 2, 1995));
    }

    public String dayOfTheWeek(int d, int m, int y) {
        int result;
        int[] t = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        y -= (m < 3) ? 1 : 0;
        result = (y + y / 4 - y / 100 + y / 400 + t[m - 1] + d) % 7;
        return days[result];
    }

}
