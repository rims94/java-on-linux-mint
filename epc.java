class epc {
    public static void main(String[] args) {
        Queue q = new Queue();
        new producer(q);
        new consumer(q);
        System.out.println("Press CTRL+C to stop");
    }
}

class Queue {
    int n;
    boolean valueset=false;
    synchronized int get() {
        while(!valueset) 
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("thread interrupted");
            }
        System.out.println("got :"+n);
        valueset=false;
        notify();
        return n;
    }
    synchronized void put(int n) {
        while(valueset)
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("thread interrupted");
            }
        this.n=n;
        valueset=true;
        System.out.println("put :"+n);
        notify();
    }
}

class producer implements Runnable {
    Queue q;
    producer(Queue q) {
        this.q=q;
        new Thread(this, "producer").start();
    }
    public void run() {
        int i=0;
        while (true) {
            q.put(i++);
        }
    }
    
}

class consumer implements Runnable {
    Queue q;
    consumer(Queue q) {
        this.q=q;
        new Thread(this, "consumer").start();
    }
    public void run() {
        while (true) {
            q.get();
        }
    }
}