
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vallje02
 */
public class Test05 {

    public static void main(String[] args) {
        //System.out.println("start");
        Map<A, String> m1 = new Hashtable<>();
        Set<A> s1 = new TreeSet<>();
        A a1 = new A(1);
        A a2 = new A(2);
        m1.put(a1, "1");
        m1.put(a2, "2");
        m1.put(a1, "3");
        m1.put(a1, "4");
        //s1.add(a1);
        //s1.add(a2);
        //showSet(m1);
        showMap(m1);
    }

    private static void showSet(Set<A> list) {
        for (A item : list) {
            System.out.println("item:" + item);
        }
    }

    private static void showMap(Map<A, String> map) {
        Iterator<A> i = map.keySet().iterator();
        while (i.hasNext()) {
            System.out.println("map: " + map.get(i.next()));
        }
    }

}

class A implements Comparator<A> {

    private int id;

    public A(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        System.out.println("toString");
        return "id" + id;
    }

    @Override
    public int hashCode() {
        int hc = super.hashCode(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("hashCode: " + hc);
        return hc;
    }

    //@Override
    public int compareTo(A o) {
        System.out.println("compareTo");
        if (this.id > o.id) {
            return 1;
        } else if (this.id < o.id) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        boolean e = super.equals(obj); //To change body of generated methods, choose Tools | Templates.
        System.out.println("equals: "+ e + " " + obj);
        return e;
    }

    @Override
    public int compare(A o1, A o2) {
        System.out.println("compare");
        if (o1.id > o2.id) {
            return 1;
        } else if (o1.id < o2.id) {
            return -1;
        } else {
            return 0;
        }
    }

}
