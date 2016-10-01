
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vallje02
 */
public class Test07 {

    public static void main(String[] args) {
        AAA.BBB b = new AAA().new BBB();
        AAA.CCC c = new AAA.CCC();
        
        //List<> l = new ArrayList <>();
    }
}

 interface I {
    public  String a="";
    public abstract String getType();
} 
        
        
class AAA {

    static String aaa; 
    
    private void a() {
    }

    class BBB {

        private void b() {
            a();
        }

    }

    static class CCC {

        void c() {
        }
    }

}
