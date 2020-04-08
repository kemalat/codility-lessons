package com.baykalsoft.miscellaneous;

/*
  In Java, each thread has its own stack, including its own copy of variables it can access.
  When the thread is created, it copies the value of all accessible variables into its own stack.
  The volatile keyword basically says to the JVM “Warning, this variable may be modified in another Thread”.

  One common example for using volatile is for a flag to terminate a thread. If you’ve started a thread, and
  you want to be able to safely interrupt it from a different thread, you can have the thread periodically
  check a flag (i.e., to stop it, set the flag to true). By making the flag volatile,
  you can ensure that the thread that is checking its value will see that it has been set to
  true without even having to use a synchronized block.
*/

public class Foo extends Thread {

  public Foo() {

    stopped = false;
    suspended = false;
    lock = new Object();

  }

  private volatile boolean suspended, stopped = false;
  private final Object lock;

  public static void main(String args[]) throws InterruptedException {

    Foo foo = new Foo();
    foo.start();
    foo.suspendThread();
    Thread.sleep(2000);
    foo.resumeThread();
    Thread.sleep(4000);
    foo.suspendThread();
    Thread.sleep(2000);
    foo.resumeThread();
    Thread.sleep(4000);
    foo.stopThread();
  }

  public void run() {

    while(!stopped){
      while(!suspended) {
        try {
          Thread.sleep(1000);
          System.out.println("Thread working");

        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }

      System.out.println("Suspending Thread...");

      if(stopped)
        break;

      synchronized (lock){
        try {
          lock.wait();
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          return;
        }
      }
      System.out.println("Resuming Thread...");


    }
    System.out.println("Thread stopped");


  }

  public void suspendThread(){
    suspended = true;
  }
  public void stopThread(){
    synchronized (lock){
      lock.notifyAll();
    }
    suspended = true;
    stopped = true;
  }

  public void resumeThread(){
    suspended = false;
    synchronized (lock){
      lock.notifyAll();
    }
  }


}
