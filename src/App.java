// 练习7：常用语法和工具方法
// 本次内容： 三元运算符、static 关键字、Math.random()、isEmpty() / isBlank()
// 随机点名系统

import java.util.ArrayList;
class Student{
    private String name;
    private int score;
    private boolean present; // 是否出勤

    // 构造方法
    Student(String name, int score){
        this.name = name;
        this.score = score;
        present = false;
    }

    public void setPresent (boolean stauts){
        present = stauts;
    }

    // getter
    public String getName(){ return name; }
    public int getScore(){ return score; }
    public boolean getPresent(){ return present;}

    // 打印学生信息
    public void printInfo(){
        System.out.printf("姓名: %-10s , 成绩: %5d , 出勤状况: %2s%n",
         name, score, present ? "出勤" : "缺勤");
    }
}

class Classroom {
    private ArrayList<Student> students;
    static int totalClasses = 0; //  上课总次数

    // 构造方法
    Classroom (){
        students = new ArrayList<>();
    }

    // 添加前用 isBlank() 验证姓名不能为空，为空时打印提示
    public void addStudent(Student newStudent){
        if(newStudent.getName().isBlank()){         // isBlank的用法 “”， “”  “”
            System.out.println("姓名不能为空");
            return;
        }
        students.add(newStudent);
    }

    // 随机点名: 用 Math.random() 随机选一个学生，打印"被点到：xxx"
    public void randomPick(){
        int numberOfStudents = students.size();
        int pickedNumber = (int)(Math.random() * numberOfStudents);
        System.out.println("被点到: " + students.get(pickedNumber).getName());
    }

    // 上课出席: 把所有学生的 present 设为 true，同时 totalClasses++
    public void takeAttendance(){
        for( Student s : students){
            s.setPresent(true);
        }
        totalClasses++;
    }

    // 打印所有学生信息
    public void printAll(){
        for ( Student s : students){
            s.printInfo();
        }
    }

    // 打印上课总次数
    static void printTotalClasses(){
        System.out.println("上课总次数: " + totalClasses);
    }
}

public class App {

    public static void main(String[] args) {
        
        // 添加5名学生
        Classroom c1 = new Classroom();
        c1.addStudent(new Student("张伟", 85));
        c1.addStudent(new Student("李娜", 92));
        c1.addStudent(new Student("王芳", 78));
        c1.addStudent(new Student("赵明", 65));
        c1.addStudent(new Student("陈静", 88));
        
        // 验证 isBlank
        c1.addStudent(new Student("", 70));

        // 打印所有学生
        c1.printAll();

        // 随机点名3次
        for(int i =1;i<4;i++){
            System.out.println("第" + i + "次点名");
            c1.randomPick();
        }

        // 标记出勤
        c1.takeAttendance();

        // 再次打印所有学生
        c1.printAll();    
        
        // 打印上课总次数
        Classroom.printTotalClasses();
    }
}