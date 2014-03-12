/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.ArrayList;
import java.util.List;


public class Warehouse 
{
     
    private static List<Integer> warehouse ;
    private int size ;
    private static int count=0;
   
     
    public Warehouse(int nOfItems)
    {
        warehouse=new ArrayList<Integer>(nOfItems);
        size=nOfItems;
    }
     
     public  synchronized int getItem() throws InterruptedException
     {  
        if(warehouse.isEmpty())
            wait();
        return   warehouse.get(count++) ;
     }
     
     public synchronized void addItems(int item)
     {
         warehouse.add(item);
         System.out.println("Item was added to the list "+item);
         notifyAll();
     }
     public static int getCount()
     {
       return count;
     }
     public static List<Integer> getWarehouse()
     {
        return warehouse ;
     }
     public int size()
     {
         return this.size;
     }
     
}
