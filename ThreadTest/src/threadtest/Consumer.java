/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;


public class Consumer implements Runnable{
    
    Thread reader;
    Warehouse list;
    Consumer(String threadname , Warehouse list)
    {
        reader= new Thread(this);
        System.out.println("Reader created "+reader.getName());
        this.list=list;
        reader.start();
    }
  
    @Override
    public void run() {
        int i=0;
        while(true)
            System.out.println("Thread "+reader.getName()+"got "+i+" "+list.getItem(i++));
            }
}  
    

