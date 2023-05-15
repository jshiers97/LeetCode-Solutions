class Solution {
    public int kthGrammar(int n, int k) {
        
        if( n == 1 ){
            // Base case
            return 0;
        }
        
        // General cases
        if( k % 2 == 0 ){
            //  even index of current level is opposite of parent level's [(K+1)//2]
            return 1 - kthGrammar( n-1, (k+1) /2);
            
        }else{
            // odd index of current level is the same as parent level's [(K+1)//2]
            return kthGrammar( n-1, (k+1) / 2 );
        }
    }
}