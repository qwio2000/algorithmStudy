class Hopscotch {

    int hopscotch(int[][] board, int size) {
        int length = board.length;
        int maxScore = findMaxScore(board, size, 0);
        for (int i = 1; i < length; i++) {
            int score = findMaxScore(board, size, i);
            if (score > maxScore) {
                maxScore = score;
            }
        }
        return maxScore;
    }

    int findMaxScore(int[][] board, int size, int start) {
        System.out.printf("%d 부터 시작\n", start);
        int length = board.length;
        int previousIndex = -1;
        int nextIndex = -1;
        int firstMaxIndex = -1;
        int sum = 0;
        int i = start;
        do {
            if (i == ((start + length) - 1) % length) {
                nextIndex = firstMaxIndex;
            } 

            System.out.printf("%d줄: ", i);
            int[] row = board[i];
            boolean started = false;
            int max = -1;
            int maxIndex = -1;
            for (int j = 0; j < row.length; j++) {
                if (j != previousIndex && j != nextIndex) {
                    if (started == false) {
                        started = true;
                        max = row[j];
                        maxIndex = j;
                    } else  {
                        if (row[j] > max) {
                            max = row[j];
                            maxIndex = j;
                        }
                    }
                }
            }
            System.out.printf("index: %d, score: %d\n", maxIndex, max);
            sum += max;

            if (i == start) {
                firstMaxIndex = maxIndex;
            }
            if (i != length - 1) {
                previousIndex = maxIndex;
            } else {
                previousIndex = -1;
            }
            System.out.printf("firstMax: %d, previous: %d, next: %d\n", firstMaxIndex, previousIndex, nextIndex);

            i = (i + 1) % length;
        } while (i != start);
        System.out.printf("\n sum=%d\n\n", sum);
        return sum;
    }



    public static void main(String[] args) {
        Hopscotch c = new Hopscotch();
        //int[][] test = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
        int[][] test = { { 5, 3, 6, 13 }, { 5, 9, 13, 15 }, { 3, 2, 5, 1 }, { 8, 7, 3, 5 } };
        System.out.println(c.hopscotch(test, 3));
    }
}
