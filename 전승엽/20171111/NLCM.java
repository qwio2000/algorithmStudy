class NLCM {
	public long nlcm(int[] num) {
		long answer = 0;
		for (int i = 0; i < (num.length - 1); i++) {
			if (i == 0)
				answer = num[i];
			if (answer % num[i + 1] != 0)
				answer = getLCM(answer, num[i + 1]);
		}
		return answer;
	}

	public long getLCM(long a, long b) {
		long minNum = Math.min(a, b);
		long gcd = 1;
		for (int i = 2; i <= minNum; i++) {
			if (a % i == 0 && b % i == 0)
				gcd = i;
		}
		return a * b / gcd;
	}

	public static void main(String[] args) {
		NLCM c = new NLCM();
		int[] ex = { 2, 6, 8, 14 };
		// 아래는 테스트로 출력해 보기 위한 코드입니다.
		System.out.println(c.nlcm(ex));
	}
}