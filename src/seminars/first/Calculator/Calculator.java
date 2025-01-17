package seminars.first.Calculator;

import java.util.Scanner;

public class Calculator {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int firstOperand = getOperand();
        int secondOperand = getOperand();
        char operator = getOperator();
        int result = calculation(firstOperand, secondOperand, operator);
        System.out.println("Результат операции " + operator + " = " + result);
//        scanner.close();

//        scanner.close();
    }

    public static char getOperator() {
        System.out.println("Введите оператор:");
        char operator = scanner.next().charAt(0);
        return operator;
    }

    public static int getOperand() {
        System.out.print("Введите число: ");

        if (scanner.hasNextInt()) {
            return scanner.nextInt();
        } else {
            System.out.println("Это не целое число. Попробуйте еще раз.");
            System.out.print("Введите число: ");
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                throw new IllegalStateException("Ошибка в вводимых данных");
            }
        }
    }

    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                if (firstOperand > 0 && secondOperand > 0 && firstOperand > Integer.MAX_VALUE - secondOperand) {
                    throw new ArithmeticException("Произошел выход результата из допустимых значений");
                }
                result = firstOperand + secondOperand;
                break;

            case '-':
                if (firstOperand < 0 && secondOperand > 0 && firstOperand < Integer.MIN_VALUE + secondOperand) {
                    throw new ArithmeticException("Произошел выход результата из допустимых значений");
                }
                result = firstOperand - secondOperand;
                break;

            case '*':
                if ((firstOperand > 0 && secondOperand > 0 && firstOperand > Integer.MAX_VALUE / secondOperand) ||
                        (firstOperand < 0 && secondOperand < 0 && firstOperand < Integer.MAX_VALUE / secondOperand) ||
                        (firstOperand > 0 && secondOperand < 0 && firstOperand > Integer.MIN_VALUE / secondOperand) ||
                        (firstOperand < 0 && secondOperand > 0 && secondOperand > Integer.MIN_VALUE / firstOperand)) {
                    throw new ArithmeticException("Результат превышает максимально допустимое значение");
                }
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            case '^':
                if (secondOperand < 0) {
                    throw new ArithmeticException("Возводим только в положительную степень");
                }
                if (Math.pow(firstOperand, secondOperand) > Integer.MAX_VALUE){
                    throw new ArithmeticException("Результат превышает максимально допустимое значение");
                }
                if (Math.pow(firstOperand, secondOperand) < Integer.MIN_VALUE){
                    throw new ArithmeticException("Результат меньше минимально допустимого значения");
                }
                result = (int) Math.pow(firstOperand, secondOperand);
                break;
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
    // необходимые проверки для него используя граничные случаи
    public static double squareRootExtraction(double num) {
        //  0
        //  Отрицательные числа
        //  Дробные значения корней
        //  Целые
        if (num < 0) {
            throw new IllegalArgumentException("Cannot calculate square root of a negative number");
        }
        return Math.sqrt(num);
    }

    // Нужно написать в калькуляторе метод вычисления суммы покупки со скидкой и проверить его, используя AssertJ
    // Примерная сигнатура и тело метода:
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        // purchaseAmount - сумма покупки
        // discountAmount - размер скидки

        if (purchaseAmount < 0 || discountAmount < 0 || discountAmount > 100) {
            throw new ArithmeticException("Недопустимые аргументы: сумма покупки не может быть неотрицательна, а размер скидки должен быть в диапазоне от 0 до 100.");
        } else
            return purchaseAmount - purchaseAmount * discountAmount / 100; // Метод должен возвращать сумму покупки со скидкой


    }
}