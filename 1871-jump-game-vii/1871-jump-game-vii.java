class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        
        if(s.charAt(s.length()-1)=='1'){
            return false;
        }
        int farthest=0; 
        Queue<Integer> q=new LinkedList<>(); 
        q.offer(0);
        while(!q.isEmpty()){
            int curr=q.poll(); 
            for(int i=Math.max(curr+minJump, farthest+1); i<=curr+maxJump; i++){
                //System.out.println(i); 
                if(i>=s.length()){
                    continue;
                }
                else if(i==s.length()-1){
                    return true; 
                }
                if(s.charAt(i)=='0'){
                    if(i>farthest){
                        q.offer(i);
                    }
                }
                
            }
            farthest=Math.max(farthest, curr+maxJump); 
        }
        return false;
        
    }
}