class NumOfPrime {
	int numberOfPrime(int n) {
		int result = 0;
    int count;
    for(int i = 2; i<=n; ++i){
      count = 0;
    	for(int j = 2; j<i; ++j){
        if(i%j == 0){
        	count += 1;
        }
      }
      if(count == 0){
          result += 1;
        }
    }

		return result;
	}

	public static void main(String[] args) {
		NumOfPrime prime = new NumOfPrime();
		System.out.println( prime.numberOfPrime(10) );
	}

}