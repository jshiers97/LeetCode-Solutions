class Trie {

    class TrieNode{
        char c;
        boolean terminal;
        Map<Character, TrieNode> children;
        public TrieNode(){
            this.children=new HashMap<>();
            this.terminal=false;
        }
    }
    TrieNode root;
    public Trie() {
        this.root=new TrieNode();
        
        
    }
    
    public void insert(String word) {
        TrieNode temp=root;
        for(char c: word.toCharArray()){
            if(!temp.children.containsKey(c)){
                temp.children.put(c, new TrieNode());
                //temp=children.get(c);
            }
            temp=temp.children.get(c);
        }
        temp.terminal=true;
    }
    
    public boolean search(String word) {
        TrieNode temp=root;
        for(char c: word.toCharArray()){
            if(!temp.children.containsKey(c)){
                return false;
            }
            else{
                temp=temp.children.get(c);
            }
        }
        return temp.terminal;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode temp=root;
        for(char c: prefix.toCharArray()){
            if(!temp.children.containsKey(c)){
                return false;
            }
            else{
                temp=temp.children.get(c);
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */