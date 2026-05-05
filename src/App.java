// 练习3: 学生选课系统

import java.util.ArrayList;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
// 自定义异常
class CourseFullException extends Exception{    // 课程已满时抛出

   CourseFullException(String message){
    super(message);
   } 

}

class AlreadyEnrolledException extends Exception{   // 学生已选该课时抛出

    AlreadyEnrolledException(String message){
        super(message);
    }    

}

// class 课程
class Course{

    private String courseId;
    private String courseName;
    private int maxStudents;
    private ArrayList<String> enrolledStudents = new ArrayList<>(); // 选课学生姓名

    // 构造方法
    Course(String courseId, String courseName, int maxStudents){

        this.courseId = courseId;
        this.courseName = courseName;
        this.maxStudents = maxStudents;

    }

    // 方法
    public String getCourseId() { return courseId; }
    public String getCourseName(){ return courseName; }
    public int getEnrolledCount(){ return enrolledStudents.size(); }
    
    // 方法： 选课，已满抛出 CourseFullException，已选抛出AlreadyEnrolledException
    public void enroll(String studentName) throws CourseFullException, AlreadyEnrolledException{

        if (getEnrolledCount() == maxStudents){
            throw new CourseFullException("异常: " + courseName + " 课程已满! ");
        }
        for(int i = 0; i < enrolledStudents.size(); i++){
            if(enrolledStudents.get(i).equals(studentName)) {
                throw new AlreadyEnrolledException("异常: " + studentName + " 已选修 " + courseName);
            }  
        }     
        enrolledStudents.add(studentName);
    }

    @Override
    public String toString() {
        
        return "[" + getCourseId() + "] "  + getCourseName() + " 最大人数： " 
            + maxStudents + " 已选： " + getEnrolledCount() + "人";

    }

}

// class: 学生
class Student{
    private String studentId;
    private String name;
    private ArrayList<String> enrolledCourses = new ArrayList<>();  // 已选课程名称 

    // 构造方法
    Student( String studentId, String name){
        this.studentId = studentId;
        this.name = name;
    }

    public String getStudentId(){ return studentId; }
    public String getName(){ return name;}

    public void addCourse(String courseName){ enrolledCourses.add(courseName); }    // 添加已选课程

    public void printCourses(){     // 打印已选课程
        System.out.print(name + "(" + studentId + ") " + "已选课程：");
        if (enrolledCourses.isEmpty()){
            System.out.println("无");
        }  else { 
            for ( int i = 0; i < enrolledCourses.size(); i++){
                if( i == enrolledCourses.size() -1){    // 最后一个
                    System.out.println(enrolledCourses.get(i));
                } else {
                    System.out.print(enrolledCourses.get(i) + "、");
                }
            }
        }
    }

    public String getCourseInfo(){ // 返回已选课程
        StringBuilder info = new StringBuilder();
        info.append(name + "(" + studentId + ") " + "已选课程：");
        if(enrolledCourses.isEmpty()){
            info.append("无");
        } else {
            for(int i = 0; i < enrolledCourses.size(); i++){
                if (i == enrolledCourses.size() -1){
                    info.append(enrolledCourses.get(i));
                } else{
                    info.append(enrolledCourses.get(i) + "、");
                }
            }
        }

        return info.toString();
    }
}





public class App {

    // 静态方法： 选课
    static void enrollCourse(HashMap<String,Course> hashmapCourse,
                             HashMap<String,Student> hasmapStudent,
                             String courseId,
                             String studenId)                            
    {
        try {
            Course course = hashmapCourse.get(courseId);
            Student student = hasmapStudent.get(studenId);
            
            if (course == null){
                System.out.println("课程不存在");
                return;
            } 
            if(student == null){
               System.out.println("学生不存在");
               return; 
            }

            course.enroll(student.getName());
            student.addCourse(course.getCourseName());
            System.out.println(student.getName() + " 成功选修 " + course.getCourseName());

        } catch (CourseFullException e) {
            System.out.println(e.getMessage());
        }
          catch (AlreadyEnrolledException e) {
            System.out.println(e.getMessage());
        }


    }

    public static void main(String[] args) {
        
        HashMap<String,Course> hasmapCourse = new HashMap<>();
        HashMap<String,Student> hasmapStudent = new HashMap<>();

        // 添加课程
        hasmapCourse.put("C001", new Course("C001", "Java编程", 2));
        hasmapCourse.put("C002", new Course("C002", "数据库基础", 3));
        hasmapCourse.put("C003", new Course("C003", "网络安全", 2));

        // 添加学生
        hasmapStudent.put("S001", new Student("S001", "谢晨"));
        hasmapStudent.put("S002", new Student("S002", "田中"));
        hasmapStudent.put("S003", new Student("S003", "山田"));
        hasmapStudent.put("S004", new Student("S004", "铃木"));

        // 打印所有课程
        System.out.println("--- 所有课程 ---");
        for(String courseId : hasmapCourse.keySet()){

            System.out.println(hasmapCourse.get(courseId).toString());
        }

        // 选课
        System.out.println("--- 选课 ---");
        enrollCourse(hasmapCourse, hasmapStudent, "C001", "S001");
        enrollCourse(hasmapCourse, hasmapStudent, "C001", "S002");
        enrollCourse(hasmapCourse, hasmapStudent, "C001", "S003");
        enrollCourse(hasmapCourse, hasmapStudent, "C002", "S001");
        enrollCourse(hasmapCourse, hasmapStudent, "C002", "S001");
    
        // 打印所有课程
        System.out.println("--- 课程信息 ---");
        for(String courseId : hasmapCourse.keySet()){

            System.out.println(hasmapCourse.get(courseId).toString());
        }

       // 学生选课情况
        System.out.println("--- 学生选课情况 ---");
        for(String studentId : hasmapStudent.keySet()){
            hasmapStudent.get(studentId).printCourses();
        }

        // 所有信息写入文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("enrollment.txt"))){
            // 选课信息
            writer.write("--- 课程信息 ---");
            writer.newLine();
            for(String courseId : hasmapCourse.keySet()){
            writer.write(hasmapCourse.get(courseId).toString());
            writer.newLine();
           } 

           // 学生信息
            writer.write("--- 学生选课情况 ---");
            writer.newLine();           
           for(String studentId : hasmapStudent.keySet()){
            writer.write(hasmapStudent.get(studentId).getCourseInfo());
            writer.newLine();
           }

           System.out.println("--- 写入文件成功 ---");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

