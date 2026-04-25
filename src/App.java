// 定义接口： 可以驾驶的
interface Drivable {
    void drive();
}

// 定义接口： 可以充电的
interface Chargeable {
    void charge();
}

// 定义父类： 交通工具
class Vehicle {
    private String brand;
    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void printInfo() {
        System.out.println("品牌: " + brand);
    }
}

// 定义子类： 普通汽车，继承交通工具，实现可驾驶
class Car extends Vehicle implements Drivable {
    public Car(String brand) {
        super(brand);
    }

    @Override
    public void drive() {
        System.out.println("汽车正在驾驶...");
    }
}

// 定义子类： 电动汽车，继承交通工具，实现可驾驶和可充电
class ElectricCar extends Vehicle implements Drivable, Chargeable {
    public ElectricCar(String brand) {
        super(brand);
    }

    @Override
    public void drive() {
        System.out.println("电动汽车正在驾驶...");
    }

    @Override
    public void charge() {
        System.out.println("电动汽车正在充电...");
    }
}

// main
public class App {
    public static void main(String[] args) {
        Car car = new Car("丰田");
        ElectricCar ec = new ElectricCar("特斯拉");

        car.printInfo();
        car.drive();
        System.out.println("---");
        ec.printInfo();
        ec.drive();
        ec.charge();
    }
}