class JumpCase {

    public int jumpCase(int num) {
        int answer = 0;
      	int first = 0;
      	int second = 1;
      	int temp = 0;
      	for(int i = 0; i<num; ++i){
        	answer = first + second;
          temp = second;
          first = temp;
          second = answer;
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