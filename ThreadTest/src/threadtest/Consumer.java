/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Consumer implements Runnable{
    
    
    Warehouse list;
    public static int count=0 ;
    
    Consumer( Warehouse list )
    {
        this.list=list;
    }
  
    @Override
    public void run()
    {
       
        while(count<list.size())
        {
            count++;
            try {
                System.out.println("Thread  "+Thread.currentThread().getName()+" got :  "+list.getItem());
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
     }
}  
    

