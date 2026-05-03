// 练习1：图书馆借阅系统
import java.util.ArrayList;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


// 自定义异常： 当已经是借出状态时，抛出自定义异常
class ItemNotAvailableException extends Exception{
    // 构造方法
    public ItemNotAvailableException(String message){
        super(message);
    }
}
// 定义图书馆藏抽象类
abstract class LibraryItem{
    // 成员变量
    private String itemID;  // 编号
    private String title;   // 标题
    private boolean available = true;

    // 构造方法
    LibraryItem(String itemID, String title){
        this.itemID = itemID;
        this.title = title;
    }

    // 抽象方法： 返回物品类型
    abstract String getType();

    // 普通方法
    public String getItemId(){ return itemID; }
    
    public String getTitle(){ return title; }

    public boolean isAvailable () { return available; }
    
    // 当已经是借出状态时，抛出自定义异常
    public void borrowItem() throws ItemNotAvailableException {
        if(!available){
            throw new ItemNotAvailableException(getTitle() + "当前不可借！");
        }
            available = false;
            System.out.println(title + "已借出");
    }
    
    public void returnItem(){
        available = true;
        System.out.println(title + "已归还");
    }
}
// 定义图书子类
class Book extends LibraryItem{
    private String author;

    // 构造方法
    Book(String itemId, String title, String author){
        super(itemId, title);
        this.author = author;
    }

    // 实装抽象方法
    @Override
    public String getType(){ return "图书";}

    @Override
    public String toString(){
        return "[图书] 编号： " + getItemId() + " 标题： " + getTitle() + " 作者： " + author + " 状态： " + 
            (isAvailable() ? "可借" : "已借出");
    }
}

// 定义DVD子类
class DVD extends LibraryItem{
    private int duration;

    // 构造方法
    DVD(String itemId, String title, int duration){
        super(itemId, title);
        this.duration = duration;        
    }

    // 实装抽象方法
    @Override
    public String getType(){
        return "DVD";
    }

    @Override
    public String toString(){
        return "[DVD] 编号： " + getItemId() + " 标题： " + getTitle() + " 时长： " +  duration + "分钟 状态： " + 
            (isAvailable() ? "可借" : "已借出");

    }
}

// main
public class App {

    public static void main(String[] args) {
            
        // 定义存放馆藏的动态数组
        ArrayList<LibraryItem> arrItem = new ArrayList<>();

        // 添加3本图书
        arrItem.add(new Book("B001", "解忧杂货店", "东野圭吾"));
        arrItem.add(new Book("B002", "追风筝的人", "卡勒德·胡赛尼"));
        arrItem.add(new Book("B003", "三体", "刘慈欣"));

        // 添加3张DVD
        arrItem.add(new DVD("D001", "千与千寻", 125));
        arrItem.add(new DVD("D002", "肖申克的救赎", 142));

        // 输出所有馆藏信息
        System.out.println("--- 所有馆藏 ---");
        for (LibraryItem item : arrItem){
            System.out.println(item.toString());
        }

        // 借出某本书（正常情况）
        System.out.println("--- 借出 ---");
        LibraryItem found = null;
        for (LibraryItem item : arrItem){
            if(item.getItemId().equals("D002")){
                found = item;
                break;
            }
        }
        if (found != null){
            try {
                found.borrowItem();
            } catch (ItemNotAvailableException e) {
                System.out.println(e.getMessage());
            }
        }

        // 再次借出同一本书（触发异常）
        System.out.println("--- 再次借出（异常） ---");
        if (found != null){
            try {
                found.borrowItem();
            } catch (ItemNotAvailableException e) {
                System.out.println(e.getMessage());
            }
        }

        // 归还这本书
        System.out.println("--- 归还 ---");
        if(found != null){
            found.returnItem();
        }

        // 写入libray.txt
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("libray.txt"))) {
            for(LibraryItem item : arrItem){
                writer.write(item.toString());
                writer.newLine();
            }
            System.out.println("--- 写入文件成功 ---");
        } catch (IOException e) {
            System.out.println("写入文件异常： " + e.getMessage());
        }
    }
}