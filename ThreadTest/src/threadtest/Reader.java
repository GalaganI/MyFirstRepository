/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;


public class Reader implements Runnable{
    
    Thread reader;
    Warehouse src;
    
    Reader(String threadname)
    {
        reader= new Thread(this,"Thread reader ");
        System.out.println("Reader created "+reader.getName());
        reader.start();
    }

    @Override
    public void run() {
        
        try {
            for(int i=0 ; i<src.size();i++)
            {
               System.out.println("\n Thread "+reader.getName()+" "+src.getItem(i));
               Thread.sleep(1000);
            }
            } catch (InterruptedException ex) 
            {
            System.out.println("Thread was interrupted");
            }
    }
    
}
