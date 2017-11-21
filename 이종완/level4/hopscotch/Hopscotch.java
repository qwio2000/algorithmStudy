class Hopscotch {

    int hopscotch(int[][] board, int size) {
        int[][] selection = new int[board.length][board[0].length];


        return 0;
    }

    int getMaxIndex(int[] row, int[] excludeIndexes) {
        int max = -1;
        int maxIndex = -1;
        boolean isBeginning = true;
        for (int i = 0; i < row.length; i++) {
            boolean excluded = false;
            for (int j = 0; j < excludeIndexes.length; j++) {
                if (i == excludeIndexes[j]) {
                    excluded = true;
                    break;
                }
            }
            if (excluded) {
                break;
            }

            if (isBeginning) {
                max = row[i];
                maxIndex = i;
                isBeginning = false;
            } else if (row[i] > max) {
                max = row[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    void makeSelection(int[] row, int index) {
        int value = row[index];
        for (int i = 0; i < row.length; i++) {
            row[i] -= value;
        }
    }

    int getCase(int[][] selection, int index, int score) {


    } 

    public static void main(String[] args) {
        Hopscotch c = new Hopscotch();
        //int[][] test = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
        int[][] test = { { 5, 3, 6, 13 }, { 5, 9, 13, 15 }, { 3, 2, 5, 1 }, { 8, 7, 3, 5 } };
        System.out.println(c.hopscotch(test, 3));
    }
}
