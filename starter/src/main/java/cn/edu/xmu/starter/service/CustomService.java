package cn.edu.xmu.starter.service;

import cn.edu.xmu.starter.property.CustomizationProperties;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author summer
 * @date 2021/2/21 23:10
 */
public class CustomService {

    private CustomizationProperties customizationProperties;

    public CustomService(CustomizationProperties customizationProperties){
        this.customizationProperties=customizationProperties;
    }
    public void sayHello(){
        System.out.println("hi,my name is "+customizationProperties.getName()+"\n"
        +"I'm "+customizationProperties.getAge()+"\n");
    }
}
