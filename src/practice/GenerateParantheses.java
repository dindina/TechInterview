package practice;

import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {
    public static void main(String[] args) {
        System.out.println("hellop");
        int n=3;
        System.out.println(new GenerateParantheses().generate(n));
    }

    private List<StringBuilder> generate(int n) {

        if(n==0) return null;
        List<StringBuilder> result = new ArrayList<>();
        int close=0;
        int open=0;
        backtraak(n,result,new StringBuilder(),close,open);
        return result;

    }

    private void backtraak(int max, List<StringBuilder> result, StringBuilder stringBuilder, int close, int open) {

        if(stringBuilder.length() == max*2)
        result.add(new StringBuilder(stringBuilder));

        if(open < max) {
            stringBuilder.append("(");
            backtraak(max, result, stringBuilder, close , open+1);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        if(close <open)
        {
            stringBuilder.append(")");
            backtraak(max, result, stringBuilder, close+1 , open);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

    }

}
