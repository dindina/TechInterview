package apple.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsOfANumber_1 {

    public static void main(String[] args) {

        String str = "283";
        System.out.println(new LetterCombinationsOfANumber_1().phoneType(str));
    }

    List<String> phoneType(String digits)
    {
         List<String> result = new ArrayList<>();
         int index=0;
         HashMap<Character,String> map = new HashMap<>();
         map.put('0',"0");
            map.put('1',"1");map.put('2',"abc");map.put('3',"def");map.put('4',"ghi");
             map.put('5',"jkl");map.put('6',"mno");map.put('7',"pqrs");map.put('8',"tuv");map.put('9',"wxyz");
          backtrack(digits,index,map,result,new StringBuilder());

         return result;
    }

    private void backtrack(String digits,int index,HashMap<Character,String> map, List<String> result, StringBuilder stringBuilder) {
        if(index == digits.length())
        {
            result.add(stringBuilder.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));

        //System.out.println(letters);
        for(int i=0; i< letters.length() ; i++)
        {
            stringBuilder.append(letters.charAt(i));
            backtrack(digits,index+1,map,result,stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }



    }

}
