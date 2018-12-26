package twilio.build_office;

public class BuildOffices {
    public static void main(String [] args) {
        int row=3;
        int col=3;
        int [][] grid = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                grid[i][j] = -1;
            }
        }
        int min = placeOffices(grid, 1, Integer.MAX_VALUE);
        System.out.println(min);
    }
    public static int placeOffices(int [][] grid, int n, int min){
        if(n==0){
            min = Math.min(maxOfMinDistanceFromZero(grid), min);
            return min;
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0) continue;
                grid[i][j] = 0;
                min = Math.min(placeOffices(grid, n-1, min), min);
                grid[i][j] = -1;
            }
        }
        return min;
    }

    public static int maxOfMinDistanceFromZero(int [][] grid){
        int maxOfMinDistances = Integer.MIN_VALUE;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int minDistance = Integer.MAX_VALUE;
                boolean [][] visited = new boolean[grid.length][grid[0].length];
                minDistance = minDistanceFromZero(i, j, minDistance, i,j, grid, visited);
                maxOfMinDistances = Math.max(maxOfMinDistances, minDistance);
            }
        }
        return maxOfMinDistances;
    }

    public static int minDistanceFromZero(int startRow, int startCol, int minDistance, int currRow, int currCol, int [][] grid, boolean[][] visited){
        if(isNotValid(currRow, currCol, grid) || visited[currRow][currCol]){
            return minDistance;
        }
        if(Math.abs(startRow-currRow) + Math.abs(startCol-currCol)>minDistance){
            return minDistance;
        }
        if(grid[startRow][startCol]==0)return 0;
        visited[currRow][currCol] = true;
        if(grid[currRow][currCol]==0 && !(currCol==startCol && currRow==startRow)){
            minDistance = Math.min(minDistance, Math.abs(startRow-currRow) + Math.abs(startCol-currCol));
            return minDistance;
        }
        int top = minDistanceFromZero(startRow, startCol, minDistance, currRow - 1, currCol, grid,visited);
        int left = minDistanceFromZero(startRow, startCol, minDistance, currRow, currCol - 1, grid, visited);
        int down = minDistanceFromZero(startRow, startCol, minDistance, currRow + 1, currCol, grid, visited);
        int right = minDistanceFromZero(startRow, startCol, minDistance, currRow, currCol + 1, grid, visited);
        return Math.min(top,Math.min(left, Math.min(down,right)));
    }
    public static boolean isNotValid(int row, int col, int [][] grid) {
        return row<0 || col<0 || row>grid.length-1 || col>grid[0].length-1;
    }
}
