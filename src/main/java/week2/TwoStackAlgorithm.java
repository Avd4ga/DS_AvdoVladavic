package week2;

import javax.xml.crypto.Data;
import java.util.Arrays;
import java.util.List;
import java.util.Collection.*;
import java.util.Stack;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class TwoStackAlgorithm {
    public static Double calculate(String expression) {
        String[] operations = expression.split("\\s+");
        Stack<Double> values = new Stack<>();
        Stack<String> operators = new Stack<>();
        for (String operation : operations) {
            if (operation.equals("(")) {
                continue;
            } else if (operation.equals("+") || operation.equals("-") ||
                    operation.equals("*") || operation.equals("/") ||
                    operation.equals("%") || operation.equals("^") ||
                    operation.equals("√")) {
                operators.push(operation);
            } else if (operation.equals(")")) {
                String operator = operators.pop();
                Double secondValue = values.pop();
                if (operator.equals("√")) {
                    values.push(Math.sqrt(secondValue));
                } else {
                    Double firstValue = values.pop();
                    Double result;
                    switch (operator) {
                        case "+":
                            result = firstValue + secondValue;
                            break;
                        case "-":
                            result = firstValue - secondValue;
                            break;
                        case "*":
                            result = firstValue * secondValue;
                            break;
                        case "/":
                            result =firstValue / secondValue;
                            break;
                        case "%":
                            result =firstValue % secondValue;
                            break;
                        case "^":
                            result = Math.pow(firstValue, secondValue);
                            break;
                        default:
                            result = (double) 0;
                            break;
                    }
                    values.push(result);
                }
            } else {
                values.push(Double.valueOf(operation));
            }
        }
        return values.pop();
    }
}
