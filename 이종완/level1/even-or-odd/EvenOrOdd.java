import java.util.stream.Stream;
import static java.util.stream.Collectors.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class EvenOrOdd {
    String evenOrOdd(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }

    public static void main(String[] args) {

        List<Integer> numbers = Stream.of(args)
            .map(str -> {
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    return null;
                }
            })
            .filter(n -> n != null)
            .collect(toList());

        String str = "1 2 3 4";
        EvenOrOdd evenOrOdd = new EvenOrOdd();
        // 아래는 테스트로 출력해 보기 위한 코드입니다.
        numbers.forEach(number -> {
            System.out.println("문제: " + number + " / 결과 : " + evenOrOdd.evenOrOdd(number));
        });
    }
}