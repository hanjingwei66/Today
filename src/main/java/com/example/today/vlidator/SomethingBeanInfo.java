package com.example.today.vlidator;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.beans.PropertyEditor;
import java.beans.SimpleBeanInfo;
import java.util.Map;

public class SomethingBeanInfo extends CustomEditorConfigurer  implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
    @Override
    public void setCustomEditors(Map<Class<?>, Class<? extends PropertyEditor>> customEditors) {
        super.setCustomEditors(customEditors);
//        customEditors.put()
    }

}
