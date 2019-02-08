import java.util.HashMap;
import java.util.Map;

public class GoogleQ5 {
    public static void main(String [] args){
        int [] A ={-1, 0, 0, 1, 1, 2};
        int D = 2;
        int [] output = solution(D, A);

       System.out.println("Hello");
    }
   public static int [] solution(int D, int [] A){
       Map<Integer, Integer> map = new HashMap<>();
       for(int i=0;i<A.length;i++){
           map.put(i, A[i]);
       }
       int [] output = new int[A.length];
       for(int i=0;i<A.length;i++){
           output[i] = ancestor(i, map, D);
       }
       return output;
   }
   public static int ancestor(int node, Map<Integer, Integer> tree, int D){
        if(D==0){
            return node;
        }
       int parent = tree.get(node);
       if(parent==-1){
           return -1;
       }
       return ancestor(parent, tree, D-1);
   }
}
