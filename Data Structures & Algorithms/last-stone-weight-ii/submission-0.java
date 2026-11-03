class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        int sum=0;
        for(int i=0;i<n;i++){
           sum+=stones[i];
        }
        int halfsum=sum/2;
        boolean dp[][]=new boolean[n+1][halfsum+1];
        for(int i=0;i<=n;i++){
        dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=halfsum;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=stones[i-1]){
                    dp[i][j] = dp[i][j] || dp[i-1][j-stones[i-1]];
                }
    }
}
for(int j = halfsum; j >= 0; j--) {
    if(dp[n][j]) {
        return sum - 2*j;
                }
}
return 0;
            }
        }
