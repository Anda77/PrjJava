/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realbrainer1;

/**
 *
 * @author andad
 */
class A {

    A() {
        print();
    }

    void print() {
        System.out.println("A");
    }
}

public class RealBrainer1 extends A {

    /**
     * @param args the command line arguments
     */
    int i = 4;
/**
    void print() {
        System.out.println(i);
    }
    * */

    public static void main(String[] args) {
        // TODO code application logic here
        A a = new RealBrainer1();
        a.print();
    }

}
