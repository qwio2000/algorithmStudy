public class WaterMelon {
	public String watermelon(int n){
		String first = "수";
    String second = "박";
    String result = "";
    for(int i = 0; i<n; ++i){
    	if((i & 1) != 0){
        result += second;
      }else{
        result += first;
      }
    }
    
    return result;
    
	}

	// 실행을 위한 테스트코드입니다.
	public static void  main(String[] args){
		WaterMelon wm = new WaterMelon();
		System.out.println("n이 3인 경우: " + wm.watermelon(3));
		System.out.println("n이 4인 경우: " + wm.watermelon(4));
	}
}