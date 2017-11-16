class StringExercise{
    String getMiddle(String word){
			String result = "";
    	int len = word.length();
    	int divide = len / 2;
    	if(len % 2 == 0){
    		result = word.substring(divide-1, divide+1);
    	}else{
    		result = word.substring(divide, divide+1);
    	}
    	 return result;    
     }
    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void  main(String[] args){
        StringExercise se = new StringExercise();
        System.out.println(se.getMiddle("power"));
    }
}