import java.util.Arrays;

class Hanoi {
    public int[][] hanoi(int n) {
        int totalCount = (int)Math.pow(2, n) - 1;
        System.out.println("TotalCount is " + totalCount);
        int[][] moves = new int[totalCount][2];
        System.out.println("moves.length is " + moves.length);
        move(moves, 0, 1, 2, 3, n);
        return moves;
    }

    int move(int[][] moves, int index, int from, int via, int to, int number) {
        if (number == 1) {
            moves[index++] = new int[] {from, to};
            return index;
        } else {
            index = move(moves, index, from, to, via, number-1);
            moves[index++] = new int[] {from, to};
            index = move(moves, index, via, from, to, number-1);
            return index;
        }
    }

    void printMoves(int[][] moves) {
        System.out.print("[");
        for (int i = 0; i < moves.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(Arrays.toString(moves[i]));
        } 
        System.out.println("]");
    }

    public static void main(String[] args) {
        Hanoi h = new Hanoi();
        int numberOfDisk = 2;
        //System.out.println(Arrays.toString(h.hanoi(numberOfDisk)));
        h.printMoves(h.hanoi(numberOfDisk));
    }
}
