/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadtest;




public class TestThreads {
    public static void main(String args[]) {
    
     Producer producer =new Producer("Producer");
   // System.out.println(producer.thread.isAlive());
    Reader reader1=new Reader("Redear 1");
    Reader reader2=new Reader("Redear 2");
        try {
            //producer.thread.join();
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            System.out.println("Main thread interupted");;
        }
    }
}
