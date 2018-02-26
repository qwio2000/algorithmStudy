public class PostfixTest {
    public static void main(String[] args) {
        String expression = "(3+2)*50-52/2+3*(8-1)"; 

        if (args.length >= 1) {
            expression = args[0];
        }

        System.out.println(expression);

        InfixToPostfixConverter converter = new InfixToPostfixConverter(expression);
        LinkedList postfixList = converter.convert();

        System.out.println(postfixList);
        for (Object data : postfixList) {
            System.out.printf("%s ", data);
        }
        System.out.println();

        System.out.printf("Result: [%f]\n", PostfixCalculator.calculate(postfixList));
    }

}
