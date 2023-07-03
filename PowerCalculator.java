// Задача1. 
// Напишите программу-калькулятор, которая запрашивает у пользователя два числа 
// и выполняет операцию возведения первого числа в степень второго числа. 
// Если введены некорректные числа или происходит деление на ноль, 
// необходимо обработать соответствующие исключения и вывести информативное сообщение об ошибке.

import java.util.InputMismatchException;
import java.util.Scanner;

public class PowerCalculator {
    public static void main(String[] args) {
        try {
            double number1 = getNumber("Enter number 1: ");
            double number2 = getNumber("Enter number 2: ");
            double result = calculatePower(number1, number2);
            System.out.println(number1 + " ^ " + number2 + " = " + result);
        } catch (InputMismatchException e) {
            System.out.println("Error! Not a number entered");
        } catch (InvalidInputException e) {
            System.out.println("Error! " + e.getMessage());
        }
    }

    public static double calculatePower(double num1, double num2) throws InvalidInputException {
        if (num1 == 0) {
            throw new InvalidInputException("Incorrect base value");
        }
        if (num2 < 0) {
            throw new InvalidInputException("Incorrect power value");
        }
        return Math.pow(num1, num2);
    }

    public static double getNumber(String prompt) throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        System.out.print(prompt);
        return sc.nextDouble();
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}
