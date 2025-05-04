package org.example;

import java.lang.reflect.Constructor;

public class BeanDefinition {

    Class<?> clazz;
    Constructor<?> constructor;

    public BeanDefinition(Class<?> beanClass) {

        clazz = beanClass;
        try {
            constructor = clazz.getConstructor();
        } catch (NoSuchMethodException e) {}
    }

    public String getBeanName() {
        return clazz.getName();
    }

    public Constructor<?> getConstructor() throws NoSuchMethodException {
        return constructor;
    }

}
