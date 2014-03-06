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
     
    private List<Integer> warehouse = new ArrayList<Integer>(50);
    
    
     public Warehouse(int number)
    {
        setItems(number);
    }
     
     public synchronized int getItem(int index)
     {
        return this.warehouse.get(index);
     }
     
     public final void setItems(int item)
     {
        while(warehouse.size()<50)
        {
        warehouse.add(item);
        }
     }
}
