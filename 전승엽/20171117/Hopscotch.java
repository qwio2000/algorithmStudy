class Hopscotch {
    int hopscotch(int[][] board, int size) {
        int result = 0;
    		//계산 저장용
      	int[][] answerArray = new int[size][4];
				for (int i = 0; i < 4; i++) answerArray[0][i] = board[0][i];
        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < 4; j++) {
                int maxValue = 0;
              	//윗 행의 다른 열 값과 현재 행 값 더한 값 vs maxValue 비교
                for (int k = 0; k < 4; k++) {
                    if (j == k) continue;
                    maxValue = Math.max(maxValue, answerArray[i-1][k] + board[i][j]);
                }
                answerArray[i][j] = maxValue;
            }
        }
        for (int i = 0; i < 4; i++) {
            result = Math.max(result, answerArray[answerArray.length - 1][i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Hopscotch c = new Hopscotch();
        int[][] test = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(c.hopscotch(test, 3));
    }

}