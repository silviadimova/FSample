package com.filip.sample.kotlin;

import java.util.ArrayList;
import java.util.List;

import kotlin.collections.CollectionsKt;

public class MyValidatorJ {
    public String name;
    public int age;

    public MyValidatorJ(String argName){
        name = argName;
    }

    public boolean isValidName(){
        final List<String> list = CollectionsKt.mutableListOf("Silvia", "Stoycho","Filip", "Irmena");
        return list.contains(name);
    }
    public boolean isValidAge(){
        return age >=18;
    }

}
