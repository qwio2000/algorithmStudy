package sortAlgorithm;

import java.util.*;

/**
 * 버킷정렬
 * 
 * 특징
 * 		- 비교정렬방식 알고리즘의 시간복잡도는 O(nlogn)
 * 		- O(nlogn) 의 시간복잡도를 O(n)으로 개선 목적
 * 		- 데이터가 특정 범위 내에 확률적으로 균등하게 분포한다고 가정
 * 시간복잡도
 * 		- 최악 : O(n​2​​) 최선 : O(n+k), 평균 : O(n + k)
 * 
 * 동작 순서
 * 		1. 버킷의 개수를 구하기 위해 최소값, 최대값을 산출
 * 		2. 버킷 개수 산출
 * 		3. 버킷 마다 List로 초기화
 * 		4. 해당 범위에 맞는 버킷에 Element Insert
 *    		- 버킷 인덱스  = (Element 값 - 최소값) / 버킷 사이즈
 * 		5. 버킷 Loop 돌며 버킷 내 Element 삽입정렬 후 대상 배열에 Insert
 *
 */
public class BucketSort {
    private final int DEFAULT_BUCKET_SIZE = 5;

    public void sort(Integer[] array) {
        sort(array, DEFAULT_BUCKET_SIZE);
    }

    public void sort(Integer[] array, int bucketSize) {
        if (array.length == 0) {
            return;
        }

        // 최대값, 최소값 구하기
        Integer minValue = array[0];
        Integer maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            } else if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }

        // 버킷 개수 산출
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        List<List<Integer>> buckets = new ArrayList<List<Integer>>(bucketCount);
        // 버킷 하나당 ArrayList<Integer>
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        // 버킷 범위에 맞게 버킷에 Insert
        for (int i = 0; i < array.length; i++) {
            buckets.get((array[i] - minValue) / bucketSize).add(array[i]);
        }

        // 버킷 별로 정렬 후 대상 배열에 Insert 
        int currentIndex = 0;
        for (int i = 0; i < buckets.size(); i++) {
            Integer[] bucketArray = new Integer[buckets.get(i).size()];
            bucketArray = buckets.get(i).toArray(bucketArray);
            InsertionSort.sort(bucketArray);
            for (int j = 0; j < bucketArray.length; j++) {
                array[currentIndex++] = bucketArray[j];
            }
        }
    }
    
    public static void main(String[] args) {
    	BucketSort nbs = new BucketSort();
    	Integer[] data = {5, 3, 0, 2, 4, 1};
		System.out.println("Before: " + Arrays.toString(data));
		nbs.sort(data, 3);
		System.out.println("After: " + Arrays.toString(data));
	}
}

//버킷 내 삽입정렬을 하기 위해 클래스 생성
class InsertionSort {
    public static <T extends Comparable<T>> void sort(T[] array) {
        for (int i = 1; i < array.length; i++) {
            T item = array[i];
            int indexHole = i;
            while (indexHole > 0 && array[indexHole - 1].compareTo(item) > 0) {
                array[indexHole] = array[--indexHole];
            }
            array[indexHole] = item;
        }
    }
}

