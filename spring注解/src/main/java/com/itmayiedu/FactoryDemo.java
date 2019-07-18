package com.itmayiedu;

/**
 * java类简单作用描述
 *
 * @Description: java类作用描述
 * @Author: 作者姓名
 * @CreateDate: 2019/7/17 22:18
 * @UpdateUser: jiaorongguo
 * @UpdateDate: 2019/7/17 22:18
 * @Version: 1.0
 * 身无彩凤双飞翼，心有灵犀一点通。
 */
interface Pepole{
     void work();
}
class Students implements Pepole {
    String name;

    public Students(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Students{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void work() {
        System.out.println("我们是学生");
    }
}
class Teacher implements Pepole{
    String name;

    public Teacher(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public void work() {
        System.out.println("我们是老师");
    }
}
//第二种方式实现
class  StudentseFactory{
       static public Students createStudent(){
           return new Students("学生");
       }
        }
class TeacherFactory{
    static public Teacher createTeacher(){
        return new Teacher("老师");
    }
}

//第一种方式实现
class PepoleFactory{
    static public Pepole createPepole(String name){
        Pepole pepole = null;
        switch (name){
            case "老师":
                pepole= new Teacher(name);
                break;
            case "学生":
                pepole = new Students(name);
                break;
            default:
                break;
        }
        return pepole;
    }
}
public class FactoryDemo {
    public static void main(String[] args) {
       // Pepole pepole = PepoleFactory.createPepole("老师");
        //System.out.println(pepole);
       // pepole.work();
        Pepole pepole = StudentseFactory.createStudent();
        System.out.println(pepole);
        pepole.work();
    }
}
