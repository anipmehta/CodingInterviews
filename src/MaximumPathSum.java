public class MaximumPathSum {
    /*
    matrix = [1,2,3]
             [4,5,6]
             [7,8,9]
     */

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                          {4, 5, 6},
                          {7, 8, 9}};
        MaximumPathSum maximumPathSum = new MaximumPathSum();
        System.out.println(maximumPathSum.maxSum(matrix));
    }
    public int maxSum(int [][] grid){
        return helper(grid, 0,0);
    }
    public int helper(int [][] grid, int row, int col){
        if(row<0 || col<0 || row>grid.length-1 || col>grid[row].length-1){
            return 0;
        }
        if(row==grid.length-1 && col==grid.length-1){
            return grid[row][col];
        }
        int right = helper(grid, row, col+1);
        int down = helper(grid, row+1, col);
        return grid[row][col] + Math.max(right, down);
    }
}