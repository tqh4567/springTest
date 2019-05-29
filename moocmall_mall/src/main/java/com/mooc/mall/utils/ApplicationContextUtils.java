package com.mooc.mall.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtils implements ApplicationContextAware {

    private static ApplicationContext context;
  
    
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(applicationContext!=null) {
            ApplicationContextUtils.context = applicationContext;
        }
    }

    /**
     * 获取ApplicationContext
     * @return
     */
    public static ApplicationContext getApplicationContext(){
        return context;
    }

    /**
     * 通过name判断容器中是否包含此Bean
     */
    public  boolean isHavaBean(String beanName){
        return context.containsBean(beanName);
    }
    /**
     * 获取容器中Bean的列表
     */
    public  String[] getBeanNames(){
        return context.getBeanDefinitionNames();
    }
}
