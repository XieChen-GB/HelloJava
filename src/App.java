public class App {
    public static void main(String[] args){
        // -- if 判断
        int score = 85;
        if(score >= 90){
            System.out.println("优秀");
        } else if  (score > 60){
            System.out.println("及格");
        } else {
            System.out.println("不及格");
        }
        // for 循环
        for (int i=1;i <= 5; i++){
            System.out.println("第" + i + "次循环");
        }
        
        // while 循环
        int count = 0;
        while (count < 3){
            System.out.println("count = " + count);
            count++;
        }

    }
}