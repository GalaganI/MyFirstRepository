/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;




public class TestThreads {
    public static void main(String args[]) throws InterruptedException {
    Warehouse list = new Warehouse(50);
     new Producer("Producer",list);
     new Consumer("Redear 1",list);
     new Consumer("Redear 2", list);
    }
  }
