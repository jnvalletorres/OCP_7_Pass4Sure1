
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vallje02
 */
public class Test08 {

    public static void main(String[] args) {
        MyThread r = new MyThread();
        Thread t1 = new Thread(r);
        t1.start();
        Thread t2 = new Thread(r);
        t2.start();
    }
}

class MyThread implements Runnable {

    private AtomicInteger count = new AtomicInteger(0);

    @Override
    public void run() {

        try {
            System.out.println("start: " + Thread.currentThread().getName());
            System.out.println("count: " + count.incrementAndGet());
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            System.out.println("end: " + Thread.currentThread().getName());
        }
    }
}
