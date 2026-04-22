// 父类； 动物
class Animal {
    String name;
    int age;

    public Animal (String name, int age) {
        this.name = name;
        this.age = age;
    }
    void eat() {
        System.out.println(name + "正在吃东西");
    }

    void sleep() {
        System.out.println(name + "正在睡觉");
    }   

    void printInfo() {
        System.out.println("名字：" + name + " 年龄：" + age);
    }
}

// 子类： 狗---继承自 Animal
class Dog extends Animal {
    String breed; // 品种(Dog特有的属性)

    public Dog(String name, int age, String breed){
        super(name, age);
        this.breed = breed;
    }

    void bark() {
        System.out.println(name + "在叫:汪汪!");
    }

    // 重写父类eat的方法
    @Override
    void eat() {
        System.out.println(name + "正啃骨头");
    }
}

// 子类： 猫---继承自 Animal
class Cat extends Animal {
    boolean isIndoor; // 是否是室内猫(Cat特有的属性)
    
    public Cat (String name, int age, boolean isIndoor) {
        super(name, age);
        this.isIndoor = isIndoor;
    }

    void meow() {   // Cat特有的方法
        System.out.println(name + "在叫:喵喵!");
    }
    // 重写父类eat的方法
    @Override
    void eat() {
        System.out.println(name + "正在吃鱼");
    }
}

public class App {
    public static void main(String[] args) {
        Dog dog = new Dog("小黑", 3 , "拉布拉多");
        Cat cat = new Cat("小白", 2, true);

        // 使用继承自 Animal 的方法
        dog.printInfo();
        dog.eat();
        // 使用 Dog 类特有的方法
        dog.bark();

        System.out.println("--------------------");
        cat.printInfo();
        cat.eat();
        // 使用 Cat 类特有的方法
        cat.meow();    
    }
}