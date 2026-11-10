class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n=arr.length;
        int maxlen=1;
        int currlen=1;
        int prevsign=0;
        int sign=0;
        for(int i=0;i<n-1;i++){
            sign=Integer.compare(arr[i+1],arr[i]);
            if(sign==0){
                currlen=1;
            }
            else if(prevsign==sign){
                currlen=2;
            }
            else{
               currlen++; 
            }
            maxlen=Math.max(maxlen,currlen);
            prevsign = sign;
        }
        return maxlen;
    }
}