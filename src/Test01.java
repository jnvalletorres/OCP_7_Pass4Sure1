
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vallje02
 */
public class Test01 {

    public static void main(String[] args) {

    }

}

class Super {

    public void process() throws FileNotFoundException {
    }
}

class Derived extends Super {

    @Override
    public void process() throws FileNotFoundException {
        super.process(); 
    }
    
}
