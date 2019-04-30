public class MaximumSquareAll1 {
    public static void main(String [] args){
        int [][] matrix = {{1,1,1},
                           {0,0,0},
                           {1,1,1}};
        MaximumSquareAll1 maximumSquareAll1 = new MaximumSquareAll1();
        System.out.println(maximumSquareAll1.maxSquareAll1(matrix));
    }
    public int maxSquareAll1(int [][] matrix){
        int [][] dp = new int [matrix.length][matrix[0].length];
        dp[0] =matrix[0];
        for(int i=0;i<dp.length;i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i=0;i<dp[0].length;i++){
            dp[i][0] = matrix[i][0];
        }
        int maxArea = 0;
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                if(matrix[i][j]==1){
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j])) + 1;
                    maxArea = Math.max(dp[i][j], maxArea);
                }
                else{
                    dp[i][j] = 0;
                }
            }
        }
        return maxArea;
    }
}
