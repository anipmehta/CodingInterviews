import java.util.ArrayList;
import java.util.List;

public class ChathamFinancial2 {
    public static void main(String [] args){
//        System.out.println(solution(123456));
//        System.out.println(solution(123451));
//        System.out.println(solution(3456));
//        System.out.println(solution(130));
//        System.out.println(solution(1000));
        System.out.println(solution(1050));
    }
    private static int number;
    public static int solution(int A) {
    // write your code in Java SE 8
        number = A;
        List<Integer> digits = new ArrayList<>();
        int digitsCount = countDigits(number);
        while (number>=10){
           int first = getFirstDigit();
           int last = getLastDigit();
           digits.add(first);
           digits.add(last);
        }
        digits.add(number);
        while(number==0 && digits.size()<digitsCount)
        digits.add(number);
        int finalNum = 0;
        for(int digit : digits){
            finalNum = finalNum *10 + digit;
        }
        return finalNum;
    }
    public static int getFirstDigit(){
        int divisor = 10;
        while (number/divisor >= 10){
            divisor = divisor*10;
        }
        int first = number/divisor;
        number = number%divisor;
        return first;
    }
    public static int getLastDigit(){
        int last =  number%10;
        number = number/10;
        return last;
    }
    public static int countDigits(int number){
        int count = 0;
        while (number!=0){
            number = number/10;
            count++;
        }
        return count;
    }
}
