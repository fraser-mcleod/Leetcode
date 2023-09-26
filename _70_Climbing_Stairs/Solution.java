class Solution {
    public static void main(String[] args){
        int n = Integer.parseInt(args[0]);
        System.out.println(climbStairs(n));
    }
    public static int climbStairs(int n) {
        // Base cases:
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        if (n == 3){
            return 3;
        }
        if (n == 4){
            return 5;
        }
        if (n == 5){
            return 8;
        }
        if (n == 6){
            return 13;
        }
        // Clear fibonacci sequence - more if statements could lead to slightly faster results
        return climbStairs(n-1) + climbStairs(n-2);
    }
}