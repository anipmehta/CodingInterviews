public class KnightDialer{
    public static void main(String [] args){
        System.out.println(countAllNumbers(1));
    }
    public static int countAllNumbers(int hops){
        int [][] dialer = new int[4][3];
        for(int i=1;i<=3;i++){
            for(int j=1;j<=3;j++){
                dialer[i-1][j-1] = i+j;
            }
        }
        dialer[4][0] = -1;
        dialer[4][1] = 0;
        dialer[4][2] = -1;
        int count = 0;
        for(int i=1;i<=3;i++){
            for (int j=1;j<=3;j++){
                count += helper(dialer, hops, i-1, j-1);
            }
        }

        return count;
    }

    private static int helper(int[][] dialer, int hops, int row, int col) {
        if(hops==0){
            return 1;
        }
        if(row<0 || col<0 || row>3 || col>=3){
            return 0;
        }
        if(dialer[row][col]==-1){
            return 0;
        }

        int [] X = {2,2,-2,-2,-1,1,1,-1};
        int [] Y = {-1,1,1,-1,2,2,-2,-2};
        int count = 0;
        for(int i=0;i<X.length;i++){
            int nextRow = row + X[i];
            int nextCol = col + Y[i];
            count += helper(dialer, hops-1,  nextRow, nextCol);
        }
        return count;
    }

}
