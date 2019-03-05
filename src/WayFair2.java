public class WayFair2 {
    public static void main(String [] args){
        WayFair2 wayFair2 = new WayFair2();
        System.out.println(wayFair2.solution("011100"));
    }
    public int solution(String s) {
       int index = 0;
       int count = 0;
       while(s.charAt(index)=='0'){
           index++;
       }
       s = s.substring(index);

       while (s.length()>1){
           index = s.length()-1;
           if(s.charAt(index)=='0'){
               s = s.substring(0,index);
           }
           else {
               s = s.substring(0,index) + '0';
           }
           count++;
       }
       if(s.charAt(0)=='1'){
           count++;
       }
       return count;
    }
}
