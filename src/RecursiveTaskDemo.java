
import java.util.concurrent.RecursiveTask;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vallje02
 */
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class RecursiveTaskDemo {

    public static void main(String[] args) {
        FibonacciCal fibonacciCal = new FibonacciCal(40);
        ForkJoinPool pool = new ForkJoinPool();
        int i = pool.invoke(fibonacciCal);
        System.out.println(i);
    }
}

class FibonacciCal extends RecursiveTask<Integer> {

    private static final long serialVersionUID = 1L;
    final int num;

    FibonacciCal(int num) {
        this.num = num;
    }

    @Override
    protected Integer compute() {
        if (num <= 1) {
            return num;
        }
        FibonacciCal fcal1 = new FibonacciCal(num - 1);
        fcal1.fork();
        FibonacciCal fcal2 = new FibonacciCal(num - 2);
        return fcal2.compute() + fcal1.join();
    }
}
