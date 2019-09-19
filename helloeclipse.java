class tryinheritance extends Thread {
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println("hello eclipse from outsider");
			try {
				Thread.sleep(1000);
			}catch(Exception e) {}
		}
	}
}
class tryinharitance extends tryinheritance implements Runnable {
	public void run() {
		for(int i=1;i<=5;i++) {
			System.out.println("hello eclipse from insider");
			try {
				Thread.sleep(500);
			}catch(Exception e) {}
		}
	}
}
class helloeclipse {
	public static void main(String[] args) {
		tryinheritance h=new tryinheritance();
		tryinharitance i=new tryinharitance();
		h.start();
		i.start();
	}
}