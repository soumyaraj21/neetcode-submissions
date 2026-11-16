class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ans.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int[] current=ans.get(ans.size()-1);
            if(current[1]>=intervals[i][0]){
                current[0]=Math.min(current[0],intervals[i][0]);
                current[1]=Math.max(current[1],intervals[i][1]);
        }
        else{
    ans.add(intervals[i]);
        }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
