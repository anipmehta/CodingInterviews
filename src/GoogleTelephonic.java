public class GoogleTelephonic {
    public static void main(String [] args){
        GoogleTelephonic googleTelephonic = new GoogleTelephonic();
        System.out.println(googleTelephonic.canTransform("XXXXXLXXXX", "LXXXXXXXXX"));
    }
    public boolean canTransform(String start, String end) {
        return helper(start, end, 0);
    }
    public boolean helper(String start, String end, int index){
        boolean flag1=false, flag2=false;
        if(start.equals(end)){
            return true;
        }
        if( index >= start.length()-1){
            return false;
        }
        if(start.charAt(index)=='R' && start.charAt(index+1)=='X'){
            char [] chars = start.toCharArray();
            chars[index] = 'X';
            chars[index+1] = 'R';
            flag1 = helper(new String(chars), end, 0);
        }
        if(start.charAt(index)=='X' && start.charAt(index+1)=='L'){
            char [] chars = start.toCharArray();
            chars[index] = 'L';
            chars[index+1] = 'X';
            flag2 =  helper(new String(chars), end ,0);
        }
        return flag1 || flag2 || helper(start, end, index+1);
    }
}
