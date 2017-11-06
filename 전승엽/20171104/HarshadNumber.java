public class HarshadNumber{
	public boolean isHarshad(int num){
    int digitSum = 0;
		String numStr = String.valueOf(num);
    for(int i=0; i<numStr.length(); i++){
     digitSum += Integer.parseInt("" + numStr.charAt(i)); 
    }
    if(num % digitSum == 0) return true;
		return false;
	}
  
       // 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void  main(String[] args){
		HarshadNumber sn = new HarshadNumber();
		System.out.println(sn.isHarshad(18));
	}
}