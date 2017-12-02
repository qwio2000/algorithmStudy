class TryHelloWorld {
	public int tiling(int n) {

		if (n == 1) {
			return 1;
		} else if (n == 2) {
			return 2;
		}
		int previous = 1;
		int value = 2;

		for (int i = 3; i <= n; i++) {
			int tmp = value;
			value = (previous + value) % 100000;
			previous = tmp; 
		}

		return value;
	}

	public static void main(String args[]) {
		TryHelloWorld tryHelloWorld = new TryHelloWorld();
		System.out.println(Integer.MAX_VALUE);
		System.out.println(tryHelloWorld.tiling(779));
	}
}
