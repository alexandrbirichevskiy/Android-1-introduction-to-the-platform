package com.alexbirichevskiy.simplealculator;

import android.widget.Button;
import java.io.Serializable;

public class Calculations implements Serializable {
    private double sum;
    private Button buttonPlus;
    private Button buttonDiv;
    private Button buttonMinus;
    private Button buttonMult;
    private StringBuilder dataInput = new StringBuilder();

    public Calculations(Button buttonPlus, Button buttonDiv, Button buttonMinus, Button buttonMult) {
        this.buttonPlus = buttonPlus;
        this.buttonDiv = buttonDiv;
        this.buttonMinus = buttonMinus;
        this.buttonMult = buttonMult;
    }

    public void dataProcessing(StringBuilder dataInputStringBuilder){
        StringBuilder dataInputWithoutEqualChar = new StringBuilder(dataInputStringBuilder)
                                                    .deleteCharAt(dataInputStringBuilder.length()-1);
        String[] strArr = dataInputWithoutEqualChar.toString().split("[\\+\\*\\-/]");
        String[] strArr2 = dataInputWithoutEqualChar.toString().split("[0-9.]+");
        sum = Double.parseDouble(strArr[0]);
        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i].equals(buttonPlus.getResources().getString(R.string.plus))){
                sum = sum + Double.parseDouble(strArr[i]);
            } else if (strArr2[i].equals(buttonMinus.getResources().getString(R.string.minus))){
                sum = sum - Double.parseDouble(strArr[i]);
            } else if (strArr2[i].equals(buttonMult.getResources().getString(R.string.multiply))){
                sum = sum * Double.parseDouble(strArr[i]);
            } else if (strArr2[i].equals(buttonDiv.getResources().getString(R.string.div))){
                sum = sum / Double.parseDouble(strArr[i]);
            }
        }
    }

    public String getSum() {
        return String.valueOf(sum);
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public StringBuilder getDisplayInput() {
        return dataInput;
    }
}
