package jsr_310;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.CANADA_FRENCH));
        System.out.println(now.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.JAPAN));
        System.out.println(now.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.JAPAN));

        LocalDateTime localDateTime = now.plusYears(1);
        System.out.println(localDateTime.getDayOfWeek().getDisplayName(TextStyle.FULL,Locale.ENGLISH));
        LocalDateTime jeka = LocalDateTime.of(1978, 10, 3, 0, 0, 0);
        LocalDateTime asaf = LocalDateTime.of(1982, 12, 19, 0, 0, 0);
        long between = ChronoUnit.DAYS.between(jeka, asaf);
        System.out.println("between = " + between);
    }
}
