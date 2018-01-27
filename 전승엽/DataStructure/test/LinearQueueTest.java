package test;

import vo.LinearQueue;

public class LinearQueueTest {

	public static void main(String[] args) {
		LinearQueue queue = new LinearQueue();
		for (int i = 0; i < 6; i++) {
			System.out.println("enqueue : TEST"+i);
			queue.enqueue("TEST"+i);
			System.out.println(queue.toString());
		}
		System.out.println("Peek : " + queue.peek());
		System.out.println(queue.toString());
		
		for (int i = 0; i < 6; i++) {
			System.out.println("DEQUEUE : " + queue.dequeue());
			System.out.println(queue.toString());
		}
		System.out.println("Peek : " + queue.peek());
		System.out.println(queue.toString());
	}

}
