package strategy;

/**
 * @author Evgeny Borisov
 */
public interface RadioAlarm {
    void stopAlarm();  // from alarm

    void setChannel(double channel); // from radio
    void setVolume(int volume);// from radio
}
