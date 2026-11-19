class Solution {
    public String addBinary(String a, String b) {
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        StringBuilder result=new StringBuilder();
        while(i>=0 || j>=0 || carry>0){
            int bita=0;
            int bitb=0;
            if(i>=0){
                bita=a.charAt(i)-'0';
            }
            if(j>=0){
                bitb=b.charAt(j)-'0';
            }
            int sum=bita+bitb+carry;
            int resultbit=sum%2;
            int newcarry=sum/2;
            result.append(resultbit);
            carry=newcarry;
            i--;
            j--;
        }
        return result.reverse().toString();
    }
}