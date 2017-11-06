class DayName
{
    public String getDayName(int a, int b)
    {
        String answer = "";
				String[] dayNames = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
      	int[] daysForMonth = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
      	int totalDayCount = 0;
      	for(int i=0; i<a-1; i++){
         	totalDayCount += daysForMonth[i]; 
        }
      	totalDayCount += b - 1;
      	answer = dayNames[totalDayCount % 7];
        return answer;
    }
    public static void main(String[] args)
    {
        DayName test = new DayName();
        int a=5, b=24;
        System.out.println(test.getDayName(a,b));
    }
}