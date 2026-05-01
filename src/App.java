import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class App {

    public static void main(String[] args) {
        
        // try-with-resources : 自动关闭资源
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("output2.txt", true))) {
            writer.write("第一行：自动关闭测试");
            writer.newLine();
            writer.write("第二行：不要手动close()");
            writer.newLine();
            writer.write("更安全");
            
            System.out.print("写入成功");
            
        } catch (IOException e) {
            System.out.println("写入失败：" + e.getMessage());
        }
    }
}