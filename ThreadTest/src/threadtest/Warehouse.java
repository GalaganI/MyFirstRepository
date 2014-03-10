/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;

import java.util.ArrayList;
import java.util.List;


public class Warehouse 
{
     
    private List<Integer> warehouse ;
    private int size ;
    boolean valueSet=false;
     
    public Warehouse(int number)
    {
        warehouse=new ArrayList<Integer>(number);
        size=number;
    }
     
     public  synchronized int getItem()
     {
         while(!valueSet)
         {
             try{
             wait();
             }catch(InterruptedException e){
                 System.out.println("Interuptedexception cought");
             }
          }
         
         valueSet=false;
         notify();
        return   warehouse.iterator().next() ;
     }
     
     public synchronized void setItems(int item)
     {
       while(valueSet){
           try{
           wait();
           }catch(InterruptedException ex){
                System.out.println("Interuptedexception cought");
           }
       }
        warehouse.add(item);
        valueSet=true;
        System.out.println("Item was added to the list "+item);
        notify();
     }
     public int size()
     {
         return this.size;
     }
     
}
