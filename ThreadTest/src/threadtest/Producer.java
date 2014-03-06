/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.Random;


public class Producer implements Runnable {
    
    private String name;//thread name
    private Thread producer;
    private Warehouse list;
    public static Random rand= new Random();
   
    Producer(String threadname)
   {
    name=threadname;
    producer=new Thread(this,name);
    System.out.println("New thread : " + producer);
    producer.start();
   }
  

    @Override
    public void run() {
        
            for(int i=0;i<100;i++)
            {   
                while(i<list.size())
                {
                this.list.setItems(rand.nextInt(45));
                continue;
                }
                producer.yield();
            }
             
        
    }

}
