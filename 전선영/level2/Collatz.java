class Collatz {
	public int collatz(int num) {
		int answer = 0;
    long n = num;
    while(n > 1){
      if(answer >= 500){
      	answer = -1;
        break;
      }
    	if(n % 2 != 0){
        n = (n*3)+1;           
      }else{
        n = n / 2;  
      }
      answer += 1;  
    }

		return answer;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		Collatz c = new Collatz();
		int ex = 6;
		System.out.println(c.collatz(ex));
	}
}