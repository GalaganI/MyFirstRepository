/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Consumer implements Runnable{
    
    
    Warehouse list;
    
    
    Consumer( Warehouse list )
    {
        this.list=list;
    }
  
    @Override
    public void run()
    {
       
        while(Warehouse.getCount()<list.size())
        {
            try {
                
                System.out.println("Thread  "+Thread.currentThread().getName()+" got item :  "+Warehouse.getCount()+"  "+list.getItem());
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         
     }
}  
    

