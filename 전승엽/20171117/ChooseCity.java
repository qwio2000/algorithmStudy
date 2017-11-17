import java.util.*;

class ChooseCity
{
    public long chooseCity(int n, int[][] city) {
      long answer = 0;
      long[][] distanceCalAry = new long[n][2];

      for (int i = 0; i < city.length; i++) {
        long distance = 0;
        for (int j = 0; j < city.length; j++) {
          if (i == j) continue;
          distance += Math.abs(city[i][0] - city[j][0]) * city[j][1];
        }
        distanceCalAry[i][0] = city[i][0];
        distanceCalAry[i][1] = distance;
      }

      ArrayList<Long> answers = new ArrayList<Long>();
      long minVal = distanceCalAry[0][1];
      for (int i = 1; i < distanceCalAry.length; i++) {
        minVal = Math.min(minVal, distanceCalAry[i][1]);
      }
      for (int i = 0; i < distanceCalAry.length; i++) {
        if (distanceCalAry[i][1] == minVal) answers.add(distanceCalAry[i][0]);
      }
      Collections.sort(answers);
      answer = answers.get(0);
      return answer;
    }

    public static void main(String[] args)
    {
        ChooseCity test = new ChooseCity();
        int tn = 3;
        int [][]tcity = {{1,5},{2,2},{3,3}};
        System.out.println(test.chooseCity(tn,tcity));
    }
}