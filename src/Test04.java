
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
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
public class Test04 extends Thread {

    private Thread ot;
    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:sss", Locale.US);

    public Test04(String title) {
        super(title);
    }

    @Override
    public void run() {
        synchronized (this.ot) {
            try {
                System.out.println(this.dateFormat.format(new Date()) + "-start: " + Thread.currentThread().getName());
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Test04.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                System.out.println(this.dateFormat.format(new Date()) + "-end: " + Thread.currentThread().getName());
            }
        }
    }

    public void setThred(Thread ot) {
        this.ot = ot;
    }

    public static void main(String[] args) {
        Test04 t1 = new Test04("T1");
        Test04 t2 = new Test04("T2");
        t1.setThred(t1);
        t2.setThred(t1);
        t2.start();
        t1.start();
        
        
    }
}
