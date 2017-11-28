/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication497;

/**
 *
 * @author andad
 */
public class JavaApplication497 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] a = {{1, 2}, {3, 4}};
        int[] b = (int[]) a[1];
        Object o1 = a;
        int[][] a2 = (int[][]) o1;
        //int[] b2 = (int[]) o1;
        System.out.println(b[1]);
    }

}
