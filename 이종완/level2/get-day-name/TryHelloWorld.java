class TryHelloWorld {

    public String getDayName(int a, int b) {
        String[] dayNames = {
            "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"
        };

        int[] months = {
            31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        int gap = 0;

        for (int i = 1; i < a; i++) {
            gap += months[i-1];
        }
        gap += b - 1;
        gap %= 7;

        return dayNames[(5+gap)%7];
    }


    public static void main(String[] args) {

        int month = 5;
        int day = 24;

        if (args.length >= 2) {
            try {
                month = Integer.parseInt(args[0]);
                day = Integer.parseInt(args[1]);
            } catch(NumberFormatException e) { }
        }

        TryHelloWorld test = new TryHelloWorld(); 
        System.out.println(test.getDayName(month, day));
    }

}