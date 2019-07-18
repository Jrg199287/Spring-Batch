package com.jrg.demo2;

/**
 * java类简单作用描述
 *
 * @Description: java类作用描述
 * @Author: 作者姓名
 * @CreateDate: 2019/7/8 23:00
 * @UpdateUser: jiaorongguo
 * @UpdateDate: 2019/7/8 23:00
 * @Version: 1.0
 * 身无彩凤双飞翼，心有灵犀一点通。
 */
class ThreadVolatitleDemo extends Thread{
        private volatile   boolean flag = true;
        public void run(){
            System.out.println("执行开始");
            while (flag){
                //stopThread(flag);
            }
            System.out.println("执行结束");
        }

        public  void stopThread(boolean flag){
            this.flag = flag;
        }
        }
public class ThreadVolatitle {
    public static void main(String[] args) throws InterruptedException {
        ThreadVolatitleDemo tt = new ThreadVolatitleDemo();
        tt.start();
        Thread.sleep(3000);
        tt.stopThread(false);
        System.out.println("已经修改为false");
        Thread.sleep(1000);
        System.out.println("是否执行");
    }


}
