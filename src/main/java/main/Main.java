package main;

import beans.AppConfig;
import beans.RootBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        RootBean bean = ctx.getBean(RootBean.class);
        System.out.println(bean);
    }
}
