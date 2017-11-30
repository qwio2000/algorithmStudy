import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LineCombination {
	public int[] setAlign(int n, long k) {
		int[] answer = new int[n];
		List<Integer> arr = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		for(int i=1;i<=n;i++) {
			arr.add(i);
		}
		long mod;
		int share, a=n;
		while(a>=0) {
			a--;
			mod = k% factorial(a);
			System.out.println("mod" + mod);
			share = (int)(k/factorial(a));
			if(mod==0) {
				share--;
				result.add(arr.get(share));
				arr.remove(share);
				break;
			}
			result.add(arr.get(share));
			arr.remove(share);
			k=mod;
		}
		for(int i=arr.size()-1;i>=0;i--) {
			result.add(arr.get(i));
			arr.remove(i);
		}
		for(int i=0; i<result.size();i++) {
			answer[i]=result.get(i);
		}
		
		return answer;
	}
	
	public long factorial(int num) { //팩토리얼 함수
		if(num>=1) {
			return num*factorial(num-1);
		}else{
			return 1;
		}
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		LineCombination lc = new LineCombination();
		System.out.println(Arrays.toString(lc.setAlign(3, 5)));
	}
}
