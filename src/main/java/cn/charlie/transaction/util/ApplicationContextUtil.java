package cn.charlie.transaction.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author charlie
 * @date 3/15/2023 3:46 PM
 **/
@Component
public class ApplicationContextUtil implements ApplicationContextAware {
    protected static ApplicationContext context;

    protected ApplicationContextUtil() {
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return context;
    }

    public static Object getBean(String beanName) {
        return context.getBean(beanName);
    }

    public static <T> T getBean(String beanName, Class<T> t) {
        return context.getBean(beanName, t);
    }

    public static <T> T getBean(Class<T> t) {
        return context.getBean(t);
    }

    public static <T> Map<String, T> getBeansOfType(Class<T> t) {
        return context.getBeansOfType(t);
    }

    public static String getActiveProfile() {
        String[] profiles = context.getEnvironment().getActiveProfiles();
        return profiles.length != 0 ? profiles[0] : "";
    }
}
