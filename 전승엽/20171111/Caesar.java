class Caesar {
    String caesar(String s, int n) {
        String result = "";
        // 함수를 완성하세요.
        char[] splitChars = s.toCharArray();
        for (int i = 0; i < splitChars.length; i++) {
            char minChar = '\0', maxChar = '\0';
            if (splitChars[i] != ' ') {
                if (splitChars[i] >= 'A' && splitChars[i] <= 'Z') { // 대문자
                    minChar = 'A';
                    maxChar = 'Z';
                } else if (splitChars[i] >= 'a' && splitChars[i] <= 'z') { // 소문자
                    minChar = 'a';
                    maxChar = 'z';
                }
                splitChars[i] += n;
                if (splitChars[i] > maxChar) {
                    int idx = (int) (splitChars[i] - minChar) % 26;
                    splitChars[i] = (char) (minChar + idx);
                }
            }
        }
        result = String.valueOf(splitChars);
        return result;
    }

    public static void main(String[] args) {
        Caesar c = new Caesar();
        System.out.println("s는 'a B z', n은 4인 경우: " + c.caesar("a B z", 4));
    }
}