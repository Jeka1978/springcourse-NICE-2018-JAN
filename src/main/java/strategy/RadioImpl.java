package strategy;

/**
 * @author Evgeny Borisov
 */
public class RadioImpl implements Radio {
    public void setChannel(double channel) {
        System.out.println("channel was changed");
    }

    @Override
    public void setVolume(int volume) {
        System.out.println("Volume was changed");
    }
}
