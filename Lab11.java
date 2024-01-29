package MyPackage;

import java.util.ArrayList;

public class Lab11 {
    public static void lab11() {

    }

    public class FirstTask {
        public double checkForLength(double x1, double y1, double x2, double y2) {
            return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        }
    }

    public class SecondTask {
        public double[] checkForCoordinates(double x1, double y1, double x2, double y2) {
            return new double[]{(x2 - x1), (y2 - y1)};
        }
    }

    public class ThirdTask {
        public boolean checkForExisting(double a, double b, double c) {
            return a + b > c && a + c > b && b + c > a && a > 0 && b > 0 && c > 0;
        }
    }

    public class FourthTask {
        public double checkForCalculation(int a) {
            double firstRes = 0;
            double secondRes = 0;
            for (int i = 1; i <= a; i++) {
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
            return realRes;
        }
    }


    public class FifthTask {
        public static boolean isPrime(int n) {
            if (n <= 1) {
                return false;
            }
            for (int i = 2; i * i <= n; i++) {
                if (n % i == 0) {
                    return false;
                }
            }
            return true;
        }

        public static int[] getPrimeNumbers(int start, int end) {
            ArrayList<Integer> primeNumbersList = new ArrayList<>();
            for (int number = start; number <= end; number++) {
                if (isPrime(number)) {
                    primeNumbersList.add(number);
                }
            }
            int[] primeNumbersArray = new int[primeNumbersList.size()];
            for (int i = 0; i < primeNumbersList.size(); i++) {
                primeNumbersArray[i] = primeNumbersList.get(i);
            }
            return primeNumbersArray;
        }
    }
    public class SixthTask {

        public static double f(double x) {
            return 1 - Math.pow(x, 2) / 2 + Math.pow(x, 4) / 4 - Math.pow(x, 6) / 6;
        }
        public static String generateTable() {
            double a = 0;
            double b = 12;
            int step = 1;

            StringBuilder table = new StringBuilder("x\tf(x)\n");

            for (double x = a; x <= b; x += step) {
                double y = f(x);
                table.append(String.format("%.2f\t%.2f\n", x, y));
            }
            return table.toString();
        }
    }
}
