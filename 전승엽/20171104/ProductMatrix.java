class ProductMatrix {
	public int[][] productMatrix(int[][] A, int[][] B) {
    int[][] temp = null;
		if (A[0].length != B.length && A.length == B[0].length) {
			temp = A;
			A = B;
			B = temp;
		}
		int[][] answer = new int[A.length][B[0].length];
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < B[0].length; j++) {
				for (int k = 0; k < B.length; k++) {
					//System.out.println(String.format("answer[%d][%d] += A[%d][%d] * B[%d][%d]", i, j, i, k, k, j));
          //System.out.println(String.format("%d += %d * %d", answer[i][j], A[i][k], B[k][j]));
					answer[i][j] += A[i][k] * B[k][j];
					
				}
			}
		}
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[i].length; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println("");
		}
		return answer;
	}

	public static void main(String[] args) {
		ProductMatrix c = new ProductMatrix();
		//int[][] a = { { 1, 2, 3 }, { 2, 3, 4 } };
		//int[][] b = { { 3, 4 }, { 5, 6 }, {7, 8} };
    //int[][] a = { {1,2,3,4,5}, {6,7,8,9,10} };
    //int[][] b = { {7, 10}, {7,8}, {10,9}, {5,10} };
    int[][] a = { { 5, 10, 8 }, { 2, 2, 9 }, { 2, 3, 9 }, { 9, 4, 2 }, { 2, 9, 3 } };
		int[][] b = { { 10, 9, 8, 5, 4 }, { 5, 9, 9, 9, 3 }, { 10, 1, 8, 5, 3 } };
      // 아래는 테스트로 출력해 보기 위한 코드입니다.
      System.out.println("행렬의 곱셈 : " + c.productMatrix(a, b));
	}
}
