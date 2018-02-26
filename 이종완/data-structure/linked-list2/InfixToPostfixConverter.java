public class InfixToPostfixConverter {

    private final LinkedList infixList;

    public InfixToPostfixConverter(String expression) {
        infixList = getListFromStringExpression(expression);
    }

    private LinkedList getListFromStringExpression(String expression) {
        LinkedList infixList = new LinkedList();

        StringBuffer number = new StringBuffer();
        int length = expression.length();
        for (int i = 0; i < length; i++) {
            String c = String.valueOf(expression.charAt(i));

            if (isDataNumber(c)) {
                number.append(c);
            } else {
                if (number.length() > 0) {
                    infixList.addLast(number.toString());
                    number.setLength(0);
                }
                infixList.addLast(c);
            }
        }

        return infixList;
    }

    private boolean isDataNumber(String data) {
        int length = data.length();
        for (int i = 0; i < length; i++) {
            char c = data.charAt(i);
            if (!(c >= '0' && c <= '9')) {
                return false;
            }
        }
        return true;
    }

    private boolean isDataOperator(String data) {
        return "+-*/".contains(data);
    }

    private int compareOperatorPrecedence(String anOperator, String otherOperator) {
        String operators = "+-*/";
        return operators.indexOf(anOperator.charAt(0))/2 - operators.indexOf(otherOperator.charAt(0))/2;
    }

    private boolean isDataOpenParenthesis(String data) {
        return "(".equals(data);
    }

    private boolean isDataCloseParenthesis(String data) {
        return ")".equals(data);
    }

    public LinkedList convert() {
        Stack stack = new Stack();
        LinkedList postfixList = new LinkedList();

        for (Object data: infixList) {
            if (isDataNumber((String)data)) {
                postfixList.addLast(data);
            } else if (isDataOperator((String)data)) {
                while (!(stack.isEmpty() || stack.peek().equals("(") || compareOperatorPrecedence((String)data, (String)stack.peek()) > 0)) {
                    postfixList.addLast(stack.pop()); 
                }
                stack.push(data);
            } else if (isDataOpenParenthesis((String)data)) {
                stack.push(data);
            } else if (isDataCloseParenthesis((String)data)) {
                while(!(stack.peek().equals("("))) {
                   postfixList.addLast(stack.pop()); 
                }
                stack.pop();
            }
        }

        while (!stack.isEmpty()) {
            postfixList.addLast(stack.pop());
        }

        return postfixList;
    }
}
