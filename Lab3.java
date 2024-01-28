package MyPackage;


                //інтерфейс run
interface Run {
    void displayVehicleName();
    int getSpeed();
    int getWeight();
    int getPassengerCount();
    int getNumberOfWheelsOrTransmission();
}

                                //Абстрактний клас Mashine
abstract class Machine implements Run {
    final int MAX_SPEED = 200;
    final int MIN_SPEED = 0;
    final int MIN_PASSENGER_COUNT = 1;
    final int MAX_PASSENGER_COUNT = 10;
    String vehicleName;
    int currentSpeed;

    Machine(String name, int speed) {
        this.vehicleName = name;
        this.currentSpeed = speed;
    }

    @Override
    public void displayVehicleName() {
        System.out.println("Назва засобу: " + vehicleName);
    }
}

                // суперклас для літаків
abstract class Aircraft extends Machine {
    int wingspan;

    Aircraft(String name, int speed, int wingspan) {
        super(name, speed);
        this.wingspan = wingspan;
    }

    @Override
    public int getNumberOfWheelsOrTransmission() {
        return 3;
    }
}

                            //F-117 Nighthawk
class JetAircraft extends Aircraft {
    JetAircraft(String name, int speed, int wingspan) {
        super(name, speed, wingspan);
    }

    @Override
    public int getSpeed() {
        return currentSpeed;
    }

    @Override
    public int getWeight() {
        return 20000;
    }

    @Override
    public int getPassengerCount() {
        return 1;
    }

    @Override
    public void displayVehicleName() {
        super.displayVehicleName();
        System.out.println("Тип: реактивний літак");
    }
}

            //кукурудзник
class CropDuster extends Aircraft {
    CropDuster(String name, int speed, int wingspan) {
        super(name, speed, wingspan);
    }

    @Override
    public int getSpeed() {
        return currentSpeed;
    }

    @Override
    public int getWeight() {
        return 5200;
    }

    @Override
    public int getPassengerCount() {
        return 2;
    }

    @Override
    public void displayVehicleName() {
        super.displayVehicleName();
        System.out.println("Тип: поршневий літак");
    }
}

public class Lab3 {
    public static void lab3(){
        JetAircraft jet = new JetAircraft("F-117 Nighthawk", 1000, 13);
        CropDuster cropDuster = new CropDuster("AH-2", 150, 6);

                // інфа про F-117
        jet.displayVehicleName();
        System.out.println("Швидкість: " + jet.getSpeed() + " км/г");
        System.out.println("Вага: " + jet.getWeight() + " кг");
        System.out.println("Кількість пасажирів: " + jet.getPassengerCount());
        System.out.println("Розмах крил: " + jet.wingspan + " м");
        System.out.println();

                //інфа про кукурудзник
        cropDuster.displayVehicleName();
        System.out.println("Швидкість: " + cropDuster.getSpeed() + " км/г");
        System.out.println("Вага: " + cropDuster.getWeight() + " кг");
        System.out.println("Кількість пасажирів: " + cropDuster.getPassengerCount());
        System.out.println("Розмах крил: " + cropDuster.wingspan + " м");
    }
}

