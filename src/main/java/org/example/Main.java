package org.example;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int n = 495;
        System.out.println(kaprekar(n));

    }

    public static int kaprekar(int n){
        if (n == 6174) return 0; //Base case
        else{
            //Make array of digits
            int[] digits = new int[4];
            int x;
            for (int i=1; i<=4; i++){
                x = (int) Math.pow(10.0, i);
                digits[i-1] = (n % x) / ((int) Math.pow(10, i-1));
                n -= n % x;
            }

            //Sort array
            boolean flag = true;
            int temp;
            while (flag) {
                flag = false;
                for (int i=0; i<digits.length-1; i++){
                    if (digits[i] > digits[i+1]){
                        temp = digits[i+1];
                        digits[i+1] = digits[i];
                        digits[i] = temp;
                        flag = true;
                    }
                }
            }

            //Handle case where number has all same digits
            boolean allSame = true;
            for (int i=0; i<digits.length -1; i++){
                if (digits[i]!=digits[i+1]){
                    allSame = false;
                    break;
                }
            }
            if (allSame) digits[0] = 0;

            //Find difference between big and small
            double big = 0;
            for (int i=0; i<digits.length; i++){
                big += digits[i] * Math.pow(10, i);
            }
            double small = 0;
            for (int i=digits.length -1; i>=0; i--){
                small += digits[i] * Math.pow(10, digits.length - i - 1);
            }

            //Recursive step
            int difference = (int) (big - small);
            return (1 + kaprekar(difference));
        }
    }




}