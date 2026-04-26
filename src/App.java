// 定义接口： 可打印的
interface Printable {
    void printInfo();
}

// 定义抽象类： 图形
abstract class Shape {
    private String color;
    
    // 构造方法
    public Shape(String color) {
        this.color = color;
    }

    // 抽象方法： 计算面积
    abstract double area();

    // 具体方法： 获取颜色
    public String getColor() {
        return color;
    }
}

// 定义子类； 圆形，实装接口可打印的
class Circle extends Shape implements Printable {
    private double radius;
    
    // 构造方法
    public Circle(String color, double radius){
        super(color);
        this.radius = radius;
    }

    // 实装父类的抽象方法
    @Override
    public double area(){
        return Math.PI * radius * radius;
    }
    
    // 实装接口的方法
    @Override
    public void printInfo() {
        System.out.println("图形: 圆形");
        System.out.println("颜色: " + getColor());
        System.out.println("半径: " + radius);
        System.out.println("面积: " + Math.round(area() * 10) / 10.0);
    }
}

// 定义子类： 长方形，实装接口可打印的
class Rectangle extends Shape implements Printable {
    private double width;
    private double height;

    // 构造方法
    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    // 实装父类的抽象方法
    @Override
    public double area(){
        return width * height;
    }

    // 实装接口的方法
    @Override
    public void printInfo() {
        System.out.println("图形：长方形");
        System.out.println("颜色: " + getColor());
        System.out.println("宽: " + width + ",高: " + height);
        System.out.println("面积: " + Math.round(area() * 10) / 10.0);
    }
}

// main
public class App {
    public static void main(String[] args) {
        Circle c = new Circle("红色" ,5);
        Rectangle r = new Rectangle("蓝色", 4, 6);
        
        c.printInfo();
        System.out.println("---");
        r.printInfo();    
    }
}