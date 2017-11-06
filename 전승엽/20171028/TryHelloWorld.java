import java.util.Arrays;
import java.math.*;

class TryHelloWorld {
    public int[] gcdlcm(int a, int b) {
        int[] answer = new int[2];
				int minVal = Math.min(a, b);
      	for (int i=1; i <= minVal; i++) {
      			if(a % i == 0 && b % i == 0) answer[0] = i;
        }
      	answer[1] = (a * b) / answer[0];
        return answer;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        TryHelloWorld c = new TryHelloWorld();
        System.out.println(Arrays.toString(c.gcdlcm(3, 12)));
    }
}
