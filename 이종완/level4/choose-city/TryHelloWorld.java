import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class TryHelloWorld
{
    public int chooseCity(int n, int [][]city) {
        int length = city.length;

        int selectedIndex = -1;
        int minDistance = -1;

        for(int i = 0; i < length; i++) {
            int location = city[i][0];
            int distance = 0;
            for (int j = 0; j < length; j++) {
                int d = city[i][0] - city[j][0];
                d = d < 0 ? -d : d;
                distance += d * city[j][1];
            }
            if (i == 0) {
                selectedIndex = i;
                minDistance = distance;
            } else if (distance < minDistance) {
                selectedIndex = i;
                minDistance = distance;
            } else if (distance == minDistance && city[i][0] < city[selectedIndex][0]) {
                selectedIndex = i;
                minDistance = distance;
            }
        }

        return city[selectedIndex][0];
    }

    static int[] getIntArrayFromInput(String input) {
        int[] cityInfo = new int[2];
        String[] inputs = input.split("\\s+", 2);
        for (int i = 0; i < inputs.length; i++) {
            try {
                cityInfo[i] = Integer.parseInt(inputs[i]);
            } catch (NumberFormatException e) {
                return null;
            }
        }
        return cityInfo;
    }

    public static void main(String[] args) {
        List<int[]> cityList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String input = null;
        int count = 0;
        while(true) {
            count++;
            System.out.printf("도시 %d: ", count);
            input = scan.nextLine();
            if (input.equals("q")) {
                break;
            }
            cityList.add(getIntArrayFromInput(input));
        }
        System.out.println("\n");

        int tn = 3;
        int [][] tcity = {{1, 5}, {2, 2}, {3, 3}};

        if (!cityList.isEmpty()) {
            tcity = cityList.toArray(new int[cityList.size()][]);
            tn = cityList.size();
        }

        TryHelloWorld test = new TryHelloWorld();
        long started = System.currentTimeMillis();
        int result = test.chooseCity(tn, tcity);
        long elapsed = System.currentTimeMillis() - started;

        System.out.printf("문제: %d개의 도시\n[%s]\n", tn,
                Stream.of(tcity)
                    .map(info -> Arrays.toString(info))
                    .collect(Collectors.joining(", "))); 
        System.out.printf("답안: %d\n", result);
        System.out.printf("elapsed time: %d ms\n\n", elapsed);
    }
}
