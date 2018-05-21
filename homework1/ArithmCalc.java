import java.util.Scanner;

public class ArithmCalc{
    public static void main (String [] args) {

        Scanner userInput = new Scanner(System.in);


        System.out.println("Insert the math operation");
        double a = userInput.nextDouble();
        char operator = userInput.next().charAt(0);
        double b = userInput.nextDouble();
        double result = 0;

        switch (operator){
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                if (b == 0){
                    System.out.println ("Impossible to divide by 0");
                }else {
                    result = a / b;
                    }
                break;
            default:
                System.out.println(operator + " is not a math operator");
        }
        if ((operator == '+') || (operator == '-') || (operator == '*') || ((operator == '/') && (b != 0)))
        System.out.println ("The result is: " + result);
    }
}