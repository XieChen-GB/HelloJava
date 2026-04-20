class Person{
    private String name;
    private int age;
    private String job;

    // 构造方法重载
    public Person (String name, int age, String job) {
        this.name = name;
        this.age = age;
        this.job = job;
    }

    public Person (String name, int age) {
        this.name = name;
        this.age = age;
        this.job = "未知";
    }

    public Person (String name) {
        this.name = name;
        this.age = 0;
        this.job = "未知";
    }

    // 普通方法重载
    public void printInfo() {
        System.out.println(name + " / " + age + "岁 / " + job);
    }
    
    public void printInfo ( String title) {
        System.out.println("【" + title + "】" + name + " / " + age + "岁");    
    }

    public void setAge (int age) {
        if (age < 0 || age > 150) {
            System.out.println("年龄不合法");
            return;
        } else {
            this.age = age;
        }    
    }

    public int getAge() {
        return age;
    }   
}

public class App {
    public static void main(String[] args) {
        Person p1 = new Person("谢晨",  57, "IT工程师");
        Person p2 = new Person("田中", 30);
        Person p3 = new Person("山田");

        p1.printInfo();
        p1.printInfo("员工信息");

        p2.printInfo();
        p3.printInfo();
    }
}