/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpater5_2;

/**
 *
 * @author anda
 */
public class Chpater5_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] horses = new String[5];
        horses[4] = null;
        for(int i = 0;i<horses.length;i++)
        {
            if (i< args.length)
                horses[i] = args[i];
            System.out.println(horses[i].toUpperCase() + " ");
            System.err.println();
        }
        
    }
    
}