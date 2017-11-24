import java.util.Arrays;

public class BestSet {

    public int[] bestSet(int n, int s) {

        int quotient = s / n;

        if (quotient <= 0) {
            return new int[] {-1};
        }

        int[] answer = new int[n];

        int remainder = s % n;

        for (int i = 0; i < n - remainder; i++) {
            answer[i] = quotient;
        }
        for (int i = n - remainder; i < n; i++) {
            answer[i] = quotient + 1;
        }

        return answer;
    }
    
    public static void main(String[] args) {
        BestSet c = new BestSet();
        System.out.println(Arrays.toString(c.bestSet(3, 13)));
    }
}
