package apple.practice;

import java.util.ArrayList;
import java.util.List;

/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]

Example 2:
Input: n = 1
Output: ["()"]
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        int open =0;
        int close =0;
        int max =n;
        backtrack(new StringBuilder(),result, open ,  close ,  max);
        return result;

    }

    private void backtrack(StringBuilder s, List<String> result , int open ,int close , int max) {
            if(s.length() == max*2)
            result.add(s.toString());

            if( open < max)
            {
                s.append("(");
                backtrack(s,result,open+1,close,max);
                s.deleteCharAt(s.length()-1);
            }
            if ( close < open)
            {
                s.append(")");
                backtrack(s,result,open,close+1,max);
                s.deleteCharAt(s.length()-1);
            }
    }

    public static void main(String[] args) {
        int n=3;
        System.out.println(new GenerateParentheses().generateParenthesis(n));
    }

}
