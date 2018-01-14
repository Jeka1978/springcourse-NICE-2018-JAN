package strategy;

/**
 * @author Evgeny Borisov
 */
public class HebrewAlarm implements Alarm {
    @Override
    public void stopAlarm() {
        System.out.println("סוף");
    }
}
