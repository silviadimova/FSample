package com.filip.sample.kotlin.usage

import com.filip.sample.kotlin.MyValidator
import com.filip.sample.kotlin.MyValidatorJ

class MyProgram {

    private fun myMethod(): Pair<MyValidator,MyValidatorJ> {
        val validator = MyValidator("ihj")
        val validatorJ = MyValidatorJ("ghvh")

        return Pair(validator, validatorJ)

    }

    private fun usageOfPair(){
        val p: Pair<MyValidator,MyValidatorJ> = myMethod()
        if(p.first.name == p.second.name) {
            //jnjnhuj
        }
    }

}
