// 定义一个“人”的类
class Person {
    // 定义变量（属性） --描述这个人有什么
    String name;  // 姓名
    int age ;     // 年龄
    String job;   // 职业

    // 方法1：自我介绍
    void sayHello() {
        System.out.println("你好！我叫" + name + " 今年" + age + "岁，职业是" + job);
    }

    // 方法2：过生日，年龄加1
    void birthday() {
        age++;  // 年龄加1
        System.out.println("过生日了！现在我" + age + "岁了！");
    }

    // 方法3：判断是否退休（日本退休年龄65岁）
    void chekRetirement(){
        if (age >= 65) {
            System.out.println(name + "已经退休了！");
        } else {
            int yeares = 65-age;
            System.out.println(name + "还有" + yeares + "年退休。");
        }
    }

    // 方法4：工作
    void work() {
        System.out.println(name + "正在努力工作");
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

        p1.chekRetirement();
        p1.work();
        p2.chekRetirement();
        p2.work();
    }
}