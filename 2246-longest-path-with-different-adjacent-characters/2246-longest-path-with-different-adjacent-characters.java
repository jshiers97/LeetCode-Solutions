class Solution {
    int longestPath=1; 
    public int longestPath(int[] parent, String s) {
        int n=parent.length;
        Map<Integer, List<Integer>> children =new HashMap<>(); 
        for(int i=1; i<parent.length; i++){
            if(!children.containsKey(parent[i])){
                children.put(parent[i], new ArrayList<>());
            }
            children.get(parent[i]).add(i);
        }
        dfs(0, children, s);
        return longestPath; 
        
    }
    public int dfs(int currentNode, Map<Integer, List<Integer>> children, String s){
        if (!children.containsKey(currentNode)) {
            return 1;
        }
        int longestChain = 0, secondLongestChain = 0;
        for (int child : children.get(currentNode)) {
            // Get the number of nodes in the longest chain starting from the child,
            // including the child.
            int longestChainStartingFromChild = dfs(child, children, s);
            // We won't move to the child if it has the same character as the currentNode.
            if (s.charAt(currentNode) == s.charAt(child)) {
                continue;
            }
            // Modify the longestChain and secondLongestChain if longestChainStartingFromChild
            // is bigger.
            if (longestChainStartingFromChild > longestChain) {
                secondLongestChain = longestChain;
                longestChain = longestChainStartingFromChild;
            } else if (longestChainStartingFromChild > secondLongestChain) {
                secondLongestChain = longestChainStartingFromChild;
            }
        }
        longestPath = Math.max(longestPath, longestChain + secondLongestChain + 1);
        return longestChain + 1;
    }
}