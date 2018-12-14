package newtest.offer;

import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ReplaceBlank {
    public static char[] ReplaceBlank(char[] str){
        int length= str.length;
        if(length<= 0){
            return null;
        }
        int oriLen= length;
        int newLen= length;
        for(int i= 0; i< length; i++){
            if(str[i]== ' '){
                newLen+= 2;
            }
        }

        char[] tempStr = new char[newLen];
        for(int i= length-1; i>= 0; i--){
            if(str[i]== ' '){
                tempStr[--newLen]= '0';
                tempStr[--newLen]= '2';
                tempStr[--newLen]= '%';
            }else{
                tempStr[--newLen]= str[i];
            }
        }
        return tempStr;
    }
    public static void printArray(char[] testArray){
        for(char i :testArray){
            System.out.print(i);
        }
        System.out.println();
    }

    public static void main(String[] args){
        String string = "             We are happy.";
        char[] str= string.toCharArray();
        char[] res= ReplaceBlank(str);
        printArray(res);
    }

}
