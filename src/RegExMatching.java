public class RegExMatching {
    public static void main(String [] args){
        RegExMatching regExMatching = new RegExMatching();
        System.out.println(regExMatching.isMatch("foob", "fo*b"));
    }
    public boolean isMatch(String input, String pattern){
        return helper(input, pattern, "");
    }
    public boolean helper(String input, String pattern, String previousPattern){
        if(pattern.length()==0){
            return input.length()==0;
        }
        if(pattern.length()==1){
            return input.length()==1 && isConcreteMatch(input, pattern);
        }
        if(pattern.charAt(0) == '*'){
            return helper(input, pattern.substring(1), "") ||
                    helper(input, previousPattern + pattern, previousPattern);

        }
        return helper(input.substring(1), pattern.substring(1), previousPattern + pattern.charAt(0));
    }
    public boolean isConcreteMatch(String input, String pattern){
        return input.charAt(0) == pattern.charAt(0) || pattern.charAt(0)=='.';
    }
}
