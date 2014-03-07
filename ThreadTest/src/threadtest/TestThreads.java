/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;




public class TestThreads {
    public static void main(String args[]) throws InterruptedException {
    //Warehouse list= new Warehouse(50);
     Producer producer =new Producer("Producer");
    // producer.thread.join();
   // System.out.println(producer.thread.isAlive());
    Reader reader1=new Reader("Redear 1",producer);
   Reader reader2=new Reader("Redear 2", producer);
        
    }
  }
