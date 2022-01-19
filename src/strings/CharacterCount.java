package strings;

public class CharacterCount {
    public static void main(String[] args) {
        String str = "dineshdinesh";

        int [] charCount = new int[256];
        for(char ch : str.toCharArray()) {
            System.out.println(ch);
            charCount[ch] ++;
            //System.out.println("character " + ch + "its count " + charCount[ch] );
        }

        for(int t =0 ; t < charCount.length ; t++)
            if(charCount[t] >0)
            System.out.println("character " + (char)t + " its count " + charCount[t] );


    }
}
