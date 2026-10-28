class Solution {
    public int maxProduct(int[] nums) {
     int max=nums[0];
     int min=nums[0];
     int ans=nums[0];
     for(int i=1;i<nums.length;i++){
        int num=nums[i];
        int currmax=Math.max(num,Math.max(num*max,num*min));
        int currmin=Math.min(num,Math.min(num*max,num*min));
        max=currmax;
        min=currmin;
        ans=Math.max(ans,max);
     } 
     return ans;  
    }
}
