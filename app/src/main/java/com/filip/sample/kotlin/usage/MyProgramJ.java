package com.filip.sample.kotlin.usage;

import com.filip.sample.kotlin.MyValidator;
import com.filip.sample.kotlin.MyValidatorJ;
import com.filip.sample.kotlin.components.MyCustomInterface;

import kotlin.Pair;


public class MyProgramJ {

    private Pair<MyValidator, MyValidatorJ> myMethod() {
        final MyValidator validator = new MyValidator("jnij", 34);
        final MyValidatorJ validatorJ = new MyValidatorJ("jk");
        return new Pair<>(validator,validatorJ);
    }

    private void usageOfPair(){
         Pair<MyValidator, MyValidatorJ> p = myMethod();
        if(p.getFirst().getName().equals(p.getSecond().name)){
            //ugvghb
        }
    }

}
