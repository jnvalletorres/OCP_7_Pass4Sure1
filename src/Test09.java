/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vallje02
 */
public class Test09 {

    public static void main(String[] args) {
        Rideable r1 = new Icelandic();
        Rideable r2 = new Horse();
        Horse h1 = new Icelandic();
        System.out.println("result: " + r1.ride() + r2.ride() + h1.ride());
    }

}

interface Rideable {

    String ride();
}

class Horse implements Rideable {

    @Override
    public String ride() {
        return "cantering ";
    }

}

class Icelandic extends Horse {

    @Override
    public String ride() {
        return "tolting ";
    }

}
