class GetDayYearName
{
    public String getDayName(int a, int b)
    {
      	int year = 2016;
      	int totalDay = 0;
      	for(int i = 1; i<a; ++i){
        	totalDay += dayOfMonth(year, i); 
        }
      	totalDay += b;
        int dayOfweek = totalDay % 7;
      	String weekName = "";
      	switch(dayOfweek){
          case 0	:
            weekName = "THU";
            break;
          case 1	:
            weekName = "FRI";
            break;
          case 2	:
            weekName = "SAT";
            break;
          case 3	:
            weekName = "SUN";
            break;
          case 4	:
            weekName = "MON";
            break;
          case 5	:
            weekName = "TUE";
            break;
          case 6	:
            weekName = "WED";
            break;
        }

        return weekName;
    }
           
    public int dayOfMonth(int year, int month){
      	boolean isLeapYear = ((year % 4 == 0) && (year %100 != 0)) || ((year %100 == 0) && (year %400 == 0));
      	boolean isThirtyOne = (month == 1) || (month == 3) || (month == 5) || (month == 7) || (month == 8) || (month == 10) || (month == 12);
      	int date = 0;	
      
      	if(isLeapYear && (month == 2)){
        	date = 29;
        }else if((!isLeapYear) && (month==2)){
          date = 28;
        }else if(isThirtyOne){
        	date = 31;
        }else if(!isThirtyOne){
        	date = 30;
        }
      	return date;
    }
           
    public static void main(String[] args)
    {
        GetDayYearName test = new GetDayYearName();
        int a=5, b=24;
        System.out.println(test.getDayName(a,b));
    }
}