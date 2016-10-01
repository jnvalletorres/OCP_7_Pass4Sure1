/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vallje02
 */
public class Test06 {

    public static void main(String[] args) {
        new BB().go();
    }
}

class AA {

    int a = 5;

    String doA() {
        return "a1";
    }

    protected static String doA2() {
        return "a2";
    }
}

class BB extends AA {

    int a = 7;

    @Override
    String doA() {
        return "b1";
    }

    public static String doA2() {
        return "b2";
    }

    void go() {
        AA myA = new BB();
        System.out.println(myA.a + "-" + AA.doA2() + "-" + myA.doA());
    }
}
