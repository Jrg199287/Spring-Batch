package com.jrg.demo6;

/**
 * java类简单作用描述
 *
 * @Description: java类作用描述
 * @Author: 作者姓名
 * @CreateDate: 2019/7/16 10:01
 * @UpdateUser: jiaorongguo
 * @UpdateDate: 2019/7/16 10:01
 * @Version: 1.0
 * 身无彩凤双飞翼，心有灵犀一点通。
 */
public class test66 implements Runnable {
    static int sum;
    private SpinLock lock;

    public test66(SpinLock lock) {
        this.lock = lock;
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        SpinLock lock = new SpinLock();
        for (int i = 0; i < 100; i++) {
            test66 test = new test66(lock);
            Thread t = new Thread(test);
            t.start();
        }

        Thread.currentThread().sleep(1000);
        System.out.println(sum);
    }

    @Override
    public void run() {
        this.lock.lock();
        this.lock.lock();
        sum++;
        this.lock.unlock();
        this.lock.unlock();
    }

}
