class OneTwoFour {
	public String change124(int n) {
		String answer = "";
    int tempNum = n;
		int quotient = 0;
    int remainder = 0;
    while(tempNum > 0){      
    	quotient = tempNum / 3;
      remainder = tempNum % 3;
      if(remainder == 0){
      	tempNum = quotient - 1;
        answer = "4" + answer;
      }else{
        tempNum = quotient;
        answer = String.valueOf(remainder) + answer;
      }
    }
		return answer;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		OneTwoFour oneTwoFour = new OneTwoFour();
		System.out.println(oneTwoFour.change124(21));
	}
}
