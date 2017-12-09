import java.util.*;

class Hanoi {
  ArrayList<int[]> hanoiAry = new ArrayList<int[]>();
	public int[][] hanoi(int n) {
		// 2차원 배열을 완성해 주세요.
		int[][] answer = new int[(int)Math.pow(2, n)-1][2];
    moveHanoi(n, 1, 2, 3);
		for(int i=0; i < hanoiAry.size(); i++) {
      int[] answerRow = hanoiAry.get(i);
      answer[i][0] = answerRow[0];
      answer[i][1] = answerRow[1];
    }
		return answer;
	}
  
  public void moveHanoi(int n, int from, int bridge, int to){
    int[] data = new int[2];
    if(n == 1) { //제일 작은 원판이 남은 경우
      data[0] = from;
      data[1] = to;
      hanoiAry.add(data);
    } else {
      moveHanoi(n-1, from, to, bridge); //n-1개의 원판을 bridge 원판으로 이동
      //n 원판을 from에서 to로 이동
      data[0] = from;
      data[1] = to;
      hanoiAry.add(data);
      //bridge에 있던 n-1개의 원판을 from으로 이동
      moveHanoi(n-1, bridge, from, to);
    }
  }

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		Hanoi h = new Hanoi();
		System.out.println(Arrays.toString(h.hanoi(2)));
	}
}
