class Solution {
    int[][] matrix;
    int target;
    public boolean searchMatrix(int[][] matrix, int target) {
        this.target=target;
        this.matrix=matrix;
        if(matrix==null || matrix.length==0){
            return false;
        }
        return searchRec(0, 0, matrix[0].length-1, matrix.length-1);
        
    }
    public boolean searchRec(int left, int top, int right, int bottom){
        if(left > right || top > bottom){
            return false;
        }
        else if(target < matrix[top][left] || target > matrix[bottom][right]){
            return false;
        }
        
        int mid=(left + right)/2;
        int row=top;
        while(row <= bottom && matrix[row][mid]<=target){
            if(matrix[row][mid]==target){
                return true;
            }
            row++;
        }
        return searchRec(left, row, mid-1, bottom ) || searchRec(mid+1, top, right, row-1);
    }
}