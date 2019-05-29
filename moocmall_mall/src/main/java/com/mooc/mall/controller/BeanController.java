package com.mooc.mall.controller;


import com.mooc.mall.service.BeanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/bean")
public class BeanController {

    @Autowired
    private BeanService beanService;
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String[] getBeanList() {
        return beanService.findBeanList();
    }

    @RequestMapping(value = "/{beanName}",method = RequestMethod.GET)
    public boolean isHaveBean(@PathVariable String beanName) {
        return beanService.isContentInContext(beanName);
    }
}
