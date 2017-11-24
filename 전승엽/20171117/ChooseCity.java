import java.util.*;

class ChooseCity
{
    public long chooseCity(int n, int[][] city) {
      long answer = 0;
      long totalManCnt = 0;
      for(int i=0; i<city.length; i++) totalManCnt = city[i][1];
      totalManCnt /= 2;
      for(int i=0; i<city.length; i++) {
        totalManCnt -= city[i][1];
        if(totalManCnt <= 0) {
          answer = city[i][0];
          break;
        }
      }
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