public class App {

    public static void main(String[] args) {
        
        // 新功能：用 switch 判断星期
        int day = 3;

        switch (day) {
            case 1:
                System.out.println("星期一");
                break;
            case 2:
                System.out.println("星期二");
                break;
            case 3:
                System.out.println("星期三");
                break;
            case 4:
                System.out.println("星期四");
                break;
            case 5:
                System.out.println("星期五");
                break;
            default:
                System.out.println("周末");
                break;
        }
    }
}