package me.nyu19.passwordgenerator;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class PasswordGenerator3000 {
    private String[] upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
    private String[] lower = "abcdefghijklmnopqrstuvwxyz".split("");
    private String[] nums = "0123456789".split("");
    private String[] spchar = "@#$%^&*!_".split("");
    private String result = "";
    private ArrayList<String[]> regex = new ArrayList<>();
    public String makePassword(int length,boolean switchUpper,boolean switchLower,boolean switchNums,boolean switchSpChar) throws NullPointerException{
//        String[][] regex = {switchUpper?upper:,switchLower?lower,switchNums?nums,switchSpChar?spchar};
        if (switchUpper){
            regex.add(upper);
        }if (switchLower){
            regex.add(lower);
        }if (switchNums){
            regex.add(nums);
        }if (switchSpChar){
            regex.add(spchar);
        }

        for (int i=0;i<length;i++){
            int rand = new Random().nextInt(nullChecker(regex.size()));
            String[] temp = regex.get(rand);
            result += temp[new Random().nextInt(temp.length)];
        }
//        System.out.println(result);
        return result;
    }
    private int nullChecker(int ew){
        if (ew == 0)
            throw new NullPointerException();
        else
            return ew;
    }
}
