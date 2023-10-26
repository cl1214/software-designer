package com.exam.datastructure.sort;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    public static int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> strMap = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        strMap.put("IV", 4);
        strMap.put("IX", 9);
        strMap.put("XL", 40);
        strMap.put("XC", 90);
        strMap.put("CD", 400);
        strMap.put("CM", 900);
        if (Objects.isNull(s)) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (i <= s.length() - 2) {
                String str = s.substring(i, i + 2);
                if ("IV".equals(str)) {
                    result += 4;
                    i++;
                    continue;
                } else if ("IX".equals(str)) {
                    result += 9;
                    i++;
                    continue;
                } else if ("XL".equals(str)) {
                    result += 40;
                    i++;
                    continue;
                } else if ("XC".equals(str)) {
                    result += 90;
                    i++;
                    continue;
                } else if ("CD".equals(str)) {
                    result += 400;
                    i++;
                    continue;
                } else if ("CM".equals(str)) {
                    result += 900;
                    i++;
                    continue;
                }
            }
            if ('I' == cur) {
                result += 1;
            } else if ('V' == cur) {
                result += 5;
            } else if ('X' == cur) {
                result += 10;
            } else if ('L' == cur) {
                result += 50;
            } else if ('C' == cur) {
                result += 100;
            } else if ('D' == cur) {
                result += 500;
            } else if ('M' == cur) {
                result += 1000;
            }
        }
        return result;
    }

    public static String longestCommonPrefix(String[] strs) {
        String result = "";
        Character[] arr = new Character[200];
        int length = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < length) {
                length = strs[i].length();
            }
        }
        if (length == 0) {
            return result;
        }
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            for (int j = 0; j < length; j++) {
                Character s = arr[j];
                char c = str.charAt(j);
                if (s == null) {
                    arr[j] = c;
                }
                if (i > 0 && (s != c)) {
                    length = j;
                    break;
                }
            }
        }
        for (int k = 0; k < length; k++) {
            if (Objects.isNull(arr[k])) {
                break;
            }
            result += arr[k];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ab","a", ""}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"flower","flower","flower"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));

    }
}
