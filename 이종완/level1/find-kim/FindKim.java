import java.util.Arrays;
import java.util.List;

public class FindKim {
    public String findKim(String[] seoul) {
        int length = seoul.length;
        int kimIndex = -1;
        for (int i = 0; i < length; i++) {
            if (seoul[i].equals("Kim")) {
                kimIndex = i;
                break;
            }
        }

        if (kimIndex != -1) {
            return "김서방은 " + kimIndex + "에 있다";
        } else {
            return "김서방은 없다";
        }
    }

    public static void main(String[] args) {

        String[] names = args;

        FindKim kim = new FindKim();
        long start = System.currentTimeMillis();
        String result = kim.findKim(names);
        long end = System.currentTimeMillis();

        System.out.println("=============================");
        System.out.println(result);
        System.out.println("elapsed time: " + (end - start)  + " ms");
    }
}