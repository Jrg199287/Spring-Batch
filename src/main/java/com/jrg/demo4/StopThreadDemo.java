package com.jrg.demo4;
class StopThread extends Thread {
    public volatile boolean flag = true;
    @Override
    public synchronized void run() {
        System.out.println("子线程开始....");
        while (flag) {
            try {
                wait();
            } catch (InterruptedException e) {
                stopThread();
            }
        }
        System.out.println("子线程结束....");
    }
    public void stopThread() {
        flag = false;
    }
}
public class StopThreadDemo {
    public static void main(String[] args) {
        StopThread stopThread = new StopThread();
        stopThread.start();
        for (int i = 1; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.println("主线程运行:" + i);
                    if (i == 3) {
                        Thread.currentThread().interrupt();
                        stopThread.interrupt();
                    }
                } catch (InterruptedException e) {
                    System.out.println("主线程异常");
                    break;
                }
        }
    }

}
