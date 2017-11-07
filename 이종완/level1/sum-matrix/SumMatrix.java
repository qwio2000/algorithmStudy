class SumMatrix {

    int[][] sumMatrix(int[][] A, int[][] B) {
        if (A.length == 0) return null;

        int rowLength = A.length;
        int columnLength = A[0].length;

        if (B.length != rowLength) return null;
        for (int i=0; i < rowLength; i++) {
            if (A[i].length != columnLength || B[i].length != columnLength) {
                return null;
            }
        }

        int[][] result = new int[rowLength][columnLength];

        for (int i=0; i < rowLength; i++) {
            for (int j=0; j < columnLength; j++) {
                result[i][j] = A[i][j] + B[i][j];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SumMatrix c = new SumMatrix();
        int[][] A = { { 1, 2 }, { 2, 3 } };
        int[][] B = { { 3, 4 }, { 5, 6 } };
        int[][] answer = c.sumMatrix(A, B);
        if (answer[0][0] == 4 && answer[0][1] == 6 && answer[1][0] == 7 && answer[1][1] == 9) {
            System.out.println("맞았습니다. 제출을 눌러보세요");
        } else {
            System.out.println("틀렸습니다. 수정하는 게 좋겠어요");
        }
    }
}