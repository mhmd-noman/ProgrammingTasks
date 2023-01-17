package com.programming.tasks;
//
//Given two strings s(subStr) and t(mainStr), return true if s is a subsequence of t, or false otherwise.
//
//A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
//
// 
//
//Example 1:
//
//Input: s = "abc", t = "ahbgdc"
//Output: true
//Example 2:
//
//Input: s = "axc", t = "ahbgdc"
//Output: false
// 

public class TaskSix {
	public boolean isSubsequence(String subStr, String mainStr) {
		if ((null == mainStr || mainStr.isEmpty()) && (null == subStr || subStr.isEmpty())) {
			return true;
		}
		if (null == mainStr || mainStr.isEmpty()) {
			return false;
		}
		if (null == subStr || subStr.isEmpty() ) {
			return true;
		}
		int j = 0;
		for (int i=0; i<mainStr.length(); i++) {
			if (j >= subStr.length()) {
				return true;
			}
			if (String.valueOf(subStr.charAt(j)).equals(String.valueOf(mainStr.charAt(i)))) {
				j++;
			}
		}
		if (j >= subStr.length()) {
			return true;
		}
		return false;
	}

	public static void main(String args[]) {
		TaskSix t6 = new TaskSix();
		//t5.isIsomorphic("egg", "add");
		//t5.isIsomorphic("foo", "bar");
		//t5.isIsomorphic("paper", "title");
		System.out.println(t6.isSubsequence("abc", ""));
		//System.out.println(t6.isSubsequence("axc", "ahbgdc"));
		//System.out.println(t6.isSubsequence("abc", "ahbgdc"));
	}
}
