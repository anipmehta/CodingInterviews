import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class KnightSequence{
    public static void main(String [] args){
        KnightSequence knightSequence = new KnightSequence();
        System.out.println(knightSequence.count(5   ));
    }
    int count(int n){
        int ways = 0;
        int [][] board = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = 0;
                ways += canTour(n, i, j, new LinkedHashSet<>(), board);
            }
        }
        return ways;
    }
    public int canTour(int N, int row, int col, Set<String> set, int [][] board){
        if(set.size() ==  N*N){
            return 1;
        }
        int [] coord = {row, col};
        String location = Arrays.toString(coord);
        set.add(location);
        int totalWays = 0;
        int [] X = {2,2,-2,-2,-1,1,1,-1};
        int [] Y = {-1,1,1,-1,2,2,-2,-2};
        for(int i=0;i<X.length;i++) {
            int nextRow = row + X[i];
            int nextCol = col + Y[i];
            if(isValid(board, nextRow, nextCol)){
                String nextLocation = Arrays.toString(new int []{nextRow, nextCol});
                board[nextRow][nextCol] = set.size();
                totalWays += canTour(N, nextRow, nextCol, set, board);
                set.remove(nextLocation);
                board[nextRow][nextCol] = 0;
            }

        }
        return totalWays;
    }
    public boolean isValid(int [][] board, int row, int col){
       return !(row<0 || col<0 || row>=board.length || col>=board[row].length || board[row][col]!=0);
    }
}
