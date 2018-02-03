public class CircularQueueTest {

	public static void main(String[] args) {
		
		System.out.println("테스트: 생성");
		IQueue queue = new CircularQueue();
		System.out.println(queue);

		System.out.println("테스트: isFull? " + queue.isFull());
		System.out.println("테스트: isEmpty? " + queue.isEmpty());
		System.out.println();

        int REPEAT_NUMBER = 9;


		for (int i = 0; i < REPEAT_NUMBER; i++) {
			System.out.println("테스트: enqueue " + i);
			queue.enqueue(i);
			System.out.println(queue);
			System.out.println();

			System.out.println("테스트: isFull? " + queue.isFull());
			System.out.println("테스트: isEmpty? " + queue.isEmpty());
			System.out.println();
		}

		for (int i = 0; i < REPEAT_NUMBER; i++) {
			System.out.println("테스트: dequeue");
			System.out.println("dequeued " + queue.dequeue());
			System.out.println(queue);
			System.out.println();

			System.out.println("테스트: isFull? " + queue.isFull());
			System.out.println("테스트: isEmpty? " + queue.isEmpty());
			System.out.println();
		}
        
        REPEAT_NUMBER = 6;

		for (int i = 0; i < REPEAT_NUMBER; i++) {
			System.out.println("테스트: enqueue " + i);
			queue.enqueue(i);
			System.out.println(queue);
			System.out.println();

			System.out.println("테스트: isFull? " + queue.isFull());
			System.out.println("테스트: isEmpty? " + queue.isEmpty());
			System.out.println();
		}

		for (int i = 0; i < REPEAT_NUMBER; i++) {
			System.out.println("테스트: dequeue");
			System.out.println("dequeued " + queue.dequeue());
			System.out.println(queue);
			System.out.println();

			System.out.println("테스트: isFull? " + queue.isFull());
			System.out.println("테스트: isEmpty? " + queue.isEmpty());
			System.out.println();
		}

	}

}
