package strategy;

import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;

/**
 * @author Evgeny Borisov
 */
@AllArgsConstructor
public class RadioAlarmImpl implements Radio {
    @Delegate
    private Alarm alarm;
    @Delegate
    private Radio radio;



}
