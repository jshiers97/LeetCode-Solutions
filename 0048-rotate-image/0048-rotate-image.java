class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length; 
        for(int i=0; i<n/2; i++){
            System.out.println("n is " + i); 
            for(int j=i; j<n-1-i; j++){
                //top left to top right
                int temp=matrix[j][n-1-i];
                System.out.println(temp); 
                matrix[j][n-1-i]=matrix[i][j];
                //System.out.println(matrix[j][n-1-i]);
                
                //top right to bottom right; 
                int temp2=matrix[n-1-i][n-1-j];
                System.out.println(temp2);
                matrix[n-1-i][n-1-j]=temp;
                temp=temp2;
                
                //bottom right to bottom left
                temp2=matrix[n-1-j][i];
                int x=n-1-j;
                System.out.println(temp2 );
                matrix[n-1-j][i]=temp;
                temp=temp2;
                
                //bottom left to top left
                matrix[i][j]=temp;
            }
            for(int[] arr: matrix){
                for(int x: arr){
                    System.out.print(x + " ");
                }
                System.out.println(" ");
            }
        }
    }
}