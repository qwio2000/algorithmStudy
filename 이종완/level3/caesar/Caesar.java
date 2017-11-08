class Caesar {
    String caesar(String s, int n) {
        String result = "";
        int length = s.length();
            
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                c = (char)((c - 'a' + n) % 26 + 'a');
            } else if (c >= 'A' && c <= 'Z') {
                c = (char)((c - 'A' + n) % 26 + 'A');
            }
            result += c;
        }
        
        return result;
    }

    public static void main(String[] args) {
        String testCase = "a B z";
        int testShiftNumber = 4;

        if (args.length >= 2) {
            testCase = args[0];
            try {
                testShiftNumber = Integer.parseInt(args[1]);
            } catch (NumberFormatException e) { }
        }
        
        Caesar c = new Caesar();
        String result = c.caesar(testCase, testShiftNumber);
        System.out.println("s는 '" + testCase + "', n은 " + testShiftNumber + "인 경우: " + result);
    }
}
