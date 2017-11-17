import java.util.Arrays; //테스트로 출력해 보기 위한 코드입니다.

public class BestSet {

    public int[] bestSet(int n, int s){
		int[] answer = null;
		int averageNum = s/n;
        if (averageNum == 0) {
			answer = new int[1];
			answer[0] = -1;
		} else {
			answer = new int[n];
			for (int i=0; i < n; i++) answer[i] = averageNum; 
			for (int i=0; i < (s % n); i++) answer[answer.length-1-i] += 1;
		}
		return answer;
    }
    public static void main(String[] args) {
        BestSet c = new BestSet();
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(Arrays.toString(c.bestSet(3,13)));
    }

}