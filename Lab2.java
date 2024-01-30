package MyPackage;

import java.util.Scanner;

public class Lab2 {                  //Варіант 12

    public static void lab2() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введіть довжину, ширину і висоту прямокутного паралелепіпеда: ");
        double x = scan.nextDouble();
        double y = scan.nextDouble();
        double z = scan.nextDouble();
        System.out.println(x + " " + y + " " + z);
        PryamokutnyiParalelepiped user = new PryamokutnyiParalelepiped(x, y, z);
        System.out.println("Сума площі всіх граней: "+ user.getSum());
        System.out.println("Об'єм прямокутного паралелепіпеда: "+ user.getVolume());
            scan.close();

    }
}
          class PryamokutnyiParalelepiped {
            double xDimention;
            double yDimention;
            double zDimention;
            double sum;
            double volume;

            public PryamokutnyiParalelepiped(double xDimention, double yDimention, double zDimention) {
                this.xDimention = xDimention;
                this.yDimention = yDimention;
                this.zDimention = zDimention;
                this.sum = 2*(xDimention*yDimention+xDimention*zDimention+yDimention*zDimention);
                this.volume = xDimention*yDimention*zDimention;
            }

            public double getxDimention() {
                return xDimention;
            }

            public double getyDimention() {
                return yDimention;
            }

            public double getzDimention() {
                return zDimention;
            }

              public double getSum() {
                  return sum;
              }

              public double getVolume() {
                  return volume;
              }
          }

