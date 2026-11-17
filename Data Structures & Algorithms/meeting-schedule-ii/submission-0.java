/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a,b)->Integer.compare(a.start,b.start));
        PriorityQueue<Integer> minheap=new PriorityQueue<>();
        int n=intervals.size();
        for(int i=0;i<n;i++){
            minheap.peek();
            Interval current=intervals.get(i);
            if(!minheap.isEmpty() && minheap.peek()<=current.start){
                minheap.poll();   
            }
                minheap.offer(current.end);
        }
    return minheap.size();
    }
}
