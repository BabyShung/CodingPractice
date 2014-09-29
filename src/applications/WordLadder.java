package applications;

/**
 * Given two words (start and end), and a dictionary, 
 * find the length of shortest transformation sequence from start to end, such that:
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * BFS
 * 
 * @author haozheng
 *
 */

public class WordLadder {

	public int ladderLength(String start, String end, Set<String> dict) {

		Map<String, Integer> hm = new HashMap<>();
		Queue<String> q = new LinkedList<>();

		q.add(start);
		hm.put(start, 1);

		while (!q.isEmpty()) {
			String cur = q.poll();
			int distance = hm.get(cur);

			if (cur.equals(end))
				return distance;

			// changing the words (it is like finding its childern)
			for (int i = 0; i < cur.length(); i++) {
				for (int j = 0; j <= 25; j++) {
					String trans = replace(cur, i, (char) ('a' + j));

					if (!hm.containsKey(trans) && dict.contains(trans)) {
						hm.put(trans, distance + 1);
						q.add(trans);
					}
				}
			}
		}

		return 0;
	}

	private String replace(String s, int index, char c) {
		StringBuilder sb = new StringBuilder(s);
		sb.setCharAt(index, c);
		return sb.toString();
	}
}
