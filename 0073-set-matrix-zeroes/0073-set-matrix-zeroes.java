class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row=false;
        boolean col=false;
        //check all rows start
        if(matrix[0][0]==0){
            row=true;
            col=true;
        }
        else{
            for(int i=0; i<matrix.length; i++){
                if(matrix[i][0]==0){
                    row=true;
                }
            }
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[0][j]==0){
                    col=true;
                }
            }
        }
        
        
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        //System.out.println(matrix[0][2]);
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                System.out.println(i + " " + j);
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    System.out.println("here");
                    matrix[i][j]=0;
                }
            }
        }
        if(row){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0]=0;
            }
        }
        if(col){
            for(int j=0; j<matrix[0].length; j++){
               matrix[0][j]=0;
            }
        }
        
    }
}