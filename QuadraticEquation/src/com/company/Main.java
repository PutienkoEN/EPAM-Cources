package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.close();

        calculate(a, b, c);
    }

    private static void calculate(double a, double b, double c) {

        double discriminant = b * b - 4 * a * c;

        if (discriminant < 0){
            System.out.print("No solution");
        }
        if (discriminant == 0) {
            double x1 = - (b / (2 * a));
            System.out.format(Locale.US, "One solution: " + x1);
        } else if (discriminant > 0) {
            double x1 = ((-b - Math.sqrt(b * b - 4 * a * c)) / (2 * a));
            double x2 = ((-b + Math.sqrt(b * b - 4 * a * c)) / (2 * a));
            String x1result = valueToString(x1);
            String x2result = valueToString(x2);

            System.out.printf("Two solutions: " + x1result + ", " + x2result);
        }
    }

    private static String valueToString(double val){
        String result;
        if (val == (int)val){
            result = Integer.toString((int)val);
        } else {
            val = Math.round(val * 100)/(double) 100;
            result = Double.toString(val);
        }
        return result;
    }
}
