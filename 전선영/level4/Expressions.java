public class Expressions {

	public int expressions(int num) {
		int answer = 0;
 		for(int i = 1; i<=num; ++i){
    	if(num%i == 0 && i%2 ==1){
      	answer++;
      }
    }
		return answer;
	}

	public static void main(String args[]) {
		Expressions expressions = new Expressions();
		// 아래는 테스트로 출력해 보기 위한 코드입니다.
		System.out.println(expressions.expressions(15));
	}
}