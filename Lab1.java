package MyPackage;

import java.util.Scanner;

public class Lab1 {             //Варіант 12
    public static void lab1(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Введіть значення x1: ");
        double x1 = scan.nextDouble();

        System.out.println("Введіть значення y1: ");
        double y1 = scan.nextDouble();

        System.out.println("Введіть значення x2: ");
        double x2 = scan.nextDouble();

        System.out.println("Введіть значення y2: ");
        double y2 = scan.nextDouble();

        System.out.println("Ваші змінні: "+"x1: " + x1 +"\t"+ "y1: " + y1+"\t" + "x2: " + x2+"\t" + "y2: " + y2);


        double length = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("Відстань між точками: " + length);

        double ABX = x2- x1;
        double ABY = y2 -y1;
        System.out.println("Координати вектора AB : "+'('+ABX+','+ABY+')');

    }
}
