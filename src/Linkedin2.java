public class Linkedin2 {
    public static void main(String [] args){
        System.out.println(getShiftedString("abcd", 2, 2));
    }
public static String getShiftedString(String s, int leftShifts, int rightShifts){
    StringBuilder str = new StringBuilder("");
    char [] arr = s.toCharArray();
    String temp = s;
    while(leftShifts>0){
        char temporaryChar = temp.charAt(temp.length() - 1);

        // Store the character with the original String. Character first
        temp = temporaryChar + temp;

        // Now that we did that, the string is 1 character longer so we need to take a substring of it
        temp = temp.substring(0, temp.length()-1);
      leftShifts--;
    }
    while(rightShifts>0){
        temp = rightShift(temp);
        rightShifts--;
    }
    return temp;
}
    public static String rightShift(String s) {
        return s.charAt(s.length()-1)+s.substring(0, s.length()-1);
    }
    public static String leftShift(String s) {
        return s.substring(1) + s.charAt(0);
    }
}


