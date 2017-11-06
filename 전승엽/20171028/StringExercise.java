class StringExercise{
    String getMiddle(String word){
      String result = "";
			int length = word.length();
      if (length % 2 == 0) {
        result = word.substring(length/2-1,length/2+1);
      } else {
        result = word.substring(length/2,length/2+1);
      }
    	return result;    
    }
    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void  main(String[] args){
        StringExercise se = new StringExercise();
        System.out.println(se.getMiddle("testtest"));
    }
}