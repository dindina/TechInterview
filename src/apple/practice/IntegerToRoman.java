package apple.practice;

public class IntegerToRoman {
    public static void main(String[] args) {
        int num = 9;
        System.out.println(new IntegerToRoman().convert(num));

    }

    private String convert(int num) {
        String result="";
        String[] symbols = new String []{
                "P","M","D","C","L" ,"X","IV","V","I"
                };
        int [] values = new int[]{
                1000000,1000,500,100,50,10,4,5,1
        };
        // iterate all the values and keep using it if needed
        for(int i=0; i< values.length && num >0 ; i++ )
        {
            while(num >= values[i])
            {
                num = num - values[i];
                result+=symbols[i];
            }
        }
        return result;
    }
}
