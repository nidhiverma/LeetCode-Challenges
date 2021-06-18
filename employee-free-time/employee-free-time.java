/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> intervals = flattenIntervals(schedule);
        
        Collections.sort(intervals, (a, b) -> a.start - b.start);
//         for(Interval interval: intervals) {
//             System.out.print("<" + interval.start + "," + interval.end + "> ") ;
//         }
//         System.out.println();
        
        List<Interval> result = freeIntervals(intervals);
        return result;
    }
    
    private List<Interval> flattenIntervals(List<List<Interval>> schedule) {
        List<Interval> intervals = new ArrayList();
        for(List<Interval> s: schedule) {
            intervals.addAll(s);
        }
        return intervals;
    }
    
    
    private List<Interval> freeIntervals(List<Interval> intervals) {
        List<Interval> freeIntervals = new ArrayList();
        
        Interval curr = intervals.get(0);

        for(int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            
            int curr_start = curr.start;
            int curr_end = curr.end;
            int next_start = next.start;
            int next_end = next.end;
            
            // System.out.println("<" + curr.start + "," + curr.end + ">" + " " + "<" + next.start + "," + next.end + ">");
            
            
            if(curr_end < next_start && next_start-curr_end > 0) {
                freeIntervals.add(new Interval(curr_end, next_start));
                curr = next;
            }
            else {
                curr.start = Math.min(curr_start, next_start);
                curr.end = Math.max(curr_end, next_end);
            }
        }
        return freeIntervals;
    }
}