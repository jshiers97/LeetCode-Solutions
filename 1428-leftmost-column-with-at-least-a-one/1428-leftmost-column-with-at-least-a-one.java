/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int m=binaryMatrix.dimensions().get(0); 
        int n=binaryMatrix.dimensions().get(1); 
        
        
        List<Integer> rs=new ArrayList<>();
        for(int i=0; i<m; i++){
            if(binaryMatrix.get(i, n-1)==1){
                rs.add(i);
            }
        }
        if(rs.size()==0){
            return -1; 
        }
       
        int right=n-1; 
        int min=n-1; 
        for(int x: rs){
            int left=0;
            right=min;
            
            while(left <= right){
                int mid=(left+right)/2;
                if(binaryMatrix.get(x, mid)==1){
                   
                    min=Math.min(mid, min); 
                    right=mid-1;
                }
                else{
                    left=mid+1; 
                }
            }
            
        }
        
        return min;
    }
}