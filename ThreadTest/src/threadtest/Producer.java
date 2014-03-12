/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.Random;


public class Producer implements Runnable {
    
     Warehouse list;
     public static Random rand= new Random();
   
    Producer( Warehouse list)
   {
        this.list=list;
       
   }
   
 

    @Override
    public void run()
        {
            for(int i=0 ; i<100;i++)
            {
               if(Warehouse.getCount()<50)
                list.addItems(rand.nextInt(45));
               else{Thread.yield();}
             }
         }
}


