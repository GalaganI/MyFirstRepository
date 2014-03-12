/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Consumer implements Runnable{
    
    
  Warehouse list;
    
    
  public  Consumer( Warehouse list )
    {
        this.list=list;
    }
  
    @Override
    public void run()
    {
       
        while(Warehouse.getNofReadItems()<list.getSize())
        {
            try {
                
                System.out.println("Thread  "+Thread.currentThread().getName()+" got item :  "+Warehouse.getNofReadItems()+"  "+list.getItem());
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
         
     }
}  
    

