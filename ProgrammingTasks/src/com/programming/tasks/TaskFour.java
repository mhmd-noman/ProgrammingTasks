package com.programming.tasks;
//Given an array of integers nums, calculate the pivot index of this array.
//The pivot index is the index where the sum of all the numbers strictly to the left of the index is equal to the sum of all the numbers strictly to the index's right.
//If the index is on the left edge of the array, then the left sum is 0 because there are no elements to the left. This also applies to the right edge of the array.
//
//Return the leftmost pivot index. If no such index exists, return -1.
//
//Example 1:
//
//Input: nums = [1,7,3,6,5,6]
//Output: 3
//Explanation:
//The pivot index is 3.
//Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
//Right sum = nums[4] + nums[5] = 5 + 6 = 11
//Example 2:
//
//Input: nums = [1,2,3]
//Output: -1
//Explanation:
//There is no index that satisfies the conditions in the problem statement.
//Example 3:
//
//Input: nums = [2,1,-1]
//Output: 0
//Explanation:
//The pivot index is 0.
//Left sum = 0 (no elements to the left of index 0)
//Right sum = nums[1] + nums[2] = 1 + -1 = 0
public class TaskFour {
	public int pivotIndex(int[] nums) {
		int leftSum = 0;
		int rightSum = 0;
		if (nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			return 0;
		}
		for (Integer i = 0; i < nums.length; i++) {
			leftSum = getLeftSum(nums, i);
			rightSum = getRightSum(nums, i);

			if (leftSum == rightSum) {
				return i;
			}
		}
		return -1;
	}

	public int getLeftSum(int[] nums, int index) {
		int leftSum = 0;
		if (index == 0) {
			return leftSum;
		}
		while (index > 0) {
			leftSum =+ leftSum + nums[index-1];
			index--;
		}
		return leftSum;
	}

	public int getRightSum(int[] nums, int index) {
		int rightSum = 0;
		while (index < (nums.length-1)) {
			rightSum =+ rightSum + nums[index+1];
			index++;
		}
		return rightSum;
	}

	public static void main(String[] args) {
		TaskFour t4 = new TaskFour();
		int d[] = {-1,-1,0,1,1,0};
		System.out.println(t4.pivotIndex(d));
		int a[] = {1,7,3,6,5,6};
		System.out.println(t4.pivotIndex(a));
		int b[] = {1,2,3};
		System.out.println(t4.pivotIndex(b));
		int c[] = {2,1,-1};
		System.out.println(t4.pivotIndex(c));

	}
}
