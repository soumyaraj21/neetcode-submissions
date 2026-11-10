class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int jumps=0;
        int curr=0;
        int last=0;
        for(int i=0;i<n-1;i++){
            last=Math.max(last,i+ nums[i]);
            if(i==curr){
                jumps++;
                curr=last;
            }
        }
        return jumps;
    }
}
