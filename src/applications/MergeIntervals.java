package applications;

import helperClass.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MergeIntervals {

	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {

		// sort the intervals based on start points
		Comparator<Interval> comparator = new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.start < i2.start) {
					return -1;
				} else {
					return 1;
				}
			}
		};
		Collections.sort(intervals, comparator);// O(nlogn)

		return mergeWithArray(intervals);
		// return mergeInPlace(intervals);
	}

	private ArrayList<Interval> mergeWithArray(ArrayList<Interval> intervals) {
		ArrayList<Interval> results = new ArrayList<Interval>();
		Interval cur = null;
		for (int i = 0; i < intervals.size(); ++i) {
			if (cur == null) {
				cur = intervals.get(i);
			} else if (cur.end >= intervals.get(i).start) { // overlapping
				cur.end = Math.max(cur.end, intervals.get(i).end);
			} else { // gap
				results.add(cur);
				cur = intervals.get(i);
			}
		}
		if (cur != null)
			results.add(cur);
		return results;
	}

	private ArrayList<Interval> mergeInPlace(ArrayList<Interval> intervals) {
		int cur = 0, next = 1;
		while (next < intervals.size()) {
			if (intervals.get(cur).end >= intervals.get(next).start) {
				intervals.get(cur).end = Math.max(intervals.get(cur).end,
						intervals.get(next).end);
				++next;
			} else {
				if (next > cur) {
					intervals.subList(cur + 1, next).clear();
				}
				++cur;
				next = cur + 1; // after removal, index has changed
			}
		}
		if (cur < intervals.size() - 1) {
			intervals.subList(cur + 1, intervals.size()).clear();
		}
		return intervals;
	}

}
