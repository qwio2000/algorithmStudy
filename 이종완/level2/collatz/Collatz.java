class Collatz {

    public int collatz(int num) {
        long longNum = num;
        int count = 0;
        System.out.print("\n" + longNum + " -> ");
        while (longNum != 1 && count < 500) {
            if (longNum % 2 == 0) {
                longNum /= 2;
            } else {
                longNum = longNum * 3 + 1;
            }
            System.out.print(longNum);
            if (longNum != 1) {
                System.out.print(" -> ");
            }
            count++;
        }
        System.out.println();

        return longNum == 1 ? count : -1;
    }

    public int collatz2(int num) {
        int count = 0;
        System.out.print("\n" + num + " -> ");
        while (num != 1 && count < 500) {
            if (num < 0) {
                num = num / 2 + 2_147_483_646 + 2;

            } else if (num % 2 == 0) {
                num /= 2;
            } else {
                num = num * 3 + 1;
            }
            System.out.print(num);
            if (num != 1) {
                System.out.print(" -> ");
            }
            count++;
        }
        System.out.println();

        return num == 1 ? count : -1;
    }

    public static void main(String[] args) {
        Collatz c = new Collatz();

        int testCase = 6;

        if (args.length >= 1) {
            try {
                testCase = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) { }
        }

        long start = System.currentTimeMillis();
        int result = c.collatz(testCase);
        long elapsed = System.currentTimeMillis() - start;

        System.out.println("==============================");
        System.out.println("Input: " + testCase);
        System.out.println("Collatz: " + result);
        System.out.println("elapsed time: " + elapsed + " ms");
    }
}