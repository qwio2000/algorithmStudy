public class StrToInt {
    public int getStrToInt(String str) {
      	int result = 0;
      	int redix = 10;
      	char[] a = str.toCharArray();
      	for(int i = 0; i<a.length; ++i){
          if(a[i] > '0' && a[i] < '9'){ 
        		result = (result * redix) +a[i] - '0';
          }          
        }
      	if(a[0] == '-'){
        	result = (-1)*result;
        }
        return result;
    }
    //아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String args[]) {
        StrToInt strToInt = new StrToInt();
        System.out.println(strToInt.getStrToInt("1234"));
    }
}
