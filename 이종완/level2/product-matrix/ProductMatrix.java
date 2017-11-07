class ProductMatrix {
    public int[][] productMatrix(int[][] A, int[][] B) {
        int aRowLength = A.length;
        if (aRowLength == 0) return null;
        int aColumnLength = A[0].length;
        if (aColumnLength == 0) return null;
        if (aColumnLength != B.length) return null;
        int bColumnLength = B[0].length;
        if (bColumnLength == 0) return null;

        int[][] answer = new int[aRowLength][bColumnLength];
        for (int i = 0; i < aRowLength; i++) {
            for (int j = 0; j < bColumnLength; j++) {
                int element = 0;
                for (int k = 0; k < aColumnLength; k++) {
                    element += A[i][k] * B[k][j];
                }
                answer[i][j] = element;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        ProductMatrix c = new ProductMatrix();
        int[][] a = { { 1, 2 }, { 2, 3 } };
        int[][] b = { { 3, 4 }, { 5, 6 } };

        System.out.println("행렬의 곱셈: " + c.productMatrix(a, b));
    }

}