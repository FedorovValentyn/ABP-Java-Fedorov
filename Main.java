package MyPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть номер лаби: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                Lab1.lab1();
            break;
            case 2 :
                Lab2.lab2();
            break;
            case 3 :
                Lab3.lab3();
            break;
            case 4 :
                Lab4.lab4();
            break;


        }
    }
}