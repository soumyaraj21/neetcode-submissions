class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0){
            return false;
        }
        else{
            Arrays.sort(hand);
            TreeMap <Integer,Integer> freq=new TreeMap<>();
            for(int card:hand){
                freq.put(card,freq.getOrDefault(card,0)+1);
            }while(!freq.isEmpty()){
                int first=freq.firstKey();
                for(int j=0;j<groupSize;j++){
                    int card=first+j;
                    if(!freq.containsKey(card)){
                        return false;
                    }
                    int count=freq.get(card);
                    if(count==1){
                        freq.remove(card);
                    }
                    else{
                        freq.put(card,count-1);
                    }
                }
            }
        }
        return true;
    } 
}
