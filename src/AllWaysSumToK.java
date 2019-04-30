public class AllWaysSumToK {
    public static void main(String [] args){
        AllWaysSumToK.allWaysSumToK("123", 6);
    }
    public static void allWaysSumToK(String number, int K){
        helper(number, K, 0, "", "");
    }

    private static void helper(String number, int k, int sum, String equation, String carry){
        if(number.length() == 0){
            if(sum == k && carry.length()==0){
                System.out.println(equation  + " = " + k);
            }
            return;
        }
        int value = Integer.parseInt(carry + number.charAt(0));
        helper(number.substring(1), k, sum - value, equation + "-" + value, "");
        String newEquation = equation!="" ? equation + "+" + value : equation + value;
        helper(number.substring(1), k, sum + value, newEquation, "");
        helper(number.substring(1), k, sum, equation, carry + number.charAt(0));
    }
}
