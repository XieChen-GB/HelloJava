// 定义一个“人”的类
class Person {
    // 定义变量（属性） --描述这个人有什么
    String name;  // 姓名
    int age ;     // 年龄
    String job;   // 职业

    // 成员方法（行为） -- 描述一个人能做什么
    void sayHello() {
        System.out.println("你好！我叫" + name + " 今年" + age + "岁，职业是" + job);
    }

    void birthday() {
        age++;  // 年龄加1
        System.out.println("过生日了！现在我" + age + "岁了！");
    }
}

// 主程序
public class App {
    public static void main(String[] args) {

        // 创建第一个对象
        Person p1 = new Person();
        p1.name = "谢晨";
        p1.age = 57;
        p1.job = "IT工程师";
        p1.sayHello();

        // 创建第二个对象
        Person p2 = new Person();
        p2.name = "田中";
        p2.age = 30;
        p2.job = "Java开发者";
        p2.sayHello();

        // 让 p1 过生日
        p1.birthday();

        System.out.println("p1现在的年龄：" + p1.age);
        System.out.println("p2现在的年龄：" + p2.age);
    }
}