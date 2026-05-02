// 综合练习：员工管理系统

import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


// 定义抽象类
abstract class Employee {
    String id;      // 员工号
    String name;    // 姓名
    double salary;  // 薪资 

    // 构造方法
    Employee(String id, String name, double salary){
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // 抽象方法
    abstract String getRole(); // 返回职位名称
    abstract void printInfo();
    abstract String getInfo();

    // 普通方法
    public double getSalary(){ return salary; }  // 获取薪资    
}

// 定义子类
class FullTimeEmployee  extends Employee {
    
    // 构造方法: 调用父类构造方法
    FullTimeEmployee(String id, String name, double salary){
        super(id, name, salary);
    }
    
    // 实装抽象方法： 返回 "全职员工"
    @Override 
    public String getRole() {
        return("全职员工");
    }

    // 实装抽象方法： 返回全部信息
    @Override
    public String getInfo(){
        return "员工号： " + id + ", 姓名： " +  name + ", 薪资： " + String.format("%.2f",salary);
    }
    
    // 实装接口： 打印全部信息
    @Override 
    public void printInfo() {
        System.out.println("员工号： " + id + ", 姓名： " +  name + ", 薪资： " + String.format("%.2f",salary));
    }    
}

class PartTimeEmployee extends Employee{
    int hourPerWeek;

    // 构造方法
    PartTimeEmployee(String id, String name, double salary, int hourPerWeek){
        super(id,name,salary);
        this.hourPerWeek = hourPerWeek;        
    }
    
    // 实装抽象方法； 返回“兼职员工”
    @Override   
    public String getRole(){
        return("兼职员工");    
    }

    // 实装抽象方法： 返回全部信息
    @Override
    public String getInfo(){
        return "员工号： " + id + ", 姓名： " +  name + ", 薪资： " + String.format("%.2f",salary) + ", 每周工时： " + hourPerWeek;
    }

    // 实装接口： 打印全部信息
    @Override 
    public void printInfo(){
        System.out.println("员工号： " + id + ", 姓名： " +  name + ", 薪资： " + String.format("%.2f",salary) + ", 每周工时： " + hourPerWeek);    
    }
}

public class App {

    public static void main(String[] args) {
        HashMap<String, Employee> hsmapEmp = new HashMap<>();

        // 添加3名全职员工和2名兼职员工
        hsmapEmp.put("E001", new FullTimeEmployee("E001", "谢晨", 8000));
        hsmapEmp.put("E002", new FullTimeEmployee("E002", "田中", 12000));
        hsmapEmp.put("E003", new FullTimeEmployee("E003", "山田", 4500));

        hsmapEmp.put("P001", new PartTimeEmployee("P001", "铃木", 3000, 20));
        hsmapEmp.put("P002", new PartTimeEmployee("P002", "佐藤", 4800, 30));

        // 打印所有员工信息
        System.out.println("--- 所有员工 ---");
        String mostPaiedId = "";
        for(String id : hsmapEmp.keySet()){

            hsmapEmp.get(id).printInfo();        
            if(mostPaiedId.equals("")){
                mostPaiedId = id;
            } else {
                if(hsmapEmp.get(id).getSalary() > hsmapEmp.get(mostPaiedId).getSalary()){
                    mostPaiedId = id;
                }
            }
        }

        // 薪资最高
        System.out.println("--- 薪资最高 ---");
        hsmapEmp.get(mostPaiedId).printInfo();

        // 低于5000
        System.out.println("--- 薪资低于5000 ---");
        for(String id : hsmapEmp.keySet()){
            if (hsmapEmp.get(id).getSalary() < 5000) {
                hsmapEmp.get(id).printInfo();
            }
        }

        // 把所有员工信息写入 employees.txt 文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employees.txt", false))) {
            for (String id : hsmapEmp.keySet()){
                writer.write(hsmapEmp.get(id).getInfo());
                writer.newLine();
            }
            System.out.println("--- 写入文件成功 ---");
        } catch (IOException e) {
            System.out.println("写入文件异常：" + e.getMessage());
        }
    }
}


