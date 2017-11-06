import java.util.*;

public class ReverseInt {
	public int reverseInt(int n){
		String[] numStrAry = String.valueOf(n).split("");
    String resultStr = "";
    Arrays.sort(numStrAry, Collections.reverseOrder());
    for(String str : numStrAry) resultStr += str;
		return Integer.parseInt(resultStr);
	}
  
	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void  main(String[] args){
		ReverseInt ri = new ReverseInt();
		System.out.println(ri.reverseInt(118372));
	}
}