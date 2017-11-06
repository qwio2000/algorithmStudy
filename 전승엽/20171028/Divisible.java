import java.util.*;

class Divisible {
	public int[] divisible(int[] array, int divisor) {
    int cnt = 0;
    ArrayList<Integer> list = new ArrayList<Integer>();
    for (int i=0; i < array.length; i++) {
     	if (array[i] % divisor == 0) {
        cnt++;
      	list.add(array[i]);
      }
    }
		int[] ret = new int[cnt];
    for (int j=0; j< list.size(); j++) {
     	ret[j] = list.get(j); 
    }
		return ret;
	}
	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		Divisible div = new Divisible();
		int[] array = {5, 9, 7, 10};
		System.out.println( Arrays.toString( div.divisible(array, 5) ));
	}
}