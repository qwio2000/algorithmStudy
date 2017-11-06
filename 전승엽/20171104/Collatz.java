class Collatz {
	public int collatz(int num) {
    for(int i=0; i<500; i++) {
      num = num % 2 == 1 ? num * 3 + 1 : num / 2;
      if(num == 1) return i+1;
    }
    return -1;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		Collatz c = new Collatz();
		int ex = 6;
		System.out.println(c.collatz(ex));
	}
}