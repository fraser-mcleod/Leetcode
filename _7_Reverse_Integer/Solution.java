
public class Solution {
    public static void main(String[] args){
        Solution tests = new Solution();
        System.out.println("Input: -123");
        System.out.println(tests.reverse(-123));
        System.out.println("Input: -1234");
        System.out.println(tests.reverse(-1234));
        System.out.println("Input: -123456789");
        System.out.println(tests.reverse(-123456789));
        System.out.println("Input: 1534236469");
        System.out.println(tests.reverse(1534236469));

    }
    public int reverse(int x) {
        String s1 = String.valueOf(x);
        String s2 = "";
        boolean isPos = true;
        for (int i = 0; i < s1.length(); i+=1){
            if (s1.charAt(i) == '-'){
                isPos = false;
            } else {
                s2 = s1.charAt(i) + s2;
            }

        }
        if (! isPos){
            s2 = "-" + s2;
        }
        // Check if s2 is valid int then convert to int
        int result = 0;
        try {
            System.out.println(s2);
            result = Integer.parseInt(s2);

        } catch (NumberFormatException e){
            return 0;
        }
        return result;
    }
}
