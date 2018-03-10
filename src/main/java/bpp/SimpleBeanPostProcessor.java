package bpp;

import beans.RootBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class SimpleBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        print(bean," SimpleBeanPostProcessor postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        print(bean," SimpleBeanPostProcessor postProcessAfterInitialization");
        return bean;
    }

    private void print(Object o, String s) {
        if (o instanceof RootBean) {
            RootBean rootBean = (RootBean) o;
            rootBean.printString(s);
        }
    }
}
