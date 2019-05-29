package com.mooc.mall.service;

public interface BeanService {
    String[] findBeanList();

    /**
     * 按名称再容器中查找Beab
     * @param beanName
     * @return
     */
    boolean isContentInContext(String beanName);
}
