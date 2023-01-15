package com.programming.tasks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/*
	Given an array of integers a, your task is to calculate the digits that occur the most number of times in the array. Return the array of these digits in ascending order.

	Example
	For a = [25, 2, 3, 57, 38, 41], the output should be solution(a) = [2, 3, 5].

	Here are the number of times each digit appears in the array:

	0 -> 0
	1 -> 1
	2 -> 2
	3 -> 2
	4 -> 1
	5 -> 2
	6 -> 0
	7 -> 1
	8 -> 1
	The most number of times any number occurs in the array is 2, and the digits which appear 2 times are 2, 3 and 5. So the answer is [2, 3, 5].

	Input/Output

	[execution time limit] 3 seconds (java)

	[input] array.integer a

	An array of positive integers.

	Guaranteed constraints:
	1 ≤ a.length ≤ 103,
	1 ≤ a[i] < 100.

	[output] array.integer

	The array of most frequently occurring digits, sorted in ascending order.
 */

public class TaskOne {
	
	public static int[] solution(int[] a) {
		HashMap<Integer, Integer> digitCount = new HashMap<Integer, Integer>();
		for (int n : a) {
			if (String.valueOf(n).length() > 1) {
				while (0 != n) {
					int remainder = n % 10;
					if (null != digitCount.get(remainder) && digitCount.get(remainder) > 0) {
						int c = digitCount.get(remainder);
						digitCount.put(remainder, ++c);
					} else {
						digitCount.put(remainder, 1);
					}
					n = n/10;
				}
			} else {
				if (null != digitCount.get(n) &&  digitCount.get(n) > 0) {
					int c = digitCount.get(n);
					digitCount.put(n, ++c);    
				} else {
					digitCount.put(n, 1);
				}
			}
		}
		List<Integer> sortedMostDigitsList = getMostOccuranceSortedList(digitCount);
		Collections.sort(sortedMostDigitsList);
		int[] result = sortedMostDigitsList.stream().mapToInt(i-> (i==null ? 0 : i)).toArray();
		return result;
	}

	public static List<Integer> getMostOccuranceSortedList(HashMap<Integer, Integer> digitCountMap) {
		int max = 0;
		List<Integer> sortedMostDigitsList = new ArrayList<>();
		for (Integer key : digitCountMap.keySet()) {
			if (digitCountMap.get(key) > max) {
				max = digitCountMap.get(key);
			}
		}
		for (Integer key : digitCountMap.keySet()) {
			if (digitCountMap.get(key) == max) {
				sortedMostDigitsList.add(key);
			}
		}
		return sortedMostDigitsList;
	}
	
	public static void main(String[] args) {
		int a[] = {25, 2, 3, 57, 38, 41};
		int b[] = solution(a);
		for (int i : b) {
			System.out.println(i);
		}
		
	}

}
