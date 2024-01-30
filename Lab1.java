package MyPackage;

import java.util.Scanner;

import static MyPackage.Lab11.FifthTask.getPrimeNumbers;
import static MyPackage.Lab11.SixthTask.generateTable;

public class Lab1 {             //Варіант 12
    public static void lab1() {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введіть значення x1: ");
        double x1 = scan.nextDouble();

        System.out.println("Введіть значення y1: ");
        double y1 = scan.nextDouble();

        System.out.println("Введіть значення x2: ");
        double x2 = scan.nextDouble();

        System.out.println("Введіть значення y2: ");
        double y2 = scan.nextDouble();

        System.out.println("Ваші змінні: " + "x1: " + x1 + "\t" + "y1: " + y1 + "\t" + "x2: " + x2 + "\t" + "y2: " + y2);


        double length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("Відстань між точками: " + length);

        double ABX = x2 - x1;
        double ABY = y2 - y1;
        System.out.println("Координати вектора AB : " + '(' + ABX + ',' + ABY + ')');


        double a, b, c;
        System.out.println("Введіть сторони трикутника: ");
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        if (a + b > c && a + c > b && b + c > a && a > 0 && b > 0 && c > 0) {
            System.out.println("Існує");
        } else {
            System.out.println("Не існує");
        }
        System.out.println("Введіть число а: ");
        Scanner check = new Scanner(System.in);
        int aq = check.nextInt();
        double firstRes = 0;
        double secondRes = 0;
        for (int i = 1; i <= aq; i++) {
            if (i % 2 == 0) {
                int fact = 1;
                for (int j = 1; j <= i; j++) {
                    fact *= j;
                }
                firstRes += i * Math.pow(3, i) / fact;
            }
            if (i % 2 != 0) {
                secondRes += (i + 1) / Math.pow(2, i);
            }
        }
        double realRes = firstRes + secondRes;
        System.out.println(realRes);


        Scanner scanner1 = new Scanner(System.in);

        System.out.println("Введіть перший елемент проміжку: ");
        int start = scanner1.nextInt();

        System.out.println("Введіть останній елемент проміжку: ");
        int end = scanner1.nextInt();

        int[] primeNumbersArray = getPrimeNumbers(start, end);

        System.out.println("Прості числа між " + start + " і " + end + ":");
        for (int prime : primeNumbersArray) {
            System.out.print(prime + " ");

        }
        System.out.println("Таблиця значень функції: ");
            String table = generateTable();
            System.out.println(table);

    }

}