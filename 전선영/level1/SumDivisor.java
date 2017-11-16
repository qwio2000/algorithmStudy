class SumDivisor {
	public int sumDivisor(int num) {
		int answer = 0;
		int i = 1;
    while(i <= num){
    	if(num % i != 0){        
    		++i;	
      }else{
        answer = answer + i;
        ++i;
      }
    }
    
		return answer;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		SumDivisor c = new SumDivisor();
		System.out.println(c.sumDivisor(12));
	}
}
