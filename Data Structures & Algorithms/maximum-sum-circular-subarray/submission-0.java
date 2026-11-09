class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       int n=nums.length;
       int min=nums[0];
       int currmax=nums[0];
       int currmin=nums[0];
       int total=nums[0];
       int max=nums[0];
       for(int i=1;i<n;i++){
        total=total+nums[i];
        currmin=Math.min(nums[i],currmin+nums[i]);
        min=Math.min(min,currmin);

        currmax=Math.max(nums[i],currmax+nums[i]);
        max=Math.max(max,currmax);
       }
         if(max<0){
            return max;
        }
       return Math.max(max,total-min);
    }
}