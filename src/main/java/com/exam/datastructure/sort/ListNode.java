package com.exam.datastructure.sort;

import lombok.Data;

@Data
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next;}

    public static ListNode reverseList(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode endNode = reverseList(head.next);
        ListNode next = head.next;
        head.next = null;
        next.next = head;
        return endNode;
    }

    public static boolean isPalindrome(int x) {
        String ori = String.valueOf(x);
        String tar = "";
        for (int i = ori.length() - 1; i >= 0; i--) {
            tar+= ori.charAt(i);
        }
        return ori.equals(tar);
    }

    public static int reverse(int x) {
        long top =  (long) Math.pow(2, 31) - 1;
        long bottom =  (long) Math.pow(2, 31) * -1;
        String y = Long.valueOf(Math.abs(x)).toString();
        long result = 0;
        for (int i = 0; Math.abs(x) > 0; i++) {
            Integer num = x % 10;
            result += Math.pow(10, y.length() - i - 1) * num ;
            x = x / 10;
        }

        if (result > top || result < bottom) {
            return 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        ListNode listNode5 = new ListNode(5);
        ListNode listNode4 = new ListNode(4, listNode5);
        ListNode listNode3 = new ListNode(3, listNode4);
        ListNode listNode2 = new ListNode(2, listNode3);
        ListNode listNode1 = new ListNode(1, listNode2);
        //ListNode listNode = reverseList(listNode1);
        ListNode listNode = reverseList(listNode1);
        reverse(-123);
        isPalindrome(-123);
        System.out.println(listNode1);

    }
}
