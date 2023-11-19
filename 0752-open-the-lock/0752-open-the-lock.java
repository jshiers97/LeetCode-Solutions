class Solution {
    Set<String> set;
    public int openLock(String[] deadends, String target) {
        this.set=new HashSet<>(); 
        for(String str: deadends){
            set.add(str); 
        }
        Set<String> seen=new HashSet<>();
        Queue<String> q=new LinkedList(); 
        int time=0; 
        q.offer("0000");
        q.offer(null);
        while(!q.isEmpty()){
            String curr=q.poll(); 
            if(curr==null){
                if(q.isEmpty()){
                    return -1;
                }
                else{
                    time++;
                    q.offer(null);
                }
            }
            else{
                if(curr.equals(target)){
                    return time; 
                }
                else if(set.contains(curr)){
                    continue;
                }
                else{
                    for(int i=0; i<4; i++){
                        char c=curr.charAt(i);
                        String increase;
                        String decrease;
                        if(c=='9'){
                            decrease=curr.substring(0, i) + "8" + curr.substring(i+1);
                            increase=curr.substring(0,i) + "0" + curr.substring(i+1);
                        }
                        else if(c=='0'){
                            decrease=curr.substring(0, i) + "9" + curr.substring(i+1);
                            increase=curr.substring(0,i) + "1" + curr.substring(i+1);
                        }
                        else{
                            decrease=curr.substring(0, i) + (c-'0'-1) + curr.substring(i+1);
                            increase=curr.substring(0,i) + (c-'0'+1) + curr.substring(i+1); 
                        }
                        
                        if(!seen.contains(decrease)){
                            q.offer(decrease);
                            seen.add(decrease);
                        }
                        if(!seen.contains(increase)){
                            q.offer(increase); 
                            seen.add(increase);
                        }
                    }
                }
        
                
            }
        }
        return -1;
        
    }
}