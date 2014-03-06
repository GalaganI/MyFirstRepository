/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.Random;


public class Producer implements Runnable {
    
     String name;//thread name
     Thread thread;
     Warehouse list;
    public static Random rand= new Random();
   
    Producer(String threadname)
   {
        //list=new Warehouse(50);
        name=threadname;
        thread=new Thread(this,name);
        System.out.println("New thread : " + thread.getName());
        thread.start();
   }
  

    @Override
    public void run()
        {
        
               list = new Warehouse(50);
               System.out.println(list.size());
                for(int i=0; i<list.size(); i++)
                {
                list.setItems(rand.nextInt(45));
                System.out.println(list.getItem(i));
               
                }
                
                thread.yield();
            }
             
        
    }


