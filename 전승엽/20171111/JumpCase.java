class JumpCase {

    public int jumpCase(int num) {
      //4칸 뛸때 = 3칸 뛰는 방법 + 1칸 or 2칸뛰는 방법 + 2칸
        int answer = 0;
				if (num < 2) {
         	answer = 1; 
        } else {
          answer = jumpCase(num - 2) + jumpCase(num - 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        JumpCase c = new JumpCase();
        int testCase = 4;
        //아래는 테스트로 출력해 보기 위한 코드입니다.
        System.out.println(c.jumpCase(testCase));
    }
}