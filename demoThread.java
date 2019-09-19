class testThread implements Runnable {
	String name;
	Thread t;

	testThread(String threadname) {
		name=threadname;
		t=new Thread(this, name);
		System.out.println("child thread :"+t);
		t.start();
	}
	public void run() {
		try {
			for(int i=5;i>0;i--) {
				System.out.println("child");
					Thread.sleep(500);
			}
			}catch(InterruptedException e){
				System.out.println("child thread interrupted");
			}
			System.out.println("child thread exiting"+t.getName());
	}
}
public class demoThread {
	public static void main(String[] args) {
		new testThread("one");
		new testThread("two");
		new testThread("three");
		try {
			for(int i=5;i>0;i--) {
				System.out.println("parent");
					Thread.sleep(1500);
			}
			}catch(InterruptedException e){
				System.out.println("parent thread interrupted");
			}
			System.out.println("parent thread exiting");
	}

}
