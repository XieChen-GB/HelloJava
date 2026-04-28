import java.util.HashMap;

class Student {
    private String name;
    private int score;

    // 构造method
    public Student (String name,int score){
        this.name = name;
        this.score = score;
    }

    // method
    public int getScore(){ return score; }

    public void printInfo(){
        System.out.println("姓名：" + name + " 成绩：" + score);
    }
} 

public class App {
    public static void main(String[] args) {
        // Key = 学号，Value = Student 对象
        HashMap<String,Student>  map = new HashMap<>();

        map.put("S001", new Student("谢晨", 85));
        map.put("S002", new Student("田中", 92));
        map.put("S003", new Student("山田", 67));

        // 用学号查找学生
        System.out.println("---查找S002---");
        map.get("S002").printInfo();

        // 遍历所有学生
        System.out.println("---所有学生---");
        for (String id : map.keySet()){
            System.out.print("学号：" + id + " ");
            map.get(id).printInfo();
        }

        // 判断学号 S004 是否存在
        if (map.containsKey("S004")) {
            map.get("S004").printInfo();
        } else {
            System.out.println("学号 S004 不存在！");
        }

        // 更新 S001 的成绩
        map.put("S001", new Student("谢晨", 99));
        System.out.println("--- 更新后 S001 ---");
        map.get("S001").printInfo();
    }
}