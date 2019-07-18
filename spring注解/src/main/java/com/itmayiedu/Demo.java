package com.itmayiedu;

/**
 * java类简单作用描述
 *
 * @Description: java类作用描述
 * @Author: 作者姓名
 * @CreateDate: 2019/7/17 22:01
 * @UpdateUser: jiaorongguo
 * @UpdateDate: 2019/7/17 22:01
 * @Version: 1.0
 * 身无彩凤双飞翼，心有灵犀一点通。
 */
//饿汉模式-线程不安全的
class Singletons{
    static private Singletons singletons =new Singletons();
    private Singletons(){
    }
    static public Singletons getSingletons(){
       /* if(singletons==null){
             synchronized (Singletons.class){
                if(singletons==null){
                    singletons = new Singletons();
                }
            }
        }*/
        return singletons;
    }
}

public class Demo {
    public static void main(String[] args) {
        Singletons singletons1 =  Singletons.getSingletons();
        Singletons singletons2 =  Singletons.getSingletons();
        System.out.println(singletons1==singletons2);
    }
}
