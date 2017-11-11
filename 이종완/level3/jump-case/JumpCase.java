import java.util.Arrays;

class JumpCase {

    String types = "-+";

    public int jumpCase(int num) {
        if (num == 0) {
            return 0;
        }
        int numberOfSpace = num - 1;
        char[] spaces = new char[numberOfSpace];
        int count = pick(spaces, 0, 0);
        return count;
    }

    int pick(char[] spaces, int index, int count) {
        if (index >= spaces.length) {
            // printCase(spaces);
            count++;
        } else if (index == 0) {
            for (int i = 0; i < types.length(); i++) {
                spaces[index] = types.charAt(i);
                count = pick(spaces, index + 1, count);
            }
        } else {
            if (spaces[index - 1] == types.charAt(0)) {
                for (int i = 0; i < types.length(); i++) {
                    spaces[index] = types.charAt(i);
                    count = pick(spaces, index + 1, count);
                }
            } else {
                spaces[index] = types.charAt(0);
                count = pick(spaces, index + 1, count);
            }
        }
        return count;
    }

    void printCase(char[] spaces) {

        int length = spaces.length;
        System.out.print("[");
        if (length == 0) {
            System.out.print(1);
        } else {
            for (int i = 0; i < length; i++) {
                if (i == 0) {
                    if (spaces[i] == types.charAt(0)) {
                        System.out.print(1);
                    } else {
                        System.out.print(2);
                    }
                } else {
                    char before = spaces[i - 1];
                    if (spaces[i] == types.charAt(1)) {
                        System.out.print(", ");
                        System.out.print(2);
                    } else if (before == types.charAt(0)) {
                        System.out.print(", ");
                        System.out.print(1);
                    }
                }

                if (i == length - 1) {
                    if (spaces[i] == types.charAt(0)) {
                        System.out.print(", ");
                        System.out.print(1);
                    }
                }
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        JumpCase c = new JumpCase();
        int testCase = 4;
        if (args.length >= 1) {
            try {
                testCase = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) { }
        }
        System.out.println(c.jumpCase(testCase));
    }

}