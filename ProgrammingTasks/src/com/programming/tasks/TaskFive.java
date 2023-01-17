package com.programming.tasks;
//Given two strings s and t, determine if they are isomorphic.
//
//Two strings s and t are isomorphic if the characters in s can be replaced to get t.
//
//All occurrences of a character must be replaced with another character while preserving the order of characters. 
//No two characters may map to the same character, but a character may map to itself.
//
//Example 1:
//Input: s = "egg", t = "add"
//Output: true
//Example 2:
//Input: s = "foo", t = "bar"
//Output: false
//Example 3:
//Input: s = "paper", t = "title"
//Output: true
import java.util.HashMap;
import java.util.Map;

public class TaskFive {
	public boolean isIsomorphic(String s, String t) {
		Map<Character, Character> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char char_str1 = s.charAt(i), char_str2 = t.charAt(i);
			// Comparing Key
			if (map.containsKey(char_str1)) {
				if (map.get(char_str1) != char_str2) {
					return false;
				}
			} else {
				// Comparing Value
				if (map.containsValue(char_str2)) {
					return false;
				}
				map.put(char_str1, char_str2);
			}
		}
		return true;
	}

	public static void main(String args[]) {
		TaskFive t5 = new TaskFive();
		//t5.isIsomorphic("egg", "add");
		//t5.isIsomorphic("foo", "bar");
		//t5.isIsomorphic("paper", "title");
		t5.isIsomorphic("bbbaaaba", "aaabbbba");
	}
}
