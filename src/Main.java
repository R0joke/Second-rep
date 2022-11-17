public class Main {
    public static void main(String[] args) {
        //Vehicle car = new Vehicle("Audi 7", 250.0, true, 0);
        //car.refuel();
        //car.checkFuel(car.getFuel());
        //System.out.println("Топливо: " + car.checkFuel(car.getFuel()));
        //car.drive();
        //System.out.println("Топливо: " + car.checkFuel(car.getFuel()));
        //SUV suv = new SUV("213", 223, true, 22, 4);
        //suv.stop();
        //suv.drive();
        //System.out.println(suv.getCountWheels());
        Vehicle suv1 = new SUV("213", 223, true, 22, 4);
        Vehicle pscar1 = new PsCar("Audi 7", 250.0, true, 0);
        Vehicle pscar2 = new PsCar("Audi 8" +
                "", 250.0, true, 0);

        Vehicle[] vehicles = {suv1, pscar1, pscar2};
        TransportSorter ts = new TransportSorter(vehicles);
        ts.print(vehicles);
        ts.sort(vehicles);
    }
    public static class Vehicle{
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
        public void drive(){
            System.out.println("Вы начали поездку");
            for (fuel = checkFuel(getFuel()); fuel >= 0; fuel--){
                if (getFuel() >= 0){
                    System.out.println("Вы едите и сжигаете топливо " + getFuel());
                } else if (getFuel() <= 0) {
                    fuel = fuel + 1;
                    break;
                }
                if (getFuel() == 0) {
                    System.out.println("У вас кончилось топливо " + getFuel());
                }
            }
        }
        public void stop(){
            System.out.println("Вы остановились");
        }
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
            System.out.println("Ваш SUV разбился");
        }
        public void stop(){
            System.out.println("Тормоза отказали");
        }
        public void setCountWheels(int countWheels) {
            this.countWheels = countWheels;
        }
        public int getCountWheels() {
            return countWheels;
        }
    }
    public static class PsCar extends Vehicle{
        public PsCar(String model, double speed, boolean isDieselFuel, int fuel) {
            super(model, speed, isDieselFuel, fuel);
        }
    }
    public static class Cycle extends Vehicle {
        public Cycle(String model, double speed, boolean isDieselFuel, int fuel) {
            super(model, speed, isDieselFuel, fuel);
        }
    }
    public static class TransportSorter extends Vehicle{
        public TransportSorter(Vehicle[] vehicles){
        }
        public void print(Vehicle[] vehicles){
            for(Vehicle it: vehicles){
                System.out.println(it.getModel());
            }
        }
        public void sort(Vehicle[] vehicles){
            for(Vehicle it: vehicles){
                if (it.getModel() == "213"){
                    System.out.println("это число");
                } else {
                    System.out.println("Транспортное средство " + it.getModel() + " отправляется туда то");
                }
            }
        }
    }
}