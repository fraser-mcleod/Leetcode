import java.lang.Math.*;

class Solution {
    public static void main(String[] args){
        int poured = Integer.parseInt(args[0]);
        int query_row = Integer.parseInt(args[1]);
        int query_glass = Integer.parseInt(args[2]);
        visualize(poured, 10);
        // champagneTower(poured, query_row, query_glass);
        // champagneTower(1, 1, 1);
    }
    public static double champagneTower(int poured, int query_row, int query_glass) {
        double result = pouredIn(poured, query_row, query_glass);
        if (result > 1){
            System.out.println(1);
            return 1;
        }
        System.out.println(result);
        return result;
    }

    public static void visualize(int glasses, int rows){
        for (int i=0; i <= rows; i+=1){
            for (int j=0; j<= i; j+=1){
                String result = String.valueOf(pouredIn(glasses, i, j)-1);
                System.out.print("|"+result+"|, ");
            }
            System.out.print("\n");
        }
    }

    public static double pouredIn(double poured, int query_row, int query_glass){
        if (query_row == 0 && query_glass == 0){
            return poured;
        }

        if (poured <= 0){
            return 0;
        }

        if (query_glass > 0){
            if (query_glass < query_row){
                // left and right
                return Math.max(0.0, 0.5*(pouredIn(poured, query_row-1, query_glass-1)-1) + 0.5*(pouredIn(poured, query_row-1, query_glass)-1));
            } else {
                // left parent only
                return Math.max(0,0.5*(pouredIn(poured, query_row-1, query_glass-1)-1));
            }
        } else {
            // right parent only
            return Math.max(0, 0.5*(pouredIn(poured, query_row-1, query_glass)-1));
        }
    }
}