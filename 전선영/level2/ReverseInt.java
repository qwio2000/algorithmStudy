public class ReverseInt {
	public int reverseInt(int n){
		String num = n+"";
    char[] arr = num.toCharArray();
    char temp;
    int result = 0;
    for(int i = 0; i<arr.length-1; ++i){
    	for(int j = 1; j<arr.length - i; ++j){
      	if(arr[j] > arr[j-1]){
        	temp = arr[j-1];
          arr[j-1] = arr[j];
          arr[j] = temp;
        }
      }
    }    
    for(int k = 0; k<arr.length; ++k){
      if(arr[k] >= '0' && arr[k] <='9'){ 
    		result = (result*10) + arr[k] - '0';
      }
    }
		return result;
	}
  
	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void  main(String[] args){
		ReverseInt ri = new ReverseInt();
		System.out.println(ri.reverseInt(118372));
	}
}