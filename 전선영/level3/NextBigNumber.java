class NextBigNumber
{
    public int nextBigNumber(int n)
    {
        int answer = 0;
      	int oneCount = 0;
      	int count = 0;
      	boolean isStop = false;
      
				oneCount = countNumber(n);
      	
        while(!isStop){
        n = n + 1;
        count = countNumber(n);
      	if(oneCount == count){
        	isStop = true;
          answer = n;
        }
      }
      return answer;
    }
      
      
  	public int countNumber(int num){
      int tempNum = 0;
      int mod = num;
      int oneCount = 0;
      while(mod>1){
        	tempNum = mod % 2;
          mod = mod/2;          
          if(tempNum == 1){
            oneCount++;
          }
          if(mod == 1){
          	oneCount++;
          }
        }
      return oneCount;
    }
  
  
    public static void main(String[] args)
    {
        NextBigNumber test = new NextBigNumber();
        int n = 78;
        System.out.println(test.nextBigNumber(n));
    }
}