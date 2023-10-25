/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int left=0; 
        int top=0; 
        int bottom=m-1;
        int right=n-1; 
        Node root=recurse(grid, top, bottom, left, right); 
        return root; 
        
    }
    public boolean allSame(int[][] grid, int top, int bottom, int left, int right){
        int first=grid[top][left];
        for(int i=left; i<=right; i++){
            for(int j=top; j<=bottom; j++){
                if(grid[j][i]!=first){
                    return false;
                }
            }
        }
        return true;
    }
    public Node recurse(int[][] grid, int top, int bottom, int left, int right){
        if(allSame(grid, top, bottom, left, right)){
            boolean val=grid[top][left]==1 ? true : false; 
            Node node=new Node(val, true); 
            //node.isLeaf=true;
            
            return node; 
        }
        else{
            int midC=(left + right) /2; 
            int midR=(top + bottom )/2; 
            Node n=new Node(true, false); 
            n.topLeft=recurse(grid, top, midR, left, midC);
            n.topRight=recurse(grid, top, midR, midC+1, right);
            n.bottomLeft=recurse(grid, midR+1, bottom, left, midC);
            n.bottomRight=recurse(grid, midR+1, bottom, midC+1, right );
            
            return n;
            

    
        }
    }
        
}