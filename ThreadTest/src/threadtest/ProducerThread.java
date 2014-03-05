/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.List;
import java.util.Random;

/**
 *
 * @author SERGIU
 */
public class ProducerThread implements Runnable {
     
    private List<Integer> warehouse ;
    private static int nOfitems =50;
    private static Random r= new Random();
    public ProducerThread(){
    while(nOfitems-- >0){
    warehouse.add(r.nextInt(nOfitems));
    }
    }
    
    @Override
    public void run() {
        
    }

    
}
