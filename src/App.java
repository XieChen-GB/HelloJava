// 练习：简单的图书管理系统

import java.util.HashMap;

class Book {
    String isbn;
    private String title;
    private String author;
    private double price;

    // 构造方法
    public Book (String isbn,String title,String author,double price){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printInfo(){
        System.out.println("书号： " + isbn +", 书名： " + title + "，作者： " + author + ", 价格： " + String.format("%.2f", price));
    }

    public double getPrice() {return price;}
}

public class App {

    public static void main(String[] args) {
        // 定义一个存放图书的HashMap
        HashMap<String,Book> booksHashMap = new HashMap<>();
        
        // 添加5本书
        booksHashMap.put("9787544270878", new Book("9787544270878","解忧杂货店", "东野圭吾", 39.5));
        booksHashMap.put("9787208061644", new Book("9787208061644","追风筝的人 ", "德·胡赛尼", 25.00));
        booksHashMap.put("9787108002884", new Book("9787108002884","与社会秩", "伯纳德.巴伯", 13.8));
        booksHashMap.put("9787521718607", new Book("9787521718607","货币 银行与黄金启蒙", "彼得·伯恩斯", 149.00));
        booksHashMap.put("9787301094013", new Book("9787301094013","力学 (物理类)", "舒幼生", 128));

        // 使用isbn查找图书
        System.out.println("---查找图书---");
        if (booksHashMap.containsKey("9787208061644")) {
            booksHashMap.get("9787208061644").printInfo();
        } else {
            System.out.println("不存在书号 9787208061644 " );
        }

        // 打印所有图书并找出价格最高的图书
        System.out.println("---打印所有图书---");
        Book mostExp = new Book("", "", "", 0);
        for(String id : booksHashMap.keySet()) {
            booksHashMap.get(id).printInfo();
            if (mostExp.getPrice() < booksHashMap.get(id).getPrice()){
                mostExp = booksHashMap.get(id);
            }
        }
        System.out.println("---价格最高的图书---");
        mostExp.printInfo();

        // 打印价格低于50元的图书
        System.out.println("---打印价格低于50元的图书---");
        for(String id : booksHashMap.keySet()){
            if(booksHashMap.get(id).getPrice()< 50 ){
                booksHashMap.get(id).printInfo();
            }
        }

        // 删除某本图书
        System.out.println("---删除某本书---");
        String delId = "9787108002884";
        if (booksHashMap.containsKey("9787108002884") ){
            booksHashMap.remove(delId);
        }
        System.out.println("删除后图书数量： " + booksHashMap.size());        
    }
}