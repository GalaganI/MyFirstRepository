/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.Random;

/**
 *
 * @author SERGIU
 */
public class TestThreads {
    public static void main(String args[]){
    
    Thread producer;
    Thread
    }
}
class Producer implements Runnable{
    String name;//thread name
    Thread t;
    Warehouse w;
    Random r= new Random();
   Producer(String threadname)
   {
    name=threadname;
    t=new Thread(this,name);
    System.out.println("New thread : " + t);
    t.start();
   }

    @Override
    public void run() {
        try
        {
            for(int i=0;i<100;i++)
            {   
                this.w.setItems(r.nextInt(45));
            }
             
        }catch()
    }

}