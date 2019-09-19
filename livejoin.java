class testThread implements Runnable {
    String name;
    Thread t;

    testThread(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("child thread :" + t);
        t.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("child :"+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("child thread interrupted");
        }
        System.out.println("child thread " + t.getName() + " exiting");
    }
}

public class livejoin {
    public static void main(String[] args) {
        testThread t1=new testThread("one");
        testThread t2=new testThread("two");
        testThread t3=new testThread("three");
        
        System.out.println("The thread one is alive ? :"+t1.t.isAlive());
        System.out.println("The thread two is alive ? :"+t2.t.isAlive());
        System.out.println("The thread three is alive ? :"+t3.t.isAlive());
        System.out.println("The main thread is alive ? :"+Thread.currentThread().isAlive());
        try {
            System.out.println("waiting for threads to finish");
            t1.t.join();
            t2.t.join();
            t3.t.join();
        } catch (InterruptedException e) {
            System.out.println("parent thread interrupted");
        }
        System.out.println("The thread one is alive ? :"+t1.t.isAlive());
        System.out.println("The thread two is alive ? :"+t2.t.isAlive());
        System.out.println("The thread three is alive ? :"+t3.t.isAlive());
        System.out.println("The main thread is alive ? :"+Thread.currentThread().isAlive());
        System.out.println("parent thread exiting");
    }
}
