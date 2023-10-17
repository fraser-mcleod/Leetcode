class Solution {
    public static void main(String[] args){
        // Test 1
        int a1[] = {3, 5, 8, 8, 28, 0, 0, 0, 0, 0};
        int a2[] = {4, 4, 7, 9, 21};
        merge(a1, 5, a2, 5);
        for (int i=0; i<a1.length-1;i+=1){
            if (a1[i] > a1[i+1]){
                System.out.println("Error in set a:");
                for (int j=0; j< a1.length; j+=1){
                    System.out.print(Integer.toString(a1[j])+ ", ");
                }
            }
        }
        // Test 2
        int b1[] = {100, 105, 106, 107, 108, 0,0, 0, 0};
        int b2[] = {4, 4, 7, 9};
        merge(b1, 5, b2, 4);
        for (int i=0; i<b1.length-1;i+=1){
            if (b1[i] > b1[i+1]){
                System.out.println("Error in set b:");
                for (int j=0; j< b1.length; j+=1){
                    System.out.print(Integer.toString(b1[j])+ ", ");
                }
            }
        }
        // Test 3
        int c1[] = {10, 15, 22, 22, 0, 0, 0, 0, 0};
        int c2[] = {100, 105, 106, 107, 108};
        merge(c1, 4, c2, 5);
        for (int i=0; i<c1.length-1;i+=1){
            if (c1[i] > c1[i+1]){
                System.out.println("Error in set c:");
                for (int j=0; j< c1.length; j+=1){
                    System.out.print(Integer.toString(c1[j])+ ", ");
                }
            }
        }




    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int a = m-1;
        int b = n-1;
        int c = m+n-1;

        while (b>=0){
            if ((a>=0) && (nums1[a] > nums2[b])){
                nums1[c] = nums1[a];
                a -= 1;
            } else {
                nums1[c] = nums2[b];
                b -= 1;
            }
            c -= 1;
        }


    }


}