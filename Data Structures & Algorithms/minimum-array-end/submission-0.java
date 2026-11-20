class Solution {
    public long minEnd(int n, int x) {
        long ans=x;
        long k=n-1;
        int bit=0;
        while(k>0){
            if((x&(1L<<bit))==0){
                  if ((k & 1L) == 1L) {
                    ans = ans | (1L << bit);
                }
                 k = k >> 1;
            }
             bit++;
        }
        return ans;
        
    }
}