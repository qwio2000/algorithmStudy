class NoOvertime {
	public int noOvertime(int no, int[] works) {
		int result = 0;
		// 야근 지수를 최소화 하였을 때의 야근 지수는 몇일까요?
    for (int i=0; i<no; i++) {
      int maxValueIndex = getMaxValueIndex(works);
      works[maxValueIndex] -= 1;
    }
    for(int work:works){
     	result += work * work; 
    }
		return result;
	}
  public int getMaxValueIndex(int[] works) {
  	int idx = -1;
    int maxVal = -1;
    for(int i=0; i<works.length; i++) {
      if(maxVal < works[i]) {
        idx = i;
        maxVal = works[i];
      }
    }
    return idx;
  }
	public static void main(String[] args) {
		NoOvertime c = new NoOvertime();
		int []test = {4,3,3};
		System.out.println(c.noOvertime(4,test));
	}
}
