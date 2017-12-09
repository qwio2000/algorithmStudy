class EatCookie
{
	public int eatCookie(int []cookies){
		int answer = 0;
    //dp 결과값 저장용
		int[] dpCnt = new int[cookies.length];
    for(int i=0; i<cookies.length; i++) {
      int max = 0;
      //대상 쿠키와 대상 쿠키보다 앞에 있는 쿠키 들의 결과 값 비교
      for(int j=0; j < i; j++){
        //1. 지금까지 나온 max 값 보다 비교 대상할 값이 작은 경우에는 비교 안함
        //2. 대상 쿠키보다 비교할 쿠키가 작은 경우 비교할 쿠키의 dp값(이미 계산된 값)을 max에 넣음
        if(dpCnt[j] > max && cookies[j] < cookies[i]) max = dpCnt[j];
      }
      //비교할 쿠키의 dp값에 자기 자신 먹을 횟수 추가하기 위해 ++해줌
      dpCnt[i] = ++max;
    }
    
    for(int i=0; i<dpCnt.length; i++) {
      if(answer < dpCnt[i]) answer = dpCnt[i];
    }
		return answer;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		EatCookie e = new EatCookie();
		int []cookies = {1, 4, 2, 6, 3, 4, 1, 5};
		System.out.println(e.eatCookie(cookies));
	}
}
