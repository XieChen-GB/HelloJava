import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Product {
    private String name;
    private String category;
    private double price;
    private int stock;

    // 构造方法
    public Product (String name, String category, double price, int stock){
        this.name = name;
        this.category = category;
        this.price = price;
        this.stock = stock;
    }

    public String getName(){ return name; }
    public String getCategory(){ return category; }
    public double getPrice (){ return price; }
    public int getStock(){ return stock; }

    public void printInfo(){
        System.out.println(String.format("%-10s %-6s %6.1f 库存：%d" ,name, category,price,stock));
    }
}   // end of Product

public class App {

    public static void main(String[] args) {
        ArrayList<Product> arryaProducts = new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();

        arryaProducts.add(new Product("笔记本电脑", "电器", 8500.0, 10));
        arryaProducts.add(new Product("机械键盘", "电器", 650.0, 25));
        arryaProducts.add(new Product("Java教材", "书籍", 89.0, 50));
        arryaProducts.add(new Product("显示器", "电器", 2100.0, 8));
        arryaProducts.add(new Product("算法导论", "书籍", 128.0, 30));
        arryaProducts.add(new Product("鼠标", "电器", 320.0, 40));

        // 打印所有商品
        System.out.println("--- 所有商品 ---");
        for(Product product : arryaProducts){
            product.printInfo();
        }

        // 升序排序
        Collections.sort(arryaProducts,(a,b) -> Double.compare(a.getPrice(), b.getPrice()));
        System.out.println("\n=== 按价格排序（低→高）===");
        for(Product product : arryaProducts){
            product.printInfo();
        }  
        
        // 3. 用 Math 计算最高价和最低价
        double maxPrice = arryaProducts.getLast().getPrice();
        double minPrice = arryaProducts.getFirst().getPrice();
        System.out.println("\n最高价：" + maxPrice + "元");
        System.out.println("最低价：" + minPrice + "元");
        System.out.println("差价：" + Math.abs(maxPrice - minPrice) + "元" );

        // 4. 用 HashMap 统计各分类的商品数量，用 Map.Entry 遍历输出
        for (Product p : arryaProducts){
            String  cat = p.getCategory();
            count.put(cat, count.getOrDefault(cat, 0) + 1);
        }
        
        System.out.println("\n--- 各分类商品数量 ---");
        for (Map.Entry<String, Integer> entry : count.entrySet()){
            System.out.println(entry.getKey() + ": " +  entry.getValue());
        }
    }
}