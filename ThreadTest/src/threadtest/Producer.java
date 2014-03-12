/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Producer implements Runnable {
    
     Warehouse list;
     private int pCapacity ;
     public static Random rand= new Random();
   
  public   Producer( Warehouse list, int capacity )
   {
        this.list=list;
        this.pCapacity=capacity;
       
   }
   
    @Override
    public void run()
        {
            for(int i=0 ; i<pCapacity;i++)
            {
               if(i<list.getSize()){
                   list.addItems(rand.nextInt(45));
                   try {
                       Thread.sleep(rand.nextInt(30));
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, ex);
                   }
               }
               else{Thread.yield();}
             }
         }
}


