/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.Random;


public class Producer implements Runnable {
    
     String name;//thread name
     Thread thread;
     Warehouse list=new Warehouse(50);
    public static Random rand= new Random();
   
    Producer(String threadname)
   {
        
        name=threadname;
        thread=new Thread(this,name);
        System.out.println("New thread : " + thread.getName());
        thread.start();
   }
   
 

    @Override
    public void run()
        {
        
               
               System.out.println(list.size());
                for(int i=0; i<100; i++)
                {
                   if(i<list.size())
                   {
                    list.setItems(rand.nextInt(45));
                    System.out.println("Producer item number : "+i+" ("+list.getItem(i)+" )");
                    continue;
                   }
                   thread.yield();
                }
                
                
         }
             
        
    }


