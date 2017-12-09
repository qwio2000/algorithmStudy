class EatCookie {
    public int eatCookie(int[] cookies) {
        int length = cookies.length;
        int[] cases = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            int max = 0;
            int score = cookies[i];
            for (int j = i + 1; j < length; j++) {
                if (cookies[j] > score) {
                    if (cases[j] > max) {
                        max = cases[j];
                    }
                }
            }
            cases[i] = max + 1;
        }

        int answer = 0;
        for (int i = 0; i < length; i++) {
            if (cases[i] > answer) {
                answer = cases[i];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        EatCookie e = new EatCookie();
        int[] cookies = {1, 4, 2, 6, 3, 4, 1, 5};
        System.out.println(e.eatCookie(cookies));

    }
}

