package quoters.bpp;

import my_spring.InjectRandomIntObjectConfigurator;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Role;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
public class InjectRandomIntAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Nullable
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        InjectRandomIntObjectConfigurator configurator = new InjectRandomIntObjectConfigurator();
        configurator.configure(bean);
        return bean;
    }
}








