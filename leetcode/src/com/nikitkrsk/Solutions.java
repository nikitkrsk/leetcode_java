package com.nikitkrsk;

import java.util.HashMap;
import java.util.Stack;

public class Solutions {
    public int removeElement(int[] nums, int val) {
        final int len = nums.length;
        if (len <= 0)
            return len;

        int newIndex = 0;

        for (int i = 0; i < len; i++) {
            if (nums[i] != val) {
                nums[newIndex++] = nums[i];
            }
        }
        return newIndex;
    }

    public int[] twoSum(int[] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (var i = 0; i < nums.length; i++) {
            var diff = target - nums[i];
            if (map.containsKey(diff))
                return new int[]{map.get(diff), i};
            map.put(nums[i], i);
        }
        return null;

    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hs = new HashMap<>();
        hs.put('(', ')');
        hs.put('{', '}');
        hs.put('[', ']');
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.empty()) {
                    return false;
                }
                char last = stack.pop();
                if (hs.get(last) != ch) {
                    return false;
                }
            }

        }
        return stack.size() == 0;
    }

    public int removeDuplicates(int[] nums) {
        final int len = nums.length;
        if (len <= 0)
            return len;

        int newIndex = 1;

        for (int index = 1; index < len; index++) {
            if (nums[index] > nums[index - 1])
                nums[newIndex++] = nums[index];
        }

        return newIndex;
    }

    public int strStr(String haystack, String needle) {
        final int needleLen = needle.length();
        final int haystackLen = haystack.length();
        if (needleLen <= 0)
            return needleLen;

        for (int i = 0; i <= haystackLen - needleLen; i++) {
            for (int j = needleLen - 1; j >= 0; j--) {
                if (haystack.charAt(i + j) != needle.charAt(j))
                    break;
                if (j == 0)
                    return i;
            }

        }
        return -1;
    }

    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int revNum = 0;
        int copyNum = x;
        while (copyNum > 0) {
            revNum = (revNum * 10) + (copyNum % 10);
            copyNum = copyNum / 10;
        }
        return revNum == x;
    }
}
