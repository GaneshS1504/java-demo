package clientApp;

public class StackUsingThread {

	private int stack[];
	private int stackTop;

	Object lock = new Object();

	public StackUsingThread(int capacity) {
		super();
		stack = new int[capacity];
		stackTop = -1;
	}

	public boolean isStackEmpty() {
		return stackTop == -1 ? true : false;
	}

	public boolean isStackFull() {
		return stackTop >= stack.length ? true : false;
	}

	public boolean push(int element) {

		synchronized (lock) {
			if (isStackFull())
				return false;
			++stackTop;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stack[stackTop] = element;
			return true;
		}

	}

	public int pop() {

		synchronized (lock) {
			if (isStackEmpty())
				return Integer.MIN_VALUE;

			int removedElement = stack[stackTop];
			stack[stackTop] = Integer.MIN_VALUE;
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			stackTop--;
			return removedElement;

		}
	}

	public static void main(String[] args) {

		System.out.println("Main Thread is starting");

		StackUsingThread stack = new StackUsingThread(5);
		Thread t1 = new Thread(() -> {
			int counter = 1;
			while (counter <= 5) {
				System.out.println(Thread.currentThread().getName() + " thread pushed " + stack.push(counter));
				counter++;
			}
		}, "pusher");

		t1.start();

		Thread t2 = new Thread(() -> {
			int counter = 1;
			while (counter <= 5) {
				System.out.println(Thread.currentThread().getName() + " thread popped " + stack.pop());
				counter++;
			}
		}, "popper");

		t2.start();

		System.out.println("Main Thread is stopped");
	}

}
