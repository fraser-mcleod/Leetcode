
class Solution {
    public static void main(String[] args){
        System.out.println("Test 1:");
        ListNode l1 = new ListNode(5, new ListNode(10, new ListNode(13, new ListNode(20, null))));
        ListNode l2 = new ListNode(4, new ListNode(12, new ListNode(30, new ListNode(100, null))));
        ListNode l3 = mergeTwoLists(l1, l2);
        while (l3 != null){
            System.out.print(String.valueOf(l3.val)+ ", ");
            l3 = l3.next;
        }

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head;
        ListNode cur;
        if (list1 == null){
            return list2;
        } else if (list2 == null){
            return list1;
        }
        if (list1.val <= list2.val){
            head = list1;
            cur = list1;
            list1 = list1.next;
        } else {
            head = list2;
            cur = list2;
            list2 = list2.next;
        }
        while (list1 != null && list2 != null){
            // cur will equal the less of the two
            if (list1.val <= list2.val){
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            } else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        if (list1 == null){
            cur.next = list2;
        } else {
            cur.next = list1;
        }
        return head;
    }
}