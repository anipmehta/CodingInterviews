public class AnagramPalindrome {
    public static void main(String [] args){
        AnagramPalindrome anagramPalindrome = new AnagramPalindrome();
        System.out.println(anagramPalindrome.checkPalindrome("aba"));
    }
    public boolean checkPalindrome(String string){
        int [] freq = new int[26];
        for(char ch : string.toCharArray()){
            freq[ch - 'a']++;
        }
        boolean oddChar = false;
        for(int i : freq){
            if(i%2!=0){
                if(oddChar){
                    return false;
                }
                else{
                    oddChar = true;
                }
            }

        }

        return true;
    }

}
