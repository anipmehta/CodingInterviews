package twilio.to_the_future;

public class Future {
    public static void main(String [] args){
        System.out.println(minDays(3, 5, 1));
    }
    public static int minDays(int A, int K, int P){
        if(A>=K){
            return -1;
        }
        int diff = K-A;
        int n = 1;
        while(n*diff<=P){
            n++;
        }
        return n;
    }
}
