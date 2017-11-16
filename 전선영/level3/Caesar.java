class Caesar {
	String caesar(String s, int n) {
		String result = "";
		char[] upperArr = new char[26];
    char[] lowArr = new char[26];
    String[] arr = s.split("");
    int temp;
    char ch;
		for(int i = 65; i<upperArr.length + 65; ++i){
    	upperArr[i-65] = (char)i;			// 대문자배열
      lowArr[i-65] = (char)(i + 32);		//소문자배열
    }
    
    for(int j = 0; j<arr.length; ++j){
    	ch = (char)arr[j].charAt(0);
      if(n > 26){
      	n = n % 26;
      }
      if(ch>64 && ch < 91){		// 대문자
        temp = (arr[j].charAt(0) + n);
        if(temp > 90){
        	temp = temp - 26;
        }
        ch = (char)upperArr[temp-65];
      }else if(ch > 96 && ch <123){		//소문자
        temp = (arr[j].charAt(0) + n);
        if(temp > 122){
        	temp = temp - 26;
        }
        ch = (char)lowArr[temp-97];
      }
      result += ch;
    } 
		return result;
	}

	public static void main(String[] args) {
		Caesar c = new Caesar();
		System.out.println("s는 'a B z', n은 4인 경우: " + c.caesar("a B z", 4));
	}
}
