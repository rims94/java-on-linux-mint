class synch {

    public static void main(String[] args) {
        callme target = new callme();
        caller c1 = new caller(target, "Hello");
        caller c2 = new caller(target, "Synchronized");
        caller c3 = new caller(target, "World");
        try {
        c1.t.join();
        c2.t.join();
        c3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }
}

class caller implements Runnable{
    callme target;
    String msg;
    Thread t;
    public caller(callme targ,String s) {
        target=targ;
        msg=s;
        t=new Thread(this);
        t.start();        
    }
    public void run() {
        synchronized(target) {
            target.call(msg);
        }
    }
    
}

class callme {
    synchronized void call(String msg) {
        System.out.print("["+msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
        System.out.println("]");
    }
    
}