public class FacebookDecodeWays {
    public static void main(String [] args){
        FacebookDecodeWays facebookDecodeWays = new FacebookDecodeWays();
        System.out.println(facebookDecodeWays.helper("123"));
    }
    public int ways(String number){
        return helper(number);
    }

    private int helper(String number) {
        if(number.length()==0){
            return 1;
        }
//        if(number.length()==1){
//            return 1;
//        }
        int digit = number.charAt(0);
        int total = 0;
        if(number.length()>1 && (digit=='1' || (digit=='2' && number.charAt(1)<='6'))){
            total += helper(number.substring(2));
        }
        total += helper(number.substring(1));
        return total;
    }
}
