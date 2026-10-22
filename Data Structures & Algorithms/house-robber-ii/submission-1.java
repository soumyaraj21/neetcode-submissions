class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        return(Math.max(roblinear(nums,0,n-2), roblinear(nums,1,n-1)));
        }
        private int roblinear(int nums[],int start,int end){
            int len=end-start+1;
            int dp[]=new int[len+1];
            dp[0]=nums[start];
            if(len==1){
                return dp[0];
            }
            for(int i=1;i<len;i++){
                int pick=nums[start+i];
                if(i>1){
                    pick+=dp[i-2];
                }
                int notpick=dp[i-1];
                dp[i]=Math.max(pick,notpick);
            }
            return dp[len-1];
        }
    }
