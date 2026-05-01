import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class App {

    public static void main(String[] args) {
        
        // 追加写入
         
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", true)); // 追加模式
            writer.newLine();
            writer.write("第四行：这是追加的内容");
            writer.close();
            System.out.println("追加成功！");
        } catch (IOException e) {
            System.out.println("追加失败：" + e.getMessage());
        }

    }
}