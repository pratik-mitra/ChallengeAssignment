package com.gl.globalcalculator.validation;

import android.content.Context;
import android.widget.Toast;

public class FieldValidation {

    public static boolean validateFieldBasic(String firstNumber, String secondNumber, Context main){

        if (firstNumber.isEmpty()) {
            Toast t = Toast.makeText(main, "please enter number", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }
        if (secondNumber.isEmpty()) {
            Toast t = Toast.makeText(main, "please enter number", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }

        return true;
    }

    public static boolean validateFieldScientific(String firstNumber, Context main) {

        if (firstNumber.isEmpty()) {
            Toast t = Toast.makeText(main, "please enter number", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }
        return true;
    }

    public static boolean validateFieldZero(String secondNumber, Context main) {

        if (secondNumber.equals("0")) {
            Toast t = Toast.makeText(main, "Can't Divide By Zero", Toast.LENGTH_SHORT);
            t.show();
            return false;
        }
        return true;
    }


}

