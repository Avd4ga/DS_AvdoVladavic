package week2;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.List;
import java.util.Collection.*;
import java.util.Stack;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class TwoStackAlgorithm<Data> {
    private static Stack<Double> s1;
    private static Stack<Character> s2;



    public static Double calculate(String expression) {
        // your code here (remove next line)


        s1=new Stack<>();
        s2=new Stack<>();
        char[] chars=expression.toCharArray();
        for(int i=0;i<chars.length;i++){

            if(chars[i]>='0' && chars[i]<='9'){
                s1.push((double) Character.getNumericValue(chars[i]));
            }else if(chars[i]=='.'){
                double temp=s1.pop();
                s1.push(temp+chars[i+1]-temp);

            } else if(chars[i]=='+' ||chars[i]=='-'||chars[i]=='*'||chars[i]=='/'||chars[i]=='%'||chars[i]=='^'||chars[i]=='√'){
                s2.push(chars[i]);
            } else if (chars[i]==')') {
                double num1=s1.pop();
                double num2=s1.pop();
                char op=s2.pop();
                switch (op){
                    case '+' : s1.push(num1 + num2);
                        break;
                    case '-' : s1.push(num2 - num1);
                        break;
                    case '*' : s1.push(num2 *  num1);
                        break;
                    case '/' : s1.push(num1 /  num2);
                        break;
                    case '%' : s1.push(num1 % num2);
                        break;
                    case '^' : s1.push(pow(num1,num2));
                        break;
                    case '√' : s1.push(sqrt(num2));
                        break;
                }
            }

        }
        return s1.pop();
    }
}
