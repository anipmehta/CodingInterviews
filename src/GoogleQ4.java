public class GoogleQ4 {
    public static void main(String [] args) {
    int [] A = {1,2,3,4,4,5};
    int count = solution(A);
    System.out.println(count);
    }

    public static int solution(int [] A){
        int basket1 = -1;
        int basket2 = -1;
        int count=0;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            basket1 = A[i];
            count++;
            for(int j=i+1;j<A.length;j++){
                if(A[j]==basket1 || A[j]==basket2){
                    count++;
                }
                else if(basket2==-1){
                    basket2 = A[j];
                    count++;
                }
                else{
                    basket2=-1;
                    break;
                }
            }
            max = Math.max(max, count);
            count=0;
        }
        return max;
    }
    }

