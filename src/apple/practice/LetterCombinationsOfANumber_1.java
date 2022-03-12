package apple.practice;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfANumber_1 {

    public static void main(String[] args) {

        String str = "23";
        System.out.println(new LetterCombinationsOfANumber_1().phoneType(str));
    }

    List<String> phoneType(String digits)
    {
         List<String> result = new ArrayList<>();
         int index=0;
         String[] map = new String[]{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
         backtrack(digits,index,map,result,new StringBuilder());

         return result;
    }

    private void backtrack(String digits,int index, String[] map, List<String> result, StringBuilder stringBuilder) {
        if(index == digits.length())
        {
            result.add(stringBuilder.toString());
            return;
        }
        String letters = map[digits.charAt(index)-'0'];

        System.out.println(letters);
        for(int i=0; i< letters.length() ; i++)
        {
            stringBuilder.append(letters.charAt(i));
            backtrack(digits,index+1,map,result,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }



    }

}
