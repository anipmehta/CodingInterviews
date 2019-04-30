public class WayFair2 {
    public static void main(String [] args){
        WayFair2 wayFair2 = new WayFair2();
        System.out.println(wayFair2.solution("011100"));
    }
    public int solution(String S) {
       int index = 0;
       int count = 0;
       while(S.charAt(index)=='0'){
           index++;
       }
       S = S.substring(index);

       while (S.length()>1){
           index = S.length()-1;
           if(S.charAt(index)=='0'){
               S = S.substring(0,index);
           }
           else {
               S = S.substring(0,index) + '0';
           }
           count++;
       }
       if(S.charAt(0)=='1'){
           count++;
       }
       return count;
    }
}
