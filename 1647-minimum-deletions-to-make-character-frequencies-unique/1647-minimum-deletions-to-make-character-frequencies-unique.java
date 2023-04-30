class Solution {
    public int minDeletions(String s) {
        //p<Character, Integer> count=new HashMap<>(); 
        int[] chars=new int[26];
        for(int i=0; i<s.length(); i++){
            char c=s.charAt(i); 
            chars[c-'a']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>( (x, y) -> (y-x)); 
        for(int i=0; i<26; i++){
            if(chars[i]>0){
                pq.offer(chars[i]);
            }
            
        }
        int deletes=0; 
        while(!pq.isEmpty()){
            int curr=pq.poll(); 
            //System.out.println(curr); 
            if(pq.isEmpty()){
                continue;
            }
            else{
                int next=pq.peek(); 
                if(curr==next){
                    curr--;
                    deletes++;
                    if(curr>0){
                        //System.out.println("here" + curr);
                        pq.offer(curr); 
                    }
                    
                }
                
            }
        }
        return deletes; 
        
        
    }
}