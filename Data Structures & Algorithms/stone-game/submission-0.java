class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        int dp[][]=new int[n][n];
        for(int i=n-1;i>=0;i--){
            dp[i][i]=piles[i];
            for(int j=i+1;j<n;j++){
                int front=piles[i]-dp[i+1][j];
                int back=piles[j]-dp[i][j-1];
            dp[i][j]=Math.max(front,back);
            }
        }
        return dp[0][n-1]>0;
    }
}