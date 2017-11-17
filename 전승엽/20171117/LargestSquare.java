class LargestSquare
{
    public int findLargestSquare(char [][]board)
    {
        int max = 0;
		int[][] answerArray = new int[board.length][board[0].length];
		for (int i = 0; i < answerArray.length; i++) {
			for (int j = 0; j < answerArray[i].length; j++) {
				answerArray[i][j] = (board[i][j] == 'O') ? 1 : 0;
			}
		}
		for (int i = 1; i < answerArray.length; i++) {
			for (int j = 1; j < answerArray[i].length; j++) {
				if(answerArray[i][j] == 1) {
					answerArray[i][j] = Math.min(Math.min(answerArray[i - 1][j - 1], answerArray[i][j - 1]),answerArray[i - 1][j]) + 1;
					if (max < answerArray[i][j])
						max = answerArray[i][j];
				}
			}
		}
		return (int) Math.pow(max, 2);
    }
    public static void main(String[] args)
    {
        LargestSquare test = new LargestSquare();
				char [][]board ={
				{'X','O','O','O','X'},
				{'X','O','O','O','O'},
				{'X','X','O','O','O'},
				{'X','X','O','O','O'},
				{'X','X','X','X','X'}};

        System.out.println(test.findLargestSquare(board));
    }
}