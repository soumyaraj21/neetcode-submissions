class Solution {
    public List<Integer> partitionLabels(String s) {
        int last[]=new int[26];
        int start=0;
        int end=0;
        int n=s.length();
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<n;i++){
            last[s.charAt(i) - 'a'] = i;
        }
         for (int i=0;i<n;i++){
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if(i==end){
                result.add(end - start + 1);
                start=end+1;
            }
         }
        return result;
    }
}
