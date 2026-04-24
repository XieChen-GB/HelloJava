// 定义接口：可以游泳的
interface Swimmable {
    void swim();    
}

// 定义接口：可以飞的
interface Flyable{
    void fly();
}

// 父类： 动物
class Animal{
    String name;
    public Animal(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println(name + "在吃东西");
    }
}
// 狗：继承 Animal，实现 Swimmable 接口
class Dog extends Animal implements Swimmable {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(name + "正在游泳");
    }
}

// 鸭子：继承 Animal，同时实现 Swimmable 和 Flyable 两个接口
class Duck extends Animal implements Swimmable , Flyable {
    public Duck (String name){
        super(name);
    }

    @Override
    public void swim() {
        System.out.println(name + "在游泳");
    }

    @Override
    public void fly() {
        System.out.println(name + "在飞翔");
    }
}

public class App {
    public static void main(String[] args) {

        Dog dog = new Dog("小黑");
        Duck duck = new Duck("唐老鸭");


        dog.eat();
        dog.swim();

        System.out.println("---");

        duck.eat();
        duck.swim();
        duck.fly();
    }
}