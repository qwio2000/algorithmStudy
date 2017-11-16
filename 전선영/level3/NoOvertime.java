import java.util.Arrays;

class NoOvertime {
	public int noOvertime(int no, int[] works) {
		int result = 0;
		int count = 0;
    while(count < no){
    	Arrays.sort(works);
      works[works.length-1] = works[works.length-1] - 1;
      ++count;
    }
    
    for(int i = 0; i<works.length; ++i){
    	result += works[i] * works[i];
    }
		return result;
	}
	public static void main(String[] args) {
		NoOvertime c = new NoOvertime();
		int []test = {4,3,3};
		System.out.println(c.noOvertime(4,test));
	}
}
