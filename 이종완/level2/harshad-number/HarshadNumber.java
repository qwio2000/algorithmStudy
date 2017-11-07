public class HarshadNumber {

    public boolean isHarshad(int num) {
        int sumOfDigit = 0;
        int quotient = num;
        while (quotient > 0) {
            sumOfDigit += quotient % 10;
            quotient /= 10;
        }

        return num % sumOfDigit == 0;
    }

    // 아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String[] args) {
        HarshadNumber sn = new HarshadNumber();
        System.out.println(sn.isHarshad(18));
    }
}