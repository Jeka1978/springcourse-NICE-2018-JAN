package strategy;

import lombok.experimental.Delegate;

/**
 * @author Evgeny Borisov
 */
public class RadioAlarmImpl implements RadioAlarm {
    @Delegate
    private Alarm alarm = new AlarmImpl();
    @Delegate
    private Radio radio = new RadioImpl();



}
