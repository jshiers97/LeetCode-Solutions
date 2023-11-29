class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n=colors.length(); 
        Map<Integer, List<Integer>> map=new HashMap<>(); 
        for(int[] edge: edges){
            map.computeIfAbsent(edge[0], k-> new ArrayList<Integer>()).add(edge[1]);
        }
        int[][] count=new int[n][26];
        boolean[] visit=new boolean[n];
        boolean[] inStack=new boolean[n];
        int answer=0;
        for(int i=0; i<n; i++){
            answer=Math.max(answer, dfs(i, colors, map, count, visit, inStack)); 
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    public int dfs(int index, String colors, Map<Integer, List<Integer>> map, int[][] count, boolean[] visit, boolean[] inStack){
        if(inStack[index]){
            return Integer.MAX_VALUE; 
        }
        if(visit[index]){
            return count[index][colors.charAt(index)-'a'];
        }
        visit[index]=true;
        inStack[index]=true; 
        if(map.containsKey(index)){
            for(int neighbor: map.get(index)){
                if(dfs(neighbor, colors, map, count, visit, inStack)==Integer.MAX_VALUE){
                    return Integer.MAX_VALUE; 
                }
                for(int i=0; i<26; i++){
                    count[index][i]=Math.max(count[index][i], count[neighbor][i]);
                }
            }
        }
        count[index][colors.charAt(index)-'a']++;
        inStack[index]=false;
        return count[index][colors.charAt(index)-'a'];
    }
}