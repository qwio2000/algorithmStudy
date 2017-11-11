import java.util.stream.Stream;
import java.util.Arrays;

class NoOvertime {
    public int noOvertime1(int no, int[] works) {
        int length = works.length;
        for (int hour = no; hour > 0; hour--) {
            int maxIndex = 0;
            for (int i = 1; i < length; i++) {
                if (works[i] > works[maxIndex]) {
                    maxIndex = i;
                }
            }
            if (works[maxIndex] > 0) {
                works[maxIndex]--;
            } else {
                break;
            }
        }
        int overtimeIndex = 0;
        for (int i = 0; i < length; i++) {
            overtimeIndex += works[i] * works[i];
        }
        return overtimeIndex;
    }

    public int noOvertime(int no, int[] works) {
        int length = works.length;
        insertionSort(works);

        int hours = no;
        int maxCount = 0;
        for (int i = 0; i < length && hours > 0; i++) {
            maxCount++;
            int target;
            if (i < length - 1) {
                target = works[i + 1];
            } else {
                target = 0;
            }
            int difference = works[i] - target;
            int remainDifference = 0;
            if (difference * maxCount > hours) {
                remainDifference = hours % maxCount;
                difference = hours / maxCount;
            }

            for (int j = 0; j < maxCount; j++) {
                works[j] -= difference;
                hours -= difference;
                if (j < remainDifference) {
                    works[j]--;
                    hours--;
                }
            }
        }

        int overtimeIndex = 0;
        for (int i = 0; i < length; i++) {
            overtimeIndex += works[i] * works[i];
        }
        return overtimeIndex;
    }

    void insertionSort(int[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int tmp;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    tmp = array[j];
                    array[j] = array[i];
                    array[i] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        NoOvertime c = new NoOvertime();
        int remainingHours = 4;
        int[] works = {4, 3, 3};
        if (args.length >= 1) {
            try {
                remainingHours = Integer.parseInt(args[0]);
            } catch (NumberFormatException e) { }
        }
        if (args.length >= 2) {
            int[] parsed = Stream.of(args)
                           .skip(1)
            .map(str -> {
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException e) {
                    return null;
                }
            })
            .filter(n -> n != null)
            .mapToInt(Integer::intValue)
            .toArray();

            if (parsed.length > 0) {
                works = parsed;
            }
        }
        System.out.println("Works: " + Arrays.toString(works));
        System.out.println("Remaining Hours: " + remainingHours);
        int result = c.noOvertime(remainingHours, works);
        System.out.println("After: " + Arrays.toString(works));
        System.out.println(result);

    }
}