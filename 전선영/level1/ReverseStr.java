public class ReverseStr {
	public String reverseStr(String str){
    char[] ch = str.toCharArray();
    int size = str.length();
    for(int i = 0; i<size-1; ++i){
     for(int j = 1; j<size-i; ++j){
      if(ch[j-1] < ch[j]){
        char tmp = ch[j-1];
        ch[j-1] = ch[j];
        ch[j] = tmp;
      }
     }
    }
   
		return new String(ch);
	}

	// 아래는 테스트로 출력해 보기 위한 코드입니다.
	public static void main(String[] args) {
		ReverseStr rs = new ReverseStr();
		System.out.println( rs.reverseStr("Zbcdefg") );
	}
}