public class Main {
    public static void main(String[] args) {
        Vehicle suv1 = new SUV("Mustang", 223, true, 42, 4);
        Vehicle pscar1 = new PsCar("Lamgorgini", 250.0, true, 23);
        Vehicle pscar2 = new PsCar("Audi 8", 200.0, true, 30);
        Vehicle plane = new Plane("AirBus", 1000, false, 100);
        Vehicle flycar = new FlyingCar("Dellorian", 500, false, 100);
        Vehicle[] vehicles = {suv1, pscar1, pscar2, plane,flycar};
        TransportSorter ts = new TransportSorter(vehicles);
        ts.sort(vehicles);
    }
    public static abstract class Vehicle{
        private String model;
        private double speed;
        private boolean isDieselFuel;
        private int fuel;
        private int countWheels;

        public Vehicle(String model, double speed, boolean isDieselFuel, int fuel){
            this.model = model;
            this.speed = speed;
            this.isDieselFuel = isDieselFuel;
            this.fuel = fuel;
        }
        public Vehicle() {
        }
        abstract public void drive();
        abstract public void stop();
        public String getModel() {
            return model;
        }
        public double getSpeed() {
            return speed;
        }
        public int refuel(){
            for (fuel = getFuel(); fuel <= checkFuel(getFuel()); fuel++){
            }
            return fuel;
        }
        public int checkFuel(int fuel){
            if (fuel == 100){
                System.out.println("Ваш бак полон " + getFuel());
            } else if (fuel < 0) {
                fuel = fuel + 1;
            } else if (fuel <= 100) {
                System.out.println("Ваш бак не полон " + getFuel());
            } else if (fuel >= 100) {
                fuel = fuel - 1;
            }
            return fuel;
        }
        public boolean isDieselFuel() {
            if (isDieselFuel == true) {
                System.out.println("Топливо дизельное");
            } else if (isDieselFuel == false) {
                System.out.println("Топливо не дизельное");
            }
            return isDieselFuel;
        }
        public int getFuel() {
            return fuel;
        }
        public void setCountWheels(int countWheels) {
            this.countWheels = countWheels;
        }
        public int getCountWheels() {
            return countWheels;
        }
    }
    public static class SUV extends Vehicle{
        private int countWheels;
        public SUV(String model, double speed, boolean isDieselFuel, int fuel, int countWheels) {
            super(model, speed, isDieselFuel, fuel);
            this.countWheels = countWheels;
        }
        @Override
        public void drive(){
            System.out.println("Ваш " + getModel() + " разбился");
        }
        public void stop(){
            System.out.println("Тормоза " + getModel() + " отказали");
        }
        public void setCountWheels(int countWheels) {
            this.countWheels = countWheels;
        }
        public int getCountWheels() {
            return countWheels;
        }

        public String toString() {
            return getModel() + " это корова";
        }
    }
    public static class PsCar extends Vehicle{
        public PsCar(String model, double speed, boolean isDieselFuel, int fuel) {
            super(model, speed, isDieselFuel, fuel);
        }
        @Override
        public void drive(){
            System.out.println("Ваш Легкоавтомобиль спокойно едет");
        }
        public void stop(){
            System.out.println("Вы остановились");
        }

        public String toString() {
            return getModel() + " это легковая машина";
        }
    }
    public static class Cycle extends Vehicle {
        public Cycle(String model, double speed, boolean isDieselFuel, int fuel) {
            super(model, speed, isDieselFuel, fuel);
        }
        public void drive(){
            System.out.println("Ваш Легкоавтомобиль спокойно едет");
        }
        public void stop(){
            System.out.println("Вы остановились");
        }
        public String toString() {
            return getModel() + " это колесо";
        }

    }
    public static class TransportSorter extends Vehicle implements Flyable{
        public TransportSorter(Vehicle[] vehicles){
        }
        public void print(Vehicle[] vehicles){
            for(Vehicle it: vehicles){
                System.out.println(it.getModel());
            }
        }
        public void sort(Vehicle[] vehicles){
            for(Vehicle it: vehicles){
                System.out.println(it.toString());
                if (it instanceof Flyable){
                    it.drive();
                    if(it instanceof Flyable){
                        ((Flyable) it).fly();
                        System.out.println(it.getModel() + " взлетел");
                    }
                    System.out.println(it.getModel() + " отправляется в ангары воздушной техники");
                    if (it instanceof  Flyable){
                        ((Flyable) it).landing();
                        System.out.println(it.getModel() + " совершил посадку");
                    }
                    it.stop();
                } else {
                    System.out.println("Транспортное средство " + it.getModel() + " отправляется в дальнее путешествие");
                }
            }
        }
        @Override
        public void drive() {
        }
        @Override
        public void stop() {
        }

        @Override
        public void fly() {

        }

        @Override
        public void landing() {

        }
    }
    public interface Flyable {
        void fly();
        void landing();
    }
    public static class Plane extends Vehicle implements Flyable{
        public Plane(String model, double speed, boolean isDieselFuel, int fuel) {
            super(model, speed, isDieselFuel, fuel);
        }
        @Override
        public void drive() {
            System.out.println("Ваш " + getModel() + " начал разгон");
        }

        @Override
        public void stop() {
            System.out.println("Ваш " + getModel() + "  остановился");
        }
        @Override
        public void fly() {
        }
        @Override
        public void landing() {
        }
        public String toString() {
            return getModel() + " это летающая птица";
        }

    }
    public static class FlyingCar extends PsCar implements Flyable{
        public FlyingCar(String model, double speed, boolean isDieselFuel, int fuel) {
            super(model, speed, isDieselFuel, fuel);
        }
        @Override
        public void drive() {
            System.out.println("Ваша " + getModel() + " начала разгогрев");
        }

        @Override
        public void stop() {
            System.out.println("Ваша " + getModel() + " остановился");
        }
        @Override
        public void fly() {
        }
        @Override
        public void landing() {
        }
        public String toString() {
            return getModel() + " это машина будущего";
        }
    }
}