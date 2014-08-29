package Merge_LinkedList_Array;

import helperClass.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {

		// result lists O(n) space
		ArrayList<Interval> r = new ArrayList<>();

		// p is the pointer
		int p = 0, length = intervals.size();
		// find the place to insert the new interval
		while (p < length && newInterval.start > intervals.get(p).end) {
			r.add(intervals.get(p++));
		}
		// insert (merge as needed)
		while (p < length && intervals.get(p).start <= newInterval.end) {
			newInterval.start = Math.min(newInterval.start,
					intervals.get(p).start);
			newInterval.end = Math.max(newInterval.end, intervals.get(p).end);
			p++;
		}

		r.add(newInterval);

		// add the rest
		while (p < length) {
			r.add(intervals.get(p++));
		}

		return r;
	}
}
