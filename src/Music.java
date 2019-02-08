public class Music {
    public static void main(String [] args){
        numOfPlaylist(1, 0, 3);
    }
    public static int numOfPlaylist(int N, int K, int L){
        if(N-K<=0){return 0;}
        int tmp = N;
        long playlist = 0;
        playlist = N;
        for(int i=0;i<=K-1;i++){
            playlist = N*(N-i);
        }
        playlist = playlist%1000000007;
        return (int) playlist;
    }
}
