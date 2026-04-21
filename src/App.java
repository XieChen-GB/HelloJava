class Student {
    private String name;
    private int age;
    private int grade;
    private double score;

    // Constructor
    public Student (String name,int age, int grade, double score) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.score = score;
    }

    // method to display student information
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Grade: " + grade);
        System.out.println("Score: " + score);
    }

    // method to check if the student passed
    public void isPass() {
        if (score >= 60) {
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }
    }

    // method to set Score
    public void setScore(double score) {
        if (score < 0 || score > 100) {
            System.out.println("分数必须在0到100之间");
        } else {
            this.score = score;
        }
    }
    
    // method to get Score
    public double getScore() {
        return score;
    }
}

public class App {
    public static void main(String[] args) {
        // 创建两个学生对象
        Student s1= new Student("谢晨",57,3,85.5);
        Student s2= new Student("田中",20,1,55.0);

        // 打印信息
        s1.printInfo();
        s1.isPass();
        System.out.println("-------------------");
        s2.printInfo();
        s2.isPass();

        // 测试 setScore 验证
        System.out.println("-------------------");
        s2.setScore(120);    // 不合法
        s2.setScore(75);     // 合法
        System.out.println("修改后的成绩: " + s2.getScore());
    }
}