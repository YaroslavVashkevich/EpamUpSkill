package com.rd.epam.autotasks.scopes.config;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThreeTimesScopeConfig {
    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
        return configurableListableBeanFactory -> configurableListableBeanFactory.registerScope("threeTimes", new ThreeTimesScope());
    }
}
