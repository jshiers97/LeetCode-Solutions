class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map=new HashMap<>();
        for(List<String> ticket: tickets){
            String src=ticket.get(0);
            String dst=ticket.get(1);
            if(!map.containsKey(src)){
                map.put(src, new PriorityQueue<>());
            }
            map.get(src).offer(dst);
        }
        List<String> output=new ArrayList<>();

        Stack<String> stack=new Stack<>();
        
        stack.push("JFK");
        while(!stack.isEmpty()){
            String curr=stack.peek();
            PriorityQueue<String> pq=map.get(curr);
            if(pq==null || pq.size() == 0){
                output.add(stack.pop());
                
            }
            else{
                stack.push(pq.poll());
            }
        }
        Collections.reverse(output);
        
        
        
        return output; 
        
    }
}