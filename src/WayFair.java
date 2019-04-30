public class WayFair {
    public static void main(String [] args){
        WayFair wayFair = new WayFair();
        int [] A = {-8, 4, 0 ,5, -3, 6};
        System.out.println(wayFair.solution(A));
    }
    public int solution(int [] A){
        int max = Integer.MIN_VALUE;
        int bestSoFar = Integer.MIN_VALUE;
        int indexOfBestSoFar = 0;
        for(int i=0; i<A.length; i++){
            if(A[i] > bestSoFar + i - indexOfBestSoFar){
                    bestSoFar = A[i];
                    indexOfBestSoFar = i;
            }
             max = Math.max(max, 2*A[i]);
            max = Math.max(max, A[i] + bestSoFar + i - indexOfBestSoFar);
        }
        return max;
    }
}
 