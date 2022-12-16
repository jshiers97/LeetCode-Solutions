class Solution {
    TrieNode root;
    char[][] board;
    int m;
    int n;
    List<String> output;
    int[][] DIRECTIONS;
    public List<String> findWords(char[][] board, String[] words) {
        this.root=new TrieNode();
        this.board=board;
        this.m=board.length;
        this.n=board[0].length;
        this.DIRECTIONS=new int[][]{ {0, 1}, {1, 0}, {-1, 0}, {0, -1} };
        this.output=new ArrayList<>();
        
        //construct Trie
        for(String word: words){
            TrieNode curr=root;
            for(char c: word.toCharArray()){
                if(!curr.children.containsKey(c)){
                    curr.children.put(c, new TrieNode());
                }
                
                curr=curr.children.get(c);

            }
            
            curr.isLeaf=true;
            curr.fullWord=word;
        }
        TrieNode start=root;
        //we have prefix tree, now see if each word is in graph using trie
        
        
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                char current=board[i][j];
                if(start.children.containsKey(current)){
                    
                    dfs(i, j, start);
                }
            }
        }
        return output; 
        
    }
    
    public void dfs(int i, int j, TrieNode current){
        char c=board[i][j];
        TrieNode node=current.children.get(c);
        
        if(node.isLeaf){
            output.add(node.fullWord);
            node.isLeaf=false;
        }
        board[i][j]='0';
        for(int[] direction: DIRECTIONS){
            int newRow=i+direction[0];
            int newCol=j+direction[1];
            if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || !node.children.containsKey(board[newRow][newCol])){
                continue;
            }
            if(node.children.containsKey(board[newRow][newCol])){
                dfs(newRow, newCol, node);
            }
            
            
        }
        board[i][j]=c;
        
    }
        
        
        
    public class TrieNode{
        Map<Character, TrieNode> children;
        char c;
        boolean isLeaf;
        String fullWord;
        public TrieNode(){
            this.children=new HashMap<>();
            
            this.isLeaf=false;
            this.fullWord=null;
        }
    }
}