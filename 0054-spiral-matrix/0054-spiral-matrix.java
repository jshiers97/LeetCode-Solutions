class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length; //rows
        int n=matrix[0].length; // columns
        int left=0;
        int right=n;
        int top=0;
        int bottom=m; 
        List<Integer> output=new ArrayList<>();
        while(left < right && top < bottom){
            //top left to top right;
            for(int i=left; i<right; i++){
                output.add(matrix[top][i]);
            }
            
            top++;
            
            //top right to bottom right
            for(int i=top; i< bottom; i++){
                output.add(matrix[i][right-1]);
            }
            
            right--;
            if(top==bottom || right==left){
                break;
            }
            //bottom right to bottom left
            for(int i=right-1; i>=left; i--){
                output.add(matrix[bottom-1][i]);
            }
            System.out.println(output.get(output.size()-1));
            bottom --;
            
            for(int i=bottom-1; i>=top; i--){
                output.add(matrix[i][left]);
            }
            System.out.println(output.get(output.size()-1));
            left++;
        }
        return output; 
        
    }
}