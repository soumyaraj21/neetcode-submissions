class Solution {
    public String predictPartyVictory(String senate) {
       int n=senate.length();
       Queue <Integer> rq=new LinkedList<>(); 
       Queue <Integer> dq=new LinkedList<>(); 
       for(int i=0;i<n;i++){
        if(senate.charAt(i)=='R'){
            rq.offer(i);
        }
        else{
            dq.offer(i);
        }
       }
       while(!rq.isEmpty() && !dq.isEmpty()){
       int r= rq.poll();
        int d=dq.poll();
        if(r<d){
rq.offer(r+n);
        }
        else{
            dq.offer(d+n);
        }
       }
       return dq.isEmpty()?"Radiant":"Dire";
    }
}