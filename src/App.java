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

        // 添加学生 
        students.add(new Student("谢晨", 85 ));
        students.add(new Student("田中", 92));
        students.add(new Student("山田", 67));

        // 遍历所有学生
        System.out.println("---所有学生---");
        for (Student s : students){
            s.printInfo();
        }

        // 找出成绩最高的学生
        Student best = students.getFirst();
        for ( Student s : students ){
            if (s.getScore() > best.getScore()){
                best = s;
            }
        }
        System.out.println("---成绩最高---");
        best.printInfo();
    }
}