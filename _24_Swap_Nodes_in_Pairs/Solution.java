
class Solution {
    public static void main(String args[]){
        ListNode test = new ListNode(0, new ListNode(1, new ListNode(3, new ListNode(4, null))));
        ListNode result = swapPairs(test);
        System.out.println(listToString(result));
    }
    public static ListNode swapPairs(ListNode head) {
        // swap current with next unless cur is null or next is null
        // if 0 or 1 nodes return head
        if (head == null || head.next == null){
            return head;
        }
        // set return head
        ListNode result = head.next;
        // now we want to swap until we can't anymore
        ListNode prev = null;
        ListNode swap1 = head;
        ListNode swap2 = head.next;
        ListNode  hold = null;
        while (swap2 != null){
            hold = swap2.next;
            swap2.next = swap1;
            swap1.next = hold;
            if (prev != null){
                prev.next = swap2;
            }

            prev = swap1;
            swap1 = swap1.next;
            if (swap1 != null){
                swap2 = swap1.next;
            } else {
                return result;
            }
        }
        return result;
    }

    public static String listToString(ListNode n){
        String out = "";
        while (n.next != null){
            out = out + String.valueOf(n.val) + "->";
            n = n.next;
        }
        out = out + String.valueOf(n.val);
        return out;
    }
}