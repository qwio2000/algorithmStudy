class Fibonacci {
	public long fibonacci(int num) {
    long[] fibonacciAry = new long[num+1];
		for (int i=0; i <= num; i++) {
     	if (i==0 || i==1) {
        fibonacciAry[i] = (long)i;
      } else {
       	fibonacciAry[i] = fibonacciAry[i-1] + fibonacciAry[i-2]; 
      }
    }
		return fibonacciAry[num];
	}

  // 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		Fibonacci c = new Fibonacci();
		int testCase = 3;
		System.out.println(c.fibonacci(testCase));
	}
}
