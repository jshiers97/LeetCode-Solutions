class Solution {
    Map<String, List<String>> map=new HashMap<>();
    int min=Integer.MAX_VALUE;
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean possible=false;
        int min=5005; 
        for(int i=0; i<wordList.size(); i++){
            String word=wordList.get(i);
            if(word.equals(endWord)){
                possible=true;
            }
            for(int j=0; j<word.length(); j++){
                String curr=word.substring(0, j) + "*" + word.substring(j+1);
                if(!map.containsKey(curr)){
                    map.put(curr, new ArrayList<>());
                }
                map.get(curr).add(word);
            }
        }
        if(possible==false){
            return 0;
        }
        int steps=1;
        Queue<String> q=new LinkedList<>(); 
        q.offer(beginWord);
        q.offer(null);
        Set<String> seen=new HashSet<>(); 
        while(!q.isEmpty()){
            String curr=q.poll();
            if(curr==null){
                
                steps++;
                if(!q.isEmpty()){
                    q.offer(null);
                }
            }
            else{
               
                if(curr.equals(endWord)){
                    return steps;
                }
                for(int i=0; i<curr.length(); i++){
                    String getter=curr.substring(0, i) + "*" + curr.substring(i+1);
                    List<String> list=map.get(getter);
                    if(list!=null && list.size() > 0){
                        for(String str: list){
                            if(!seen.contains(str)){
                                seen.add(str);
                                q.offer(str);
                            }
                        }
                    }
                    
                }
                
            }
        }
        
        
        return 0; 
        
    }
     
}