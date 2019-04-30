public class RegExMatchingFacebook{
    // a.b = adb
    // ab* = abb
    public static void main(String [] args){
        String word = "abbc";
        String pattern = "ab*c";
        RegExMatchingFacebook facebook = new RegExMatchingFacebook();
        System.out.println(facebook.isValidPattern(word, pattern));
    }
    public boolean isValidPattern(String word, String pattern){
        return helper(word, pattern);
    }

    public boolean helper(String word, String pattern){
        if(word.length() == 0 && pattern.length() == 0){
            return true;
        }
        if(word.length()==0 || pattern.length()==0){
            return false;
        }
        if(pattern.length()>1 && pattern.charAt(1)=='*'){
            return helper(word, pattern.substring(2)) ||(isMatch(word, pattern) &&  helper(word.substring(1), pattern));
        }
        return isMatch(word, pattern) && helper(word.substring(1), pattern.substring(1));
    }
    public boolean isMatch(String word, String pattern){
        return word.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.';
    }
}
