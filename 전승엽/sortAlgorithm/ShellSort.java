package sortAlgorithm;

import java.util.*;

/**
 *  셀 정렬
 *  	* 정의
 *  		- 자료 리스트를 쪼갠 후 쪼갠 리스트 삽입정렬을 수행
 *  		- 길이가 1이 될때까지 잘게 쪼갠 후 위의 과정을 반복
 *  	* 특징
 *  		- 삽입 정렬의 성질을 이용, 보완
 *  			> 삽입 정렬은 입력되는 초기리스트가 "거의 정렬" 되어 있을 경우 효율적
 *  			> 삽입 정렬은 한 번에 한 요소의 위치만 결정되기 때문에 비효율적
 *  		- 부분리스트 정렬을 통해 먼거리 이동이 가능(gap을 이용하여 부분리스트를 구성)
 *  		- 간격 설정 : 임의로 설정
 *  			> Donald Shell은 처음에 간격을 2^k, (k는 0 이상의 자연수) 혹은 2^k-1로 잡음
 *  			> Marcin Ciura의 연구에 의하면  1, 4, 10, 23, 57, 132, 301, 701, 1750 ... 과 같은 간격을 사용하는 것이 연산 시간을 많이 줄인다고 함
 *  	* 시간복잡도
 *  		- 최악 O(n2), 평균 O(n1.5), 최선(nlogn)
 * 
 */
public class ShellSort {

	public static void sort(int[] array) {
		int inner, outer;
		int temp;
		int gap = 1;

		//임의의 간격 구하기
		while (gap <= array.length / 3) {
			gap = gap * 3 + 1;
		}
		
		//간격이 0이 되면 정렬 종료
		while (gap > 0) {
			//리스트를 간격 만큼 반복하여 정렬 수행
			for (outer = gap; outer < array.length; outer++) {
				temp = array[outer];
				inner = outer;
				
				//대상 보다 GAP만큼 앞에 있는 요소가 있는지?
				//대상 보다 GAP만큼 앞에 있는 요소가 큰지?
				//위 두가지 조건을 충족하면 삽입정렬 수행
				while (inner > gap - 1 && array[inner - gap] >= temp) {
					array[inner] = array[inner - gap];
					inner -= gap;
				}
				array[inner] = temp;
			}
			gap = (gap - 1) / 3;
		}
	}

	public static void main(String[] args) {
		int[] array = { 5, 3, 0, 2, 4};
		System.out.println("Before: " + Arrays.toString(array));
		sort(array);
		System.out.println("After:  " + Arrays.toString(array));
	}
}