/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SERGIU
 */
public class Warehouse 
{
     
    private List<Integer> warehouse ;
    private int size ;
   
     public Warehouse(int number)
    {
        warehouse=new ArrayList<Integer>(number);
        size=number;
    }
     
     public synchronized int getItem(int index)
     {
        return warehouse.get(index);
     }
     
     public final void setItems(int item)
     {
       
        warehouse.add(item);
        
     }
     public int size()
     {
         return this.size;
     }
}
