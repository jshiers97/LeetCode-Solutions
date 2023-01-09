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
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)-> x[0]-y[0]);
        List<Interval> output=new ArrayList<>(); 
        for(List<Interval> list: schedule){
            for(Interval x: list){
                pq.offer(new int[]{x.start, x.end});
            }
        }
        int[] first=pq.poll(); 
        int start=first[1];
        while(!pq.isEmpty()){
            int[] curr=pq.poll(); 
            if(start < curr[0]){
                output.add(new Interval(start, curr[0]));
                start=curr[1];
            }
            else{
                start=Math.max(start, curr[1]);
            }
        }
        return output; 
    }
}