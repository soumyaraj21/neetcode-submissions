class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int m=queries.length;
        int sortedq[][]=new int[m][2];
        for(int i=0;i<m;i++){
            sortedq[i][0]=queries[i];
            sortedq[i][1]=i;
        }
     Arrays.sort(sortedq,(a,b)->Integer.compare(a[0],b[0]));
     PriorityQueue<int[]> minheap=new PriorityQueue<>((a,b)->{return Integer.compare(a[0],b[0]);
     });
     int ans[]=new int[m];
     int j=0;
     for(int i=0;i<m;i++){
     int q=sortedq[i][0];
     while (j < intervals.length && intervals[j][0] <= q){
    int left = intervals[j][0];
    int right = intervals[j][1];
    int length = right - left + 1;
    minheap.offer(new int[]{length, right});
    j++;
}
while (!minheap.isEmpty() && minheap.peek()[1] < q) {
    minheap.poll();
}
int originalIndex = sortedq[i][1];

if (minheap.isEmpty()) {
    ans[originalIndex] = -1;
} else {
    ans[originalIndex] = minheap.peek()[0];
}
}
return ans;
    }
}
