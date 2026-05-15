// 综合练习8 书单管理系统

import java.util.ArrayList;
import java.util.Collections;

class Book{
    private String title;
    private String author;
    private boolean read = false;

    // 构造方法
    Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public void setRead(boolean status){
        read = status;
    }

    public String getTitle(){ return title; }
    public String getAuthor(){ return author; }
    public boolean getRead(){ return read; }

    public boolean isRead(){
        return read ;
    }
    public void printInfo(){
        System.out.println(getTitle() + ", " + getAuthor() + ", " + (read ? "已读" : "未读"));
    }
}

class BookList{
    private ArrayList<Book> books;
    
    // 构造方法
    public BookList(){
        books = new ArrayList<>();
    }

    public void addBook(Book b){
        books.add(b);
    }

    public Book getBook(String bookTitle){
        for (Book b : books){
            if (b.getTitle().equals(bookTitle)){
                return b;
            } 
        }
        return null;
    }

    // 打印所有书
    public void printAll(){
        for ( Book b : books){
            b.printInfo();
        }
    }

    // 把所有书名拼成一行打印
    public void printTitles(){
        ArrayList<String> titles = new ArrayList<>();
        for(Book b : books){
            titles.add(b.getTitle());
        }

        String s = String.join(",", titles);
        System.out.println(s);
   }

   // 反转列表
   public void reverseOrder(){
    Collections.reverse(books);
   }

   // 随机打乱
   public void shuffle(){
    Collections.shuffle(books);
   }

   // 删除所有已读的书
   public void removeRead(){
    books.removeIf(book -> book.isRead());
   }
}

public class App {

    public static void main(String[] args) {
        BookList books = new BookList();
        books.addBook(new Book("三体", "刘慈欣"));
        books.addBook(new Book("百年孤独", "加西亚·马尔克斯"));
        books.addBook(new Book("活着", "余华"));
        books.addBook(new Book("挪威的森林", "村上春树"));
        books.addBook(new Book("红楼梦", "曹雪芹"));
        books.addBook(new Book("小王子", "圣埃克苏佩里"));

        // 打印所有书
        books.printAll();
        
        // 打印所有书名（一行显示）
        books.printTitles();

        // 把前两本标记为已读
        books.getBook("挪威的森林").setRead(true);
        books.getBook("三体").setRead(true);

        // 删除已读的书，再打印剩余书单
        books.removeRead();
        books.printTitles();

        // 打乱顺序后打印
        books.shuffle();
        books.printTitles();

        // 反转后打印
        books.reverseOrder();
        books.printTitles();
    }

}