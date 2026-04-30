// 自定义异常类
class AgeException extends Exception {
    public AgeException(String message){
        super(message);
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) throws AgeException{
        if(age < 0 || age >150 ) {
            throw new AgeException("年龄不合法：" + age);
        }
        this.name = name;
        this.age = age;
    }

    public void printInfo(){
        System.out.println("姓名： " + name + " 年龄： " + age);
    }
}

public class App {

    public static void main(String[] args) {
        // 正常情况
        try {
            Person p1 = new Person("谢晨", 57);
        } catch (AgeException e) {
            System.out.println("异常：" + e.getMessage());
        }

        // 不合法的年龄
        try {
            Person p2 = new Person("田中", -10);
        } catch (AgeException e) {
            System.out.println("异常： " + e.getMessage());
        }
    }
}
