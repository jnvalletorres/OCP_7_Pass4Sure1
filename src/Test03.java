
import java.io.Serializable;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vallje02
 */
public class Test03 {

    public static void main(String[] args) {
        new Manager();
        
        Locale l = new Locale("fr","MX");
        System.out.println(l.getDisplayCountry());
        System.out.println(l.getDisplayName());       
        System.out.println(l.getCountry());       
        System.out.println(l);
    }
}

class Employee {

    String name;
    transient String companyName;
}

class Manager extends Employee implements Serializable {
    
    String mgrid;
}
