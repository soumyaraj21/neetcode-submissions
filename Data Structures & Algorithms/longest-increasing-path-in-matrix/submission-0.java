class Solution {
    public int longestIncreasingPath(int[][] matrix) {
      int m=matrix.length;
      int n=matrix[0].length;
      int dp[][]=new int[m][n];
      int ans=0;
      for(int i=0;i<m;i++){
        for(int j=0;j<n;j++){
            ans=Math.max(ans,dfs(i,j,matrix,dp));
        }
      } 
      return ans;
    }
    private int dfs(int i,int j,int[][] matrix,int[][] dp){
        if(dp[i][j]!=0){
            return dp[i][j];
        }
        dp[i][j]=1;
        int rows[]={-1,1,0,0};
        int col[]={0,0,-1,1};
        for(int d=0;d<4;d++){
            int newrow=i+rows[d];
            int newcol=j+col[d];
        if(newrow>=0 && newrow<matrix.length && newcol>=0 && newcol<matrix[0].length && matrix[newrow][newcol]>matrix[i][j]){
            dp[i][j]=Math.max(dp[i][j],1+dfs(newrow,newcol,matrix,dp));
        }
        }
        return dp[i][j];
    }
}
