class StringExercise {

    String getMiddle(String word) {
        int length = word.length();
        if (length == 0) return "";

        int mid = length/2;
        if (length % 2 == 0) {
            return word.substring(mid-1, mid+1);
        } else {
            return word.substring(mid, mid+1);
        }
    }

    public static void main(String[] args) {

        String testCase = "power";

        if (args.length >= 1) {
            testCase = args[0];
        }

        StringExercise se = new StringExercise();
        System.out.println(se.getMiddle(testCase));
    }
}