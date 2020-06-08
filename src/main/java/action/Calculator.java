package action;

public class Calculator {
    public static double calculator(double a, double b, String operation) {
        switch (operation) {
            case "plus":
                return a + b;
            case "minus":
                return a - b;
            case "power":
                return a * b;
            case "divided":
                return a / b;
            default:
                return 0;
        }
    }
    public static char getSymbol(String operation){
        switch (operation){
            case "plus":
                return '+';
            case "minus":
                return '-';
            case "power":
                return '*';
            case "divided":
                return '/';
            default:
                return ' ';
        }
    }

}
