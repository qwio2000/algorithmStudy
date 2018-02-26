public class PostfixCalculator {
    
    private static boolean isElementNumber(String element) {
        int length = element.length();
        int numberOfPoint = 0;
        for (int i = 0; i < length; i++) {
            char c = element.charAt(i);
            if (c == '.') {
                numberOfPoint++;
                if (numberOfPoint > 1) {
                    return false;
                }
            } else if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }
    static double calculate(LinkedList postfixList) {
        Stack stack = new Stack();

        for (Object data : postfixList) {
            String element = (String)data;

            if (isElementNumber(element)) {
                stack.push(element);
            } else {
                double b = Double.parseDouble((String)stack.pop());
                double a = Double.parseDouble((String)stack.pop());

                double result;
                switch (element) {
                    case "+": 
                        result = a + b;
                        break;
                    case "-": 
                        result = a - b;
                        break;
                    case "*": 
                        result = a * b;
                        break;
                    case "/": 
                        result = a / b;
                        break;
                    default: result = 0;
                }
                stack.push(String.valueOf(result));
            }
        }

        return Double.parseDouble((String)stack.pop());
    }

}
