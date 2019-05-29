package com.mooc.mall.service;


import com.mooc.mall.utils.ApplicationContextUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeanServiceImpl implements BeanService {

    @Autowired
    private ApplicationContextUtils applicationContextUtils;
    @Override
    public String[] findBeanList() {
        return applicationContextUtils.getBeanNames();
    }

    @Override
    public boolean isContentInContext(String beanName) {
        return applicationContextUtils.isHavaBean(beanName);
    }
}
