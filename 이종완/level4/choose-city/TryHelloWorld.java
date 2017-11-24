import java.util.Scanner;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.Map;
import java.util.HashMap;


class TryHelloWorld
{
    public Map<Integer, BiFunction<Integer, int[][], Long>> algorithms = new HashMap<>();

    public TryHelloWorld() {
        this.algorithms.put(0, this::chooseCity);
        this.algorithms.put(1, this::chooseCity1);
        this.algorithms.put(2, this::chooseCity2);
        this.algorithms.put(3, this::chooseCity3);
    }

    public long chooseCity3(int n, int[][] city)
    {
        int answer = 0;
        int[] cost = new int[n];

        for(int i = 1; i < n; i++) {
          for(int j = 0; j < i; j++) {
            long distance = Math.abs(city[i][0] - city[j][0]);
            cost[i] += city[j][1] * distance;
            cost[j] += city[i][1] * distance;
          }
        }

        int minCost = Integer.MAX_VALUE;
        int minIdx = 0;
        for(int i = 0; i < n; i++) {
          if(minCost > cost[i]) {
            minCost = cost[i];
            minIdx = i;
          }
        }


        return city[minIdx][0];
}

    // 다른 사람 풀이
    public long chooseCity2(int n , int[][] city) {
        int tmp = 0;
        int answer = 0;
        for(int i = 0; i<city.length; i++ ) {
            if(tmp <city[i][1]) {
                tmp = city[i][1];
                answer = i;
            }
        }
        return city[answer][0];
    }

    public long chooseCity1(int n, int [][]city) {
        city = Arrays.copyOf(city, city.length);
        Arrays.sort(city, (before, after) -> Integer.compare(before[0], after[0]));

        int selectedIndex = city.length-1;
        int increment = 0; 
        for (int i = 0; i < city.length; i++) {
            increment -= city[i][1];
        }

        for (int i = 0; i < city.length; i++) {
            increment += city[i][1] * 2;
            if (increment >= 0) {
                selectedIndex = i;
                break;
            }
        }

        return city[selectedIndex][0];
    }

    int getIncrement(int index, int[][] city) {
        int increment = 0;
        for (int i = 0; i < city.length; i++) {
            if (i <= index) {
                increment += city[i][1];
            } else {
                increment += -city[i][1];
            }
        }
        return increment;
    }

    public long chooseCity(int n, int [][]city) {
        System.out.println(toArrayString(city));
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
                //if (i > 0 && distance > minDistance) {
                    //break;
                //}
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

    public static String toArrayString(int[][] array) {
        String result = "[";
        result += Stream.of(array)
            .map(s -> Arrays.toString(s))
            .collect(Collectors.joining(", "));
        result += "]";

        return result;
    }

    public static void main(String[] args) {
        List<int[]> cityList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String input = null;
        int count = 0;
        while(true) {
            count++;
            //System.out.printf("도시 %d: ", count);
            input = scan.nextLine();
            if (input.equals("q")) {
                break;
            }
            cityList.add(getIntArrayFromInput(input));
        }
        System.out.println("\n");

        int numberOfAlgorithm = 0;
        BiFunction<Integer, int[][], Long> algorithm = null;

        if (args.length >= 1) {
            try {
                numberOfAlgorithm = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) {

            }
        }

        TryHelloWorld test = new TryHelloWorld();

        algorithm = test.algorithms.get(numberOfAlgorithm);
        if (algorithm == null) {
            numberOfAlgorithm = 0;
            algorithm = test.algorithms.get(numberOfAlgorithm);
        }

        int tn = 3;
        int [][] tcity = {{1, 5}, {2, 2}, {3, 3}};

        if (!cityList.isEmpty()) {
            tcity = cityList.toArray(new int[cityList.size()][]);
            tn = cityList.size();
        }

        long started = System.currentTimeMillis();
        long result = algorithm.apply(tn, tcity);
        long elapsed = System.currentTimeMillis() - started;

        System.out.println("=========================================");
        System.out.printf("문제: %d 개의 도시\n%s\n\n", tn, toArrayString(tcity)); 
        System.out.println("-----------------------------------------");
        System.out.println("방식: " + numberOfAlgorithm);
        System.out.printf("답안: %d\n", result);
        System.out.printf("elapsed time: %d ms\n\n", elapsed);
    }
}
