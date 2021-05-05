package com.alexbirichevskiy.simplealculator;

public class Calculations {
    private double sum;

    public void parseInput(StringBuilder sb){
        StringBuilder q = new StringBuilder(sb).deleteCharAt(sb.length()-1);
        String[] strArr = q.toString().split("[\\+\\*\\-/]");
        String[] strArr2 = q.toString().split("[0-9.]+");
        sum = Double.parseDouble(strArr[0]);
        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i].equals("+")){
                sum = sum + Double.parseDouble(strArr[i]);
            }
            else if (strArr2[i].equals("-")){
                sum = sum - Double.parseDouble(strArr[i]);
            }
            else if (strArr2[i].equals("*")){
                sum = sum * Double.parseDouble(strArr[i]);
            }
            else if (strArr2[i].equals("/")){
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

}
