import java.util.ArrayList;

class Employee {
    private String name;
    private String department;
    private String email;
    private double salary;

    public Employee(String name, String department, String email, double salary){
        this.name = name;
        this.department = department;
        this.email = email;
        this.salary = salary;
    }

    // 验证邮箱格式（必须包含@和.）
    public boolean isValidEmail(){
        return email.contains("@") && email.contains(".");
    }

    // 获取邮箱用户名（@之前的部分）
    public String getEmailUsername(){
        int atIndex = email.indexOf("@");
        return email.substring(0, atIndex);
    }

    // 用 StringBuilder 生成员工信息报告
    public String getReport(){
        StringBuilder sb = new StringBuilder();
        sb.append("姓名：").append(name).append("\n");
        sb.append("部门：").append(department).append("\n");
        sb.append("邮箱：").append(email).append("\n");
        if (!isValidEmail()){
            sb.append("(格式有误)\n");
        }
    //    sb.append("\n");
        sb.append("薪资：").append(String.format("%.1f", salary)).append("万元");
        return sb.toString();    
    }

    public String getName(){ return name;}
    public double getSalary(){ return salary;}
    public String getDepartment() { return department; }    
}  

public class App {

    public static void main(String[] args) {
        
        ArrayList< Employee > employees = new ArrayList<>();
        employees.add(new Employee("谢晨", "IT部", "xie.chen@company.com", 65.0));
        employees.add(new Employee("田中", "人事部", "tanaka@company.com", 52.0));
        employees.add(new Employee("山田", "营业部", "yamada-invalid-email", 48.0));
        employees.add(new Employee("铃木", "IT部", "suzuki@company.com", 71.0));

        // 打印所有员工报告
        System.out.println("=== 员工信息 ===");
        for (Employee e : employees){
            System.out.println(e.getReport());
            System.out.println("---");
        }

        // 找出薪资最高的员工（擂台算法复习）
        Employee highest = employees.get(0);
        for (Employee e : employees){
            if (highest.getSalary() < e.getSalary()){
                highest = e;
            }
        }
        System.out.println("薪资最高：" + highest.getName()
                + "（" + String.format("%.1f", highest.getSalary()) + "万元）");

        // 统计 IT部 的员工数量
        int itCount = 0;
        for( Employee e : employees){
            if(e.getDepartment().equals("IT部")){
                itCount ++;
            }
        }
        System.out.println("IT部人数：" + itCount);

    }
}
    