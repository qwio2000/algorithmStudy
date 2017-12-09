import java.util.*;

class LineCombination {
	public int[] setAlign(int n, long k) {
		int[] answer = new int[n];
    ArrayList<Integer> peoples = new ArrayList<>();
    ArrayList<Integer> result = new ArrayList<>();
    for(int i = 1; i <= n; i++) peoples.add(i);
    while(n > 0) {
        --n;
      	long factorialVal = getFactorial(n);
        long mod = k % factorialVal;
        int divide = (int)(k / factorialVal);
      	//나머지가 0이라는 건 divide - 1의 경우의 수 중 가장 큰 경우
      	//하위 경우의 수 중 가장 큰 경우의 수 찾도록
        if (mod == 0) {
            result.add(peoples.remove(--divide));
            break;
        }
        result.add(peoples.remove(divide));
        k = mod;
    }

    for(int i = peoples.size()-1; i >= 0; i--) result.add(peoples.remove(i));
    for(int i = 0; i < result.size(); i++) answer[i] = result.get(i);
    
    return answer;
	}

  public static int getFactorial(long num){
        int result = 1;
        for(long i = num; i > 0; i--) result *= i;
        return result;
  }
  
	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		LineCombination lc = new LineCombination();
		System.out.println(Arrays.toString(lc.setAlign(3, 5)));
	}
}
