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
        // 多态写法：用父类类型的变量指向子类对象
        Animal animal1 = new Dog("小黑",3,"拉布拉多");
        Animal animal2 = new Cat("小白",2,true);

        // 调用 eat()——执行各自重写的版本
        animal1.eat(); // 输出: 小黑正啃骨头
        animal2.eat(); // 输出: 小白正在吃鱼

        // 用数组存放多个动物（多态的典型应用）
        Animal[] animals = {
            new Dog ("小黑",3,"拉布拉多"),
            new Cat("小白",2, true),
            new Dog("旺财",5,"柴犬")
        };

        System.out.println("--- 所有动物吃东西 ---");
        for (Animal a: animals) {
            a.eat(); // 根据实际对象类型调用对应的eat()方法
        }
    }
}