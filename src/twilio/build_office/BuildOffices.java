package twilio.build_office;

public class BuildOffices {
    public static void main(String [] args) {
        System.out.println(buildOffices(3,3,1));
    }
    public static int buildOffices(int w, int h, int n){
        if(n==w*h){
            return 0;
        }
        if(n==1){
            return h/2 + w/2;
        }
        int [][] grid = new int[h][w];
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++){
                grid[i][j] = -1;
            }
        }
        return placeOffices(grid, n, Integer.MAX_VALUE);
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
        if(isNotValid(currRow, currCol, grid)){
            return minDistance;
        }
        if(visited[currRow][currCol]){
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
        int top = minDistanceFromZero(startRow, startCol, minDistance, currRow - 1, currCol, grid, visited);
        int left = minDistanceFromZero(startRow, startCol, minDistance, currRow, currCol - 1, grid, visited);
        int down = minDistanceFromZero(startRow, startCol, minDistance, currRow + 1, currCol, grid, visited);
        int right = minDistanceFromZero(startRow, startCol, minDistance, currRow, currCol + 1, grid, visited);
        return Math.min(top,Math.min(left, Math.min(down,right)));
    }
    public static boolean isNotValid(int row, int col, int [][] grid) {
        return row<0 || col<0 || row>grid.length-1 || col>grid[0].length-1;
    }
}
