import java.util.*;

class OneTwoFour {
  
	public String change124(int n) {
		String answer = "";
    //나머지 값에 인덱스가 매핑되도록 문자열 배열 생성
  	String[] numStrs = {"4","1","2"};
    while(n != 0){
      int mod = n % 3;
      answer = numStrs[mod] + answer;
      n /= 3;
      //0이 없기 때문에 나머지가 0인 경우 몫에서 1을 빼줌
      if(mod == 0) n -= 1;      
    }
		return answer;
  } 

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		OneTwoFour oneTwoFour = new OneTwoFour();
		System.out.println(oneTwoFour.change124(11));
	}
}
