package beans;

import bfpp.SimpleBeanFactoryPostProcessor;
import bpp.SimpleBeanPostProcessor;
import listeners.AppListner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {


    @Bean
    public static CommonAnnotationBeanPostProcessor commonAnnotationBeanPostProcessor() {
        return new CommonAnnotationBeanPostProcessor();
    }

    @Bean(initMethod = "init", destroyMethod = "dest")
    @Scope("prototype")
    RootBean rootBean() {
        return new RootBean(byConstructor());
    }

    @Bean
    @Scope("prototype")
    ByConstructor byConstructor() {
        return new ByConstructor();
    }

    @Bean
    @Scope("prototype")
    ByField byField() {
        return new ByField();
    }

    @Bean
    @Scope("prototype")
    BySetter bySetter() {
        return new BySetter();
    }

    @Bean
    @Scope("prototype")
    public static SimpleBeanPostProcessor postProcessor() {
        return new SimpleBeanPostProcessor();
    }

    @Bean
    @Scope("prototype")
    public static SimpleBeanFactoryPostProcessor beanFactoryPostProcessor() {
        return new SimpleBeanFactoryPostProcessor();
    }

    @Bean
    @Scope("prototype")
    AppListner listner() {
        return new AppListner();
    }
}
