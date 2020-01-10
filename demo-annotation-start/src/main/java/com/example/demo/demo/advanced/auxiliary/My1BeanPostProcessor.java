package com.example.demo.demo.advanced.auxiliary;

import com.example.demo.manual.Say;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class My1BeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Say){
            ((Say) bean).setName1("tshch1989@sina.com");
            ((Say) bean).setName2("tshch1989@sina.com");
        }
        return bean;
    }
}
