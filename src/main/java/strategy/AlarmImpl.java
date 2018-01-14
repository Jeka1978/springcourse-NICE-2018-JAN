package strategy;

/**
 * @author Evgeny Borisov
 */
public class AlarmImpl implements Alarm {
    @Override
    public void stopAlarm() {
        System.out.println("Alarm was stopped");
    }
}
