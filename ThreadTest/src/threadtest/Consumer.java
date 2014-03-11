/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;


public class Consumer implements Runnable{
    
    
    Warehouse list;
    public static int count=0 ;
    
    Consumer( Warehouse list )
    {
        this.list=list;
    }
  
    @Override
    public void run() {
       
        while(count<list.size()){
            count++;
            System.out.println("Thread  "+Thread.currentThread().getName()+" got :  "+list.getItem());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            
        }
        }
            }
}  
    

