package spring_demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import strategy.RadioAlarm;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        RadioAlarm radioAlarm = context.getBean(RadioAlarm.class);
        radioAlarm.setChannel(12);
        radioAlarm.stopAlarm();
    }
}
