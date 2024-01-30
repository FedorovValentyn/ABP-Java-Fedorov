package MyPackage;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import java.awt.EventQueue;

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
            case 5 :
                Lab5.lab5();
            break;
            case 6:
                Lab6.lab6();
            break;
            case 7 :
                Lab7.lab7();
             break;
            case 8:
                Lab8.lab8();
            break;
            case 9:
                Lab9.lab9();
            break;
            case 10:
                Lab10.lab10();
            break;
            case 11:
                Lab11.lab11();
            break;
        }
    }
}