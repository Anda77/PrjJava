/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promotion1;

/**
 *
 * @author andad
 */
public class Promotion1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int i = 5;
        float f = 5.5f;
        double d = 3.8;
        char c = 'a';
        if (i == f) {
            c++;
        }
        if (((int) (f + d)) == ((int) f + (int) d)) {
            c += 2;
        }
        System.out.println(c);
    }

}
