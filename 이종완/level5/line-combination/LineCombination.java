import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

class LineCombination {
	public int[] setAlign(int n, long k) {
		int[] answer = new int[n];
		List<Integer> list = IntStream
			.rangeClosed(1, n)
			.boxed()
			.collect(Collectors.toList());
		list = new ArrayList<>(list);

		long groupNumber = 1;
		for (int i = 1; i <= n; i++) {
			groupNumber *= i;
		}

		int count = n;

		for (int i = 0; i < n; i++) {
			groupNumber /= n-i;
			int index = (int) ((k - 1) / groupNumber);
			k = k - index * groupNumber;
			answer[i] = list.remove(index);
		}

		return answer;
	}

	public static void main(String[] args) {
		LineCombination lc = new LineCombination();
		System.out.println(Arrays.toString(lc.setAlign(3, 5)));
	}
}