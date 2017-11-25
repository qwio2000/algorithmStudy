class OneTwoFour {
	public String change124(int n) {
    String answer = "";
    String digits = "124";
    
    while (n > 0) {
      n -= 1;
      answer = digits.charAt(n % 3) + answer;
      n /= 3;
    }

		return answer;
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		OneTwoFour oneTwoFour = new OneTwoFour();
		System.out.println(oneTwoFour.change124(10));
	}
}
