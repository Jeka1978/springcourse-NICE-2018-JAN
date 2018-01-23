package quoters.bpp;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import quoters.DeprecatedClass;

/**
 * @author Evgeny Borisov
 */
public class DeprecatedHandlerBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    @SneakyThrows
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] names = beanFactory.getBeanDefinitionNames();
        for (String name : names) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(name);
            String beanClassName = beanDefinition.getBeanClassName();
            Class<?> beanClass = Class.forName(beanClassName);
            if (beanClass.isAnnotationPresent(DeprecatedClass.class)) {
                DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
                Class newClass = annotation.value();
                beanDefinition.setBeanClassName(newClass.getName());
            }
        }
    }
}





