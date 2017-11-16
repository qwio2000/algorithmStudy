import java.util.Arrays;

class Getgcdlcm {
    public int[] gcdlcm(int a, int b) {
      int[] answer = new int[2];
			int num = 2;
      int maxInt = 1;
      while((num <= a) && (num <= b)){
       	if((a%num == 0) && (b%num == 0)){
        		maxInt = maxInt * num;
            a = a / num;
            b = b / num;
       	}else{
         	num++;
        }
       }
      	answer[0] = maxInt;
      	answer[1] = maxInt * a * b;
      	
      return answer;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        Getgcdlcm c = new Getgcdlcm();
        System.out.println(Arrays.toString(c.gcdlcm(3, 12)));
    }
}
