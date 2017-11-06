import java.util.*;

public class ReverseStr {
	public String reverseStr(String str){
    String[] splitAry = str.split("");
    Arrays.sort(splitAry, Collections.reverseOrder());
		return String.join("", splitAry);
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		ReverseStr rs = new ReverseStr();
		System.out.println( rs.reverseStr("sEswftZGhLUfWjs") );
	}
}