// 接口： 会游泳
interface Swimmable {
    void swim();
}

// 抽象类： 动物
abstract class Animal{
    private String name;
    public Animal(String name){
        this.name = name;
    }

    // 普通方法： 所有动物都一样
    public void sleep(){
        System.out.println(name + " 在睡觉");
    }

    public String getName(){
        return name;
    }   

    // 抽象方法； 每种动物吃东西的方式不同，留给子类实现
    public abstract void eat(); 
}

// 子类： 狗
class Dog extends Animal implements Swimmable{
    public Dog(String name){
        super(name);
    }

    @Override
    public void eat() {
        System.out.println(getName() + "在啃骨头!");
    }

    @Override
    public void swim() {
        System.out.println(getName() + "在游泳!");
    }   
}

// 子类： 猫
class Cat extends Animal{
    public Cat (String name){
        super(name);
    }

    @Override
    public void eat(){
        System.out.println(getName() + "在吃鱼!");
    }
}


// main
public class App {
    public static void main(String[] args) {
      
        Dog dog = new Dog("小黑");
        Cat cat = new Cat("小白");

        dog.eat();
        dog.sleep();
        dog.swim();

        System.out.println("---");
        cat.eat();
        cat.sleep();    
    }
}
