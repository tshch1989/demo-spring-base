package com.example.demo.auxiliary;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class My1BeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition definition = beanFactory.getBeanDefinition("say");
        MutablePropertyValues propertyValues = definition.getPropertyValues();
        propertyValues.addPropertyValue("name1", "tshch1989@sina.com");
        propertyValues.addPropertyValue("name2", "tshch1989@sina.com");
    }
}
