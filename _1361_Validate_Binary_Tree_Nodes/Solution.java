import java.util.Queue;
import java.lang.reflect.Array;
import java.util.LinkedList;

class Solution {
    public static void main(String args[]){
        System.out.println("Test 1");
        System.out.println(validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1}));
        System.out.println("Test 2");
        System.out.println(validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, 3, -1, -1}));
        System.out.println("Test 3");
        System.out.println(validateBinaryTreeNodes(4, new int[]{3, -1, 1, -1}, new int[]{-1, -1, 0, -1}));
    }
    public static boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        boolean visited[] = new boolean[n];
        // find root
        for (int j=0; j<n;j+=1){
            if (leftChild[j]>=0){
                visited[leftChild[j]] = true;
            }
            if (rightChild[j]>=0){
                visited[rightChild[j]] = true;
            }
        }
        // root will be only unvisited node, if multiple, not a valid tree
        int root = -1;
        for (int j=0; j<n; j+=1){
            if (! visited[j]){
                if (root != -1){
                    return false;
                } else {
                    root = j;
                }
            }
            visited[j] = false;
        }


        Queue<Integer> queue = new LinkedList<>();
        queue.add(root);
        while (queue.peek() != null){
            int cur = queue.poll();
            // Have we see cur?
            if (visited[cur]){
                return false;
            } else {
                visited[cur] = true;
            }
            // Add cur's children to queue
            if (leftChild[cur] >= 0 ){
                queue.add(leftChild[cur]);
            }
            if (rightChild[cur] >= 0){
                queue.add(rightChild[cur]);
            }
        }
        for (int i = 0; i < n; i++){
            if (! visited[i]){
                return false;
            }
        }
        return true;


        }
}
