/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;




public class TestThreads {
    public static void main(String args[]) throws InterruptedException {
       
         Warehouse list = new Warehouse(50);
         Thread producer = new Thread(new Producer(list,100),"Producer");
         Thread consumer1 = new Thread (new Consumer(list),"Consumer 1");
         Thread consumer2 = new Thread (new Consumer(list),"Consumer 2");
         producer.start();
         consumer1.start();
         consumer2.start();
    }
  }
