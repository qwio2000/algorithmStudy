class NextBigNumber
{
    public int nextBigNumber(int n)
    {
        int oneCount = getOneCount(n);
        int targetOneCount = 0;
        do {
        	n++;
        	targetOneCount = getOneCount(n);
        } while(oneCount != targetOneCount);
        return n;
    }
    
    public int getOneCount(int n) {
    	int cnt = 0;
		//2진수 변환 직접 구현
    	//String binaryString = getBinaryString(n);
    	String binaryString = Integer.toBinaryString(n);
    	for(int i=0; i<binaryString.length(); i++) {
    		if(binaryString.charAt(i) == '1') cnt++;
    	}
    	return cnt;
    }
    
    public String getBinaryString(int n) {
    	StringBuffer sb = new StringBuffer();
    	while(true) {
    		if (n == 1) {
    			sb.append("1");
    			return sb.toString();
    		}
    		if (n % 2 == 0) sb.append("1");
    		else sb.append("0");
    		n /= 2;
    	}
    }
    public static void main(String[] args)
    {
    	NextBigNumber test = new NextBigNumber();
        int n = 78;
		System.out.println(test.nextBigNumber(n));
	}
}