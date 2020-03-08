/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        
        Collections.sort(intervals, new IntervalComparator());
        /*Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });*/
        
        for (int i=1; i<intervals.size(); i++){
            if (intervals.get(i-1).end > intervals.get(i).start) return false;
        }
        
        
        return true;
    }
    
    
    class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval o1, Interval o2) {
            
            if (o1 == null || o2 == null) return -1;
            
            return o1.start > o2.start ? 1 : o1.start == o2.start ? 0 :-1;
        }
    }
}
