class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair<Character, Integer>> pq=new PriorityQueue<>( (x, y) -> y.getValue()- x.getValue() );
        if(a>0){
            pq.offer(new Pair<Character, Integer>('a', a));
        }
        if(b>0){
            pq.offer(new Pair<Character, Integer>('b', b));
        }
        if(c>0){
            pq.offer(new Pair<Character, Integer>('c', c));
        }
       
        StringBuilder output=new StringBuilder();
        while(!pq.isEmpty()){
           
            Pair<Character, Integer> curr=pq.poll();
            if(output.length() >=2 && output.charAt(output.length()-1)==output.charAt(output.length()-2) && curr.getKey()==output.charAt(output.length()-1)){
                if(pq.isEmpty()){
                    break;
                }
                Pair<Character, Integer> next=pq.poll();
                output.append(next.getKey());
                
                if(next.getValue()>1){
                    Pair<Character, Integer> insert=new Pair(next.getKey(), next.getValue()-1);
                    pq.offer(insert);
                }
                pq.offer(curr);
                
            }else{
                output.append(curr.getKey());
                if(curr.getValue() > 1){
                    Pair<Character, Integer> insert=new Pair(curr.getKey(), curr.getValue()-1);
                    pq.offer(insert);
                }
                
            }
        }
               return output.toString(); 
        
    }
}