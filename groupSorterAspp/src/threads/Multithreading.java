package threads;

public class Multithreading {
	public static void main(String[] args) {
		//using Thread class
		Worker w1 = new Worker();
		Worker w2 = new Worker();
		w1.setName("Worker #1");
		w2.setName("Worker #2");
		w1.start();
		w2.start();
		
		Thread t1 = new Thread(new TaskExecutor());
		Thread t2 = new Thread(new TaskExecutor());

		t1.start();
		t2.start();
	}
	
}

class Worker extends Thread {
	@Override
	public void run() {
		System.out.println("Running thread [" + getName() + "] ...");
	}
}

class TaskExecutor implements Runnable {
	
	@Override
	public void run() {
		System.out.println("Running thread ...");
	}
}