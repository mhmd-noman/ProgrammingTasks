package com.programming.tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
  Given two words, beginWord and endWord, and a wordList of approved words, find the length of the shortest transformation sequence from beginWord to endWord such that:

	Only one letter can be changed at a time
	Each transformed word must exist in the wordList.
	The length of the sequence is defined as the number of words in it, e.g. the length of "cot" -> "hot" -> "hit" is 3, and the length of "dog" -> "cog" is 2.

	Return the length of the shortest transformation sequence, or 0 if no such transformation sequence exists.

	Note: beginWord does not count as a transformed word. You can assume that beginWord and endWord are not empty and are not the same.

	Example

	For beginWord = "hit", endWord = "cog", and wordList = ["hot", "dot", "dog", "lot", "log", "cog"], the output should be
	solution(beginWord, endWord, wordList) = 5.

	The shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog" with a length of 5.

	For beginWord = "a", endWord = "c", and wordList = ["a", "b", "c"], the output should be
	solution(beginWord, endWord, wordList) = 2.

	It is possible to obtain endWord = "c" from beginWord = "a" without using any additional words in the middle: "a" -> "c".

	Input/Output

	[execution time limit] 3 seconds (java)

	[input] string beginWord

	Guaranteed constraints:
	1 ≤ beginWord.length ≤ 5.

	[input] string endWord

	Guaranteed constraints:
	endWord.length = beginWord.length.

	[input] array.string wordList

	An array containing all of the approved words. All words in the array are the same length and contain only lowercase English letters. You can assume that there are no duplicates in wordList.

	Guaranteed constraints:
	2 ≤ wordList.length ≤ 600,
	wordList[i].length = beginWord.length.

	[output] integer

	An integer representing the length of the shortest transformation sequence from beginWord to endWord using only words from wordList as described above.

 */

public class TaskTwo {
	public static int solution(String beginWord, String endWord, String[] wordArray) {
		List<String> wordList = Arrays.asList(wordArray);
		// check edge case
		if (wordList == null || !wordList.contains(endWord)) {
			return 0;
		}

		// build queue, visited set
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(1, beginWord));
		Set<String> words = new HashSet<>(wordList);

		// process one level of queue each time, count
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			String word = node.word;
			int numSteps = node.steps;

			if (word.equals(endWord)) {
				return node.steps;
			}
			//char[] arr = word.toCharArray();
			StringBuffer sb = new StringBuffer(word);
			for (int i = 0; i < sb.length(); i++) {
				char temp = sb.charAt(i);
				for (char c = 'a'; c <= 'z'; c++) {
					if (temp == c) {
						continue;
					}
					sb.setCharAt(i, c);
					String newWord = sb.toString();
					if (words.remove(newWord)) {
						queue.offer(new Node(numSteps + 1, newWord));
					}
				}
				sb.setCharAt(i, temp);
			}
		}// END WHILE

		return 0;
	}

	static class Node {
		int steps;
		String word;
		public Node(int steps, String word) {
			this.steps = steps;
			this.word = word;
		}
	}

	public static void main(String[] args) {
		String wordList[] = {"hot", "dot", "dog", "lot", "log", "cog"};
		int b = solution("hit", "cog", wordList);
		System.out.println(b);
	}
}
