/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Reader implements Runnable{
    
    Thread reader;
    Producer src;
    
    Reader(String threadname , Producer producer)
    {
        reader= new Thread(this);
        System.out.println("Reader created "+reader.getName());
        src=producer;
        reader.start();
    }
  
    @Override
    public void run() {
        
        System.out.println("Thread "+reader.getName());
        try{
                src.list.print();
        }catch(NullPointerException e)
        {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            }
             src.list.print();
        }
    }
    
}
