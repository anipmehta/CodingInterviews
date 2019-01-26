import java.util.Arrays;

public class GoogleQ5Modified {
    public static void main(String [] args){
        GoogleQ5Modified googleQ5Modified = new GoogleQ5Modified();
        int [] A = {-1, 0, 1, 2, 3};
        System.out.println(Arrays.toString(googleQ5Modified.solution(2, A)));
    }
    public int [] solution(int D, int [] A){
        int[] output = new int[A.length];
        for(int i=0 ; i < A.length; i++){
            output[i] = findAncestor(D, A, i);
        }
        return output;
    }

    private int findAncestor(int D, int[] A, int node) {
        while(D>0){
            if(node==-1){
                return -1;
            }
            node = A[node];
            D--;
        }
        return node;
    }
}
