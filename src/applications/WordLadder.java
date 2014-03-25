package applications;

/**
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class WordLadder {
	/* Assume start and end are of the same length. */
	public int ladderLengthBFS(String start, String end, HashSet<String> dict) {
		if (start == null || end == null || start.length() == 0
				|| start.length() != end.length() || start.equals(end))
			return 0;

		return BFS(start, end, dict);
	}

	private class PathNode {
		String word;
		int length;

		public PathNode(String w, int l) {
			word = w;
			length = l;
		}
	}

	private int BFS(String start, String end, HashSet<String> dict) {

		Queue<PathNode> queue = new LinkedList<PathNode>();
		queue.add(new PathNode(start, 1));
		// for visited words
		Map<String, Boolean> visited = new HashMap<String, Boolean>();
		// BFS
		while (!queue.isEmpty()) {

			PathNode node = queue.poll();
			String currentWord = node.word;// get current path length
			int length = node.length;// mark the word as visited

			visited.put(currentWord, true);

			// find all words that can be transformed from s and store in queue
			// with len+1
			if (dict.size() < 26) { // loop through all words in dict - O(n*m)
				dict.add(end);
				for (String word : dict) {
					if (currentWord.equals(word))
						continue; // skip itself
					// put unvisited one in queue
					if (isNeighbor(currentWord, word)
							&& visited.get(word) == null) {
						// if hits end, return length
						if (word.equals(end))
							return length + 1;
						queue.add(new PathNode(word, length + 1));
					}
				}
			} else { // try 'a'-'z' for each character of s and check whether it
						// is valid - O(26*m)
				for (int i = 0; i < currentWord.length(); ++i) {
					StringBuilder sb = new StringBuilder(currentWord);
					char original = currentWord.charAt(i);
					for (char c = 'a'; c <= 'z'; ++c) {
						if (c == original)
							continue; // skip itself
						sb.setCharAt(i, c);
						String word = sb.toString();
						// if hits end, return length
						if (word.equals(end))
							return length + 1;
						// put unvisited one in queue
						if (visited.get(word) == null && dict.contains(word)) {
							queue.add(new PathNode(word, length + 1));
						}
					}
				}
			}
		}

		return 0;
	}

	private boolean isNeighbor(String s1, String s2) {// only one different
		if (s1.length() != s2.length())
			return false;
		int diff = 0;
		for (int i = 0; i < s1.length() && diff < 2; ++i) {
			if (s1.charAt(i) != s2.charAt(i))
				++diff;
		}
		return (diff == 1);
	}

	/**
	 * ladderLength using Dijkstra
	 * 
	 */

	/* Assume start and end are of the same length. */
	public int ladderLengthDijkstra(String start, String end,
			HashSet<String> dict) {
		if (start == null || end == null || start.length() == 0
				|| start.length() != end.length() || start.equals(end))
			return 0;

		return Dijkstra(start, end, dict);
	}

	private int Dijkstra(String start, String end, HashSet<String> dict) {
		dict.add(start);
		dict.add(end);

		// convert to an array
		int n = dict.size();
		String[] words = new String[n];
		dict.toArray(words);

		int ss = -1, ee = -1;
		ArrayList<ArrayList<Integer>> neighbors = new ArrayList<ArrayList<Integer>>(
				n);
		// initialize
		for (int i = 0; i < n; ++i) {
			ArrayList<Integer> neighbor = new ArrayList<Integer>();
			neighbors.add(neighbor);
		}
		// find all "edges" and index to start and end
		for (int i = 0; i < n; ++i) {
			if (start.equals(words[i]))
				ss = i;
			if (end.equals(words[i]))
				ee = i;
			for (int j = i + 1; j < n; ++j) {
				if (isNeighbor(words[i], words[j])) {
					ArrayList<Integer> neighbor = neighbors.get(i);
					neighbor.add(j);
					neighbor = neighbors.get(j);
					neighbor.add(i);
				}
			}
		}

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(ss, 1));
		boolean[] visited = new boolean[n];

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			// mark as visited
			visited[node.word] = true;
			// if hits the end, return
			if (node.word == ee)
				return node.step;
			// add unvisited neighbors to queue
			for (int nb : neighbors.get(node.word)) {
				if (!visited[nb]) {
					queue.add(new Node(nb, node.step + 1));
				}
			}
		}

		return 0;
	}

	private class Node {
		int word;
		int step;

		public Node(int w, int s) {
			word = w;
			step = s;
		}
	}
}
