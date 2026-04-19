class Person {
    // 成员变量改为 private，外部不能直接访问
    private String name;
    private  int age;
    private String job;

    // 构造方法
    Person (String name, int age, String job){
        this.name = name;
        this.age = age;
        this.job = job;

    }

    // 提供公共的 getter 和 setter 方法来访问和修改成员变量
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public void setAge (int age) {
        if (age < 0 || age > 150) {
            System.out.println("年龄不合法");
        } else {
            this.age = age;
        }
    }

    public void sayHello() {
        System.out.println("你好！我叫" + name + ", 今年" + age + "岁，我的工作是 " + job);
    }
}

public class App {
    public static void main(String[] args) {
        Person P1 = new Person("谢晨", 57, "IT工程师");

        // 用 setter 修改年龄
        P1.setAge(58);
        System.out.println("修改后的年龄: " + P1.getAge());

        // 尝试设置不合法的年龄
        P1.setAge(-10);
        System.out.println("年龄仍然是: " + P1.getAge());
    }
}