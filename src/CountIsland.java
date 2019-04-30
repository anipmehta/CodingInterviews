public class CountIsland{
    public static void main(String [] args){
        int [][] matrix = {{0,1,1},
                           {1,1,1},
                           {0,0,1}};
        CountIsland countIsland = new CountIsland();
        System.out.println(countIsland.countIsland(matrix));

    }
    public int countIsland(int [][] matrix){
        int count = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]==1){
                    count++;
                    dfs(matrix, i, j);
                }
            }
        }
        return count;
    }
    public void dfs(int [][] matrix, int row, int col){
        if(row<0 || col<0 || row>matrix.length-1 || col>matrix[row].length-1){
            return;
        }
        if(matrix[row][col] == 0){
            return;
        }
        matrix[row][col] = 0;
        int [] X = {-1,1,0,0};
        int [] Y = {0,0,-1,1};
        for(int i=0;i<X.length;i++){
            int newX = row + X[i];
            int newY = col + Y[i];
            dfs(matrix, newX, newY);
        }
    }
}
