public class GetMinMaxString {
    public String getMinMaxString(String str) {
      String[] splitAry = str.split(" ");
      int maxVal = Integer.parseInt(splitAry[0]);
      int minVal = Integer.parseInt(splitAry[0]);
      for (int i=1; i < splitAry.length; i++) {
        int temp = Integer.parseInt(splitAry[i]);
       	if(maxVal < temp) maxVal = temp;
        if(minVal > temp) minVal = temp;
      }
        return String.format("%d %d", minVal, maxVal);
    }

    public static void main(String[] args) {
        String str = "1 2 3 4";
        GetMinMaxString minMax = new GetMinMaxString();
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println("최대값과 최소값은?" + minMax.getMinMaxString(str));
    }
}