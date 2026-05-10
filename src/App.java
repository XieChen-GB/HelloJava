import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// 继承 Exception，当优先级不是 1/2/3 时抛出。
class InvalidPriorityException extends Exception{
    InvalidPriorityException(String message){
        super(message);
    }
}   // end InvalidPriorityException
class Task {
    private String title;    // 任务标题
    private int priority;   // 优先级，只能是1，2，3
    private boolean completed;  // 是否完成，默认fales

    // 构造方法：接收 title 和 priority，completed 默认 false
    Task (String title, int priority) throws InvalidPriorityException{
        if(priority < 1 || priority > 3){
            throw new InvalidPriorityException("优先级设置错误");
        }
        this.priority = priority;
        this.title = title;
        this.completed = false;
    }
    // 标记完成状态
    public void setCompleted (boolean status){
        completed = status;
    }
    // 设置优先级，不是 1/2/3 时抛出自定义异常
    public void setPriority(int p) throws InvalidPriorityException{
        if (p < 1 || p > 3){
            throw new InvalidPriorityException("优先级设置错误");
        }
        this.priority = p;
    }
    // getter
    public String getTitle(){ return title; }
    public int getPriority() { return priority; }
    public boolean isCompleted(){ return completed; }
    // 打印任务信息
    public void printInfo(){
        System.out.printf("%-10s 优先级：%d 是否完成：%b%n", title, priority, completed);
    }
} // end Task

class TaskManager{
    private ArrayList<Task> tasks;
    // 构造方法 
    TaskManager(){
        tasks = new ArrayList<>();
    }
    // 添加任务
    public void addTask(Task task){
        tasks.add(task);
    }
    // 打印所有任务
    public void printAll(){
        for( Task t : tasks){
            t.printInfo();
        }
    }
    // 只打印指定优先级的任务
    public void printByPriority(int priority){
        for ( Task t : tasks){
            if(t.getPriority() == priority){
                t.printInfo();
            }
        }
    }
    // 把所有任务写入文件，用 try-with-resources，写入时Task的3个变量值用","分割
    public void saveToFile(String filename){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for ( Task t : tasks){
                writer.write(String.format("%s,%d,%b%n", t.getTitle(), t.getPriority(), t.isCompleted()));
            }
            System.out.println(filename + "写入成功");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    // 文件读取任务并打印，用 try-with-resources，读取时用","切割成数组
    public void loadFromFile(String filename){
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;            
            while((line=reader.readLine()) != null){
                String[] parts = line.split(",");
                String title = parts[0];
                int priority = Integer.parseInt(parts[1]); // 将字符串类型转换成整型
                boolean completed = Boolean.parseBoolean(parts[2]); // 将字符串类型转换成boolen
                System.out.printf("%-10s 优先级：%d 是否完成：%b%n", title, priority, completed);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    // 标记任务为完成
    public void markCompleted(String title){
        for (Task t: tasks){
            if(t.getTitle().equals(title)){
                t.setCompleted(true);
                break;
            }
        }
    }
}   // end TaskManager

public class App {
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        try {
            tm.addTask(new Task("完成练习6", 1));
            tm.addTask(new Task("复习ArrayList", 2));
            tm.addTask(new Task("学习Spring Boot", 1));
            tm.addTask(new Task("整理学习笔记", 3));
            tm.addTask(new Task("提交GitHub", 2));
            tm.addTask(new Task("复习异常处理", 1));
            tm.addTask(new Task("配置开发环境", 3));
            tm.addTask(new Task("阅读Java文档", 2));
        } catch (InvalidPriorityException e) {
            System.out.println(e.getMessage());
        }

        // 打印搜有任务
        System.out.println("--- 打印所有任务 ---");
        tm.printAll();

        // 标记任务完成
        System.out.println("--- 把\"完成练习6\"标记为已完成 ---");
        tm.markCompleted("完成练习6");

        // 打印优先级为1的任务
        System.out.println("--- 打印优先级为1的任务 ---");
        tm.printByPriority(1);

        // 测试非法优先级（传入5），捕获异常并打印提示
        System.out.println("测试非法优先级（传入5）");
        try {
            tm.addTask(new Task("文件IO练习", 5));
        } catch (InvalidPriorityException e) {
            System.out.println(e.getMessage());
        }
        
        // 保存文件 tasks.txt
        System.out.println("------ 保存文件 ------");
        System.out.println("保存文件 tasks.txt");
        tm.saveToFile("tasks.txt");

        // 从文件读取并打印
        System.out.println("------ 从文件读取并打印 ------");
        tm.loadFromFile("tasks.txt");
    } // end main
}   // end App