package org.unpredictableXpractice.awareInterface;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

@Component("god")
public class Mahakal implements BeanNameAware {

    public Mahakal(){
        System.out.println("Mahakal is creator");
    }

    public void bless(){
        System.out.println("Blessed");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean name is : " + name);
    }
}
