public class WaterMelon {
    public String watermelon(int n) {

        String pattern = "수박";
        int length = pattern.length();

        String result = "";
        for (int i = 0; i < n; i++) {
            result += pattern.charAt(i % length);
        }

        return result;
    }

    // 실행을 위한 테스트코드입니다.
    public static void main(String[] args) {
        WaterMelon wm = new WaterMelon();
        int number = 2;

        if (args.length >= 1) {
            try {
                number = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) { }
        }

        System.out.println("n이 " + number +"인 경우:\n" + wm.watermelon(number));
    }
}