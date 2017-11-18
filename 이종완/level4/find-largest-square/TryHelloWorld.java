import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class TryHelloWorld {

    public static String toArrayString(char[][] array) {
        String result = "";
        result += Stream.of(array)
            .map(s -> Arrays.toString(s))
            .collect(Collectors.joining("\n"));
        result += "\n";

        return result;
    }

    public int findLargestSquare(char[][] board) {
        System.out.println(toArrayString(board));
        int length = board.length;
        int longestSide = 0;
        char[][] findBoard = new char[length][];
        for (int i = 0; i < length; i++) {
            char[] currentRow = board[i];
            System.out.printf("i: %d - %s\n", i, Arrays.toString(currentRow));
            for (int j = 0; j <= i; j++) {
                System.out.printf(" j: %d - ", j);
                char[] accumulateRow = findBoard[j];
                findBoard[j] = accumulate(accumulateRow, currentRow);
                System.out.println(Arrays.toString(findBoard[j]));
                int rowCount = i;
                int columnCount = countMaxContinuousO(findBoard[j]);
                int squareSide = rowCount > columnCount ? columnCount : rowCount;
                if (squareSide > longestSide) {
                    longestSide = squareSide;
                }
            }
            System.out.println("\n");
        }
        return longestSide * longestSide;
    }

    int countMaxContinuousO(char[] row) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < row.length; i++) {
            if (row[i] == 'O') {
                count++;
            } else {
                if (count > result) {
                    result = count;
                }
                count = 0;
            }
        }
        if (count > result) {
            result = count;
        }
        return result;
    }

    char[] accumulate(char[] base, char[] newRow) {
        int length = newRow.length;
        if (base == null) {
            base = new char[length];
            for (int i = 0; i < length; i++) {
                base[i] = newRow[i];
            }
            return base;
        }

        if (length != base.length) {
            return base;
        }

        for (int i = 0; i < length; i++) {
            if (base[i] == 'O' && newRow[i] == 'O') {
                base[i] = 'O';
            } else {
                base[i] = 'X';
            }
        }
        return base;
    }

    public static void main(String[] args) {
        TryHelloWorld test = new TryHelloWorld();
        char[][] board = {
            {'X', 'O', 'O', 'O', 'X'},
            {'X', 'O', 'O', 'O', 'O'},
            {'X', 'X', 'O', 'O', 'O'},
            {'X', 'O', 'O', 'O', 'O'},
            {'X', 'X', 'X', 'X', 'X'}
        };

        System.out.println(test.findLargestSquare(board));
    }
}