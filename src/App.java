public class App {
    public static void main(String[] args){
        // -----1. 声明变量
        String name = "谢晨";
        int age = 25;
        boolean hasLicense = false;

        // -----2. 输出基本信息
        System.out.println("==========================");
        System.out.println("姓名: " + name);
        System.out.println("年龄: " + age);
        System.out.println("==========================");


        // -----3. 判断是否成年
        if (age >= 18) {
            System.out.println (name + "是成年人");
        } else if (age >= 13) {
            System.out.println(name + "是青少年");
        } else {
            System.out.println(name + "是儿童");
        }
        
        // -----4. 判断是否可以开车
        if (age >= 18 && hasLicense) {
            System.out.println ("可以开车");
        } else {
            System.out.println("不能开车");
        }

        // -----5. 用 for 循环倒计时
        System.out.println  ("-------倒计时-------");
        for (int i= 5; i >=1; i--){
            System.out.println(i + "...");
        }
        System.out.println("出发!");
        }
     }
