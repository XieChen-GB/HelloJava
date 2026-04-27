import java.util.ArrayList;

class Student{
    private String name;
    private int score;

    // 构造
    public Student (String name,int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){ return name; }
    public int getScore(){ return score; }
    
    public void printInfo(){
        System.out.println("姓名：" + name + " 成绩：" + score);
    }
}

public class App {
    public static void main(String[] args) {
        
        // 创建存放 Student 对象的 ArrayList
        ArrayList<Student> students = new ArrayList<>();
        
        // 添加5名学生
        students.add(new Student("学生甲", 78));
        students.add(new Student("学生乙", 81));
        students.add(new Student("学生丙", 93));
        students.add(new Student("学生丁", 55));
        students.add(new Student("学生戊", 60));


     
        Student best = students.getFirst(), wrost = students.getFirst();
        double average = 0.0;
        //输出所有学生成绩
        System.out.println("--所有学生---");
        for(Student s : students){
            s.printInfo();
            if (s.getScore() > best.getScore()) {
                best = s;
            } 
            if (s.getScore() < wrost.getScore()) {
                wrost = s;
            }

            average = average + s.getScore();
        }

        System.out.println();
        System.out.println("--成绩最高---");
        best.printInfo();

        System.out.println();
        System.out.println("--成绩最低---");
        wrost.printInfo();

        System.out.println();
        System.out.println("--平均分---");
        average = average/students.size();
        System.out.println(String.format("%.1f 分", average));

        System.out.println("--及格学生---");
        for (Student s : students) {
            if (s.getScore() >= 60) {
                s.printInfo();
            }
        }
    }
}