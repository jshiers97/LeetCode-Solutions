class WordDictionary {

    class TrieNode{
        Map<Character, TrieNode> children;
        char c;
        boolean terminal;
        public TrieNode(){
            this.children=new HashMap<>();
        }
        
    }
    TrieNode root;
    public WordDictionary() {
        this.root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode temp=root;
        for(char c: word.toCharArray()){
            if(!temp.children.containsKey(c)){
                temp.children.put(c, new TrieNode());
            }
            
            temp=temp.children.get(c);
        }
        temp.terminal=true;
        
    }
    
    public boolean search(String word) {
        TrieNode temp=root;
        return helper(word, temp);
        
    }
    
    public boolean helper(String word, TrieNode current){
        if(word.length()==0){
            return current.terminal;
        }
        char c=word.charAt(0);
        if(c=='.'){
            boolean found=false;
            for(Character x: current.children.keySet()){
                
                found=found || helper(word.substring(1), current.children.get(x));
            }
            return found;
        }
        else{
            if(!current.children.containsKey(c)){
                return false;
            }
            else{
                return helper(word.substring(1), current.children.get(c));
            }
        }
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */