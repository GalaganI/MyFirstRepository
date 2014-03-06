/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Reader implements Runnable{
    
    Thread reader;
    Warehouse src;
    
    Reader(String threadname)
    {
        reader= new Thread(this,"Thread reader ");
        System.err.println("Reader created ");
        reader.start();
    }

    @Override
    public void run() {
        
        try {
            for(int i=0 ; i<(src.size()-1);i++)
            {
               System.out.println("\n"+src.getItem(i));
               Thread.sleep(10);
            }
            } catch (InterruptedException ex) 
            {
            Logger.getLogger(Reader.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
}
