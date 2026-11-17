class Solution {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        PriorityQueue<Integer> avlrooms=new PriorityQueue<>();
        PriorityQueue<long[]> ocrooms=new PriorityQueue<>((a,b)->{
            if(a[0]!=b[0]){
                return Long.compare(a[0],b[0]);
            }
            return Long.compare(a[1],b[1]);
        });
for(int i=0;i<n;i++){
    avlrooms.offer(i);
}
int count[]=new int[n];
for(int[] meeting:meetings){
    long start=meeting[0];
    long end=meeting[1];
    while(!ocrooms.isEmpty() && ocrooms.peek()[0]<=start){
        long[] finishedrooms=ocrooms.poll();
        avlrooms.offer((int) finishedrooms[1]);
    }
    int room;
    long newend;
    if(!avlrooms.isEmpty()){
        room=avlrooms.poll();
        newend=end;
    }
    else{
        long[] earliestroom=ocrooms.poll();
        room=(int)earliestroom[1];
        long duration=end- start;
        newend=earliestroom[0]+duration;
    }
    ocrooms.offer(new long[]{newend,room});
    count[room]++;
}
int ans=0;
for(int i=1;i<n;i++){
    if(count[i]>count[ans]){
        ans=i;
    }
}
return ans;

    }
}