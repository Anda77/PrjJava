/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forincorect;

/**
 *
 * @author andad
 */
public class ForIncorect {

    /**
     * @param args the command line arguments
     */
   private int j;
   void showJ(){
           while(j<=5){ 
                   
                   for(int j=1; j <= 5;){
                           System.out.print(j+" "); 
                                   j++; } 
                   j++;
           }
   }
    
    public static void main(String[] args) {
        // TODO code application logic here
         new ForIncorect().showJ(); 
    }
    
}
