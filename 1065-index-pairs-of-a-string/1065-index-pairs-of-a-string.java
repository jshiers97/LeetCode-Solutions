class Solution {
    
    class TrieNode{
        public boolean flag;
        public Map<Character, TrieNode> next=new HashMap<>(); 
    }
    
    class Trie{
        public TrieNode root;
        public Trie(){
            root=new TrieNode(); 
        }
        public void insert(String words){
            TrieNode curr=root; 
            for(int i=0; i<words.length(); i++){
                char c=words.charAt(i); 
                if(curr.next.get(c)==null){
                    curr.next.put(c, new TrieNode());
                }
                curr=curr.next.get(c);
                
            }
            curr.flag=true;
        }
    }
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> list=new ArrayList<>(); 
        Trie root=new Trie(); 
        for(String str: words){
            root.insert(str); 
        }
        for(int i=0; i<text.length(); i++){
            TrieNode curr=root.root; 
            for(int j=i; j<text.length(); j++){
                if(curr.next.get(text.charAt(j))==null){
                    break;
                }
                curr=curr.next.get(text.charAt(j)); 
                if(curr.flag){
                    list.add(new int[]{i, j});
                }
            }
        }
        int[][] ans=new int[list.size()][2];
        ans=list.toArray(ans); 
        return ans;
    }
}