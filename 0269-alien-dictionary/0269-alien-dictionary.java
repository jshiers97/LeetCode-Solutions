class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Integer> alphabeticIndegree=new HashMap<>();
        Map<Character, List<Character>> adjList=new HashMap<>();
        for(String word: words){
            for(char c: word.toCharArray()){
                adjList.put(c, new ArrayList<>());
                alphabeticIndegree.put(c, 0);
            }
        }
        
        for(int i=0; i<words.length-1; i++){
            String first=words[i];
            String second=words[i+1];
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }
            for(int j=0; j<Math.min(first.length(), second.length()); j++){
                if(first.charAt(j)!=second.charAt(j)){
                    alphabeticIndegree.put(second.charAt(j), alphabeticIndegree.get(second.charAt(j))+1);
                    adjList.get(first.charAt(j)).add(second.charAt(j));
                    break;
                }
            }
        }

        Queue<Character> q=new LinkedList<>();
        for(Character c: alphabeticIndegree.keySet()){
            if(alphabeticIndegree.get(c) ==0){
                q.offer(c);
                
            }
        }
        StringBuilder output=new StringBuilder(); 
        while(!q.isEmpty()){
            char curr=q.poll();
            output.append(curr);
            for(char c: adjList.get(curr)){
                if(alphabeticIndegree.get(c)==1){
                    q.offer(c);
                }
                alphabeticIndegree.put(c, alphabeticIndegree.get(c)-1);
            }
        }
        if(output.length() != alphabeticIndegree.size()){
            return "";
        }
        return output.toString(); 
            
    }
}