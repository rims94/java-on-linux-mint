class hur implements Runnable {
    String name;
    Thread hour;
    hur(String threadname) {
        name=threadname;
        hour=new Thread(this,name);
        hour.start();
    }
    synchronized public void run() {
        try {
            synchronized(this) {
                do{
                    for (int i = 0; i < 60; i++) {
                        System.out.println("\n");
                        System.out.println("HOUR :"+i);
                        Thread.sleep(3600000);
                    }
                    System.out.println("\n");          
                }while(true);
            }
        } catch (InterruptedException e) {
            System.out.println("thread interrupted");
        }
    }
}


class mnute implements Runnable {
    String name;
    Thread minute;
    mnute(){}
    mnute(String threadname) {
        name=threadname;
        minute=new Thread(this,name);
        minute.start();
    }
    synchronized public void run() {
        try {
            synchronized(this) {
                do{
                    for (int i = 0; i < 60; i++) {
                        System.out.println("\n");
                        System.out.println("MINUTE :"+i);
                        Thread.sleep(60000);
                    }
                    System.out.println("\n");
                }while(true);
            }
        } catch (InterruptedException e) {
            System.out.println("thread interrupted");
        }
    }
}

class secnd implements Runnable {
    String name;
    Thread second;
    secnd(){}
    secnd(String threadname) {
        name=threadname;
        second=new Thread(this,name);
        second.start();
    }
    synchronized public void run() {
        try {
            synchronized(this){
               do {
                    System.out.print("SECOND :");
                    for (int i = 0; i < 60; i++) {
                        System.out.print(i+",");
                        Thread.sleep(1000);
                    }
                    System.out.print("\n");
                }while(true);
            }
        } catch (InterruptedException e) {
            System.out.println("thread interrupted");
        }
    }
}





public class stopwatch {

    public static void main(String[] args) {
        hur h=new hur("hour");
        mnute m=new mnute("minute");
        secnd s=new secnd("second");        
        try {
            s.second.join();
            m.minute.join();
            h.hour.join();
        } catch (InterruptedException e) {
            System.out.println("thread interrupted");
        }
    }
}