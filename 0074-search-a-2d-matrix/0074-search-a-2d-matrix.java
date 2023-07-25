class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int left=0;
        int m=matrix.length;
        System.out.println(m);
        int n=matrix[0].length;
        int right=n-1; 
        int top=0; 
        int bottom=m-1; 
        while(top<=bottom){
            int mid=(top+bottom)/2;
            
            if(target>= matrix[mid][left] && target<= matrix[mid][right]){
                while(left<=right){
                    int midC=(left+right); 
                    if(matrix[mid][midC]==target){
                        return true;
                    }
                    else if(matrix[mid][midC] > target){
                        right=midC-1;
                    }
                    else{
                        left=midC+1; 
                    }
                }
                return false;
            }
            else if(target < matrix[mid][left]){
                bottom=mid-1;
                
            }
            else{
                System.out.println("here");
                top=mid+1;
            }
        }
        return false;
    }
}