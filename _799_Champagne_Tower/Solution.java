import java.lang.Math.*;

class Solution {
    public static void main(String[] args){
        int poured = 1;
        int qr = 1;
        int qg = 1;
        double expected = 0;
        double result = champagneTower(poured, qr, qg);
        if (result != expected){
            System.err.printf("Error: expected: %d but got: %d. The tower is: ", expected, result);
            visualize(poured, qr);
        }

        poured = 180;
        qr = 4;
        qg = 3;
        expected = 42.5;
        result = champagneTower(poured, qr, qg);
        if (result != expected){
            System.err.printf("Error: expected: %f but got: %f. The tower is: \n", expected, result);
            visualize(poured, qr);
        }

        poured = 100;
        qr = 7;
        qg = 3;
        expected = 1.0;
        result = champagneTower(poured, qr, qg);
        if (result != expected){
            System.err.printf("Error: expected: %f but got: %f. The tower is: \n", expected, result);
            // visualize(poured, qr);
        }

        poured = 100000009;
        qr = 33;
        qg = 17;
        expected = 1.0;
        result = champagneTower(poured, qr, qg);
        if (result != expected){
            System.err.printf("Error: expected: %f but got: %f. The tower is: \n", expected, result);
            // visualize(poured, qr);
        }

    }
    public static double champagneTower(int poured, int query_row, int query_glass) {
        // create space for two rows we will need. Note we could optimize 100 to be slightly better
        double rowA[] = new double[100];
        double rowB[] = new double[100];
        rowA[0] = poured;
        int j = 1;
        while (j <= query_row){

            if (j%2!=0){
                // System.out.println(arrayToString(rowB));
                // System.out.println(arrayToString(rowA));
                // calculate row B
                for (int i=0; i < j+1; i++){
                    if (i == 0){
                        rowB[i] = (Math.max(rowA[i]-1, 0))/2.0;
                    } else {
                        rowB[i] = (Math.max(rowA[i-1]-1, 0))/2.0 + (Math.max(rowA[i]-1, 0))/2.0;
                    }

                }
            } else {
                // calculate row A
                for (int i=0; i < j+1; i++){
                    if (i == 0){
                        rowA[i] = (Math.max(rowB[i]-1, 0))/2.0;
                    } else {
                        rowA[i] = (Math.max(rowB[i-1]-1, 0))/2.0 + (Math.max(rowB[i]-1, 0))/2.0;
                    }

                }
            }
            j++;
        }
        if (query_row%2 != 0){
            return Math.min(1, rowB[query_glass]);
        } else {
            return Math.min(1, rowA[query_glass]);
        }
    }
    public static String arrayToString(double[] a){
        String out = "[";
        for (int i = 0; i< a.length; i++){
            if (a[i] == 0){
                break;
            }
            out += String.valueOf(a[i]) + ", ";
        }
        out = out + "]";
        return out;
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