class NLCM {
	public long nlcm(int[] num) {
		long answer = num[0];
    int tempNum = 0;
    long max = 0;
    long min = 0;
		for(int i = 0; i<num.length; ++i){
    	tempNum = num[i];
      max = Math.max(answer, tempNum);
      min = Math.min(answer, tempNum);
    	answer = max * min / gcd(max, min);
    }
		return answer;
	}

  public long gcd(long max, long min){
  	if (min == 0) {
        return max;
    } else {
        return gcd(min, max % min);
    }
  }
  
	public static void main(String[] args) {
		NLCM c = new NLCM();
		int[] ex = { 2, 6, 8, 14 };
		// 아래는 테스트로 출력해 보기 위한 코드입니다.
		System.out.println(c.nlcm(ex));
	}
}