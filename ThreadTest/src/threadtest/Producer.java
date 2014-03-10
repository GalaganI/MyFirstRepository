/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Producer implements Runnable {
    
     String name;//thread name
     Thread thread;
     Warehouse list;
     boolean suspendFlag=false;
     public static Random rand= new Random();
   
    Producer(String threadname , Warehouse list)
   {
        this.list=list;
        name=threadname;
        thread=new Thread(this,name);
        System.out.println("New thread : " + thread.getName());
        thread.start();
   }
   
 

    @Override
    public void run()
        {
        
               int i=0;
               //System.out.println(list.size());
                while(i<50){
                  try {
                      list.setItems(rand.nextInt(45));
                      i++;
                  }catch(ArrayIndexOutOfBoundsException e){
                      System.out.println("No more place for items adding");
                  }
                }
                  
          }
             
        
    }


