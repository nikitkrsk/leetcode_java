package com.nikitkrsk;

import org.jetbrains.annotations.NotNull;

import java.util.*;
import java.util.stream.IntStream;

public class Solutions {
    public int removeElement(int @NotNull [] nums, int val) {
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

    public int[] twoSum(int @NotNull [] nums, int target) {
        var map = new HashMap<Integer, Integer>();
        for (var i = 0; i < nums.length; i++) {
            var diff = target - nums[i];
            if (map.containsKey(diff))
                return new int[]{map.get(diff), i};
            map.put(nums[i], i);
        }
        return null;

    }

    public boolean isValid(@NotNull String s) {
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

    public int removeDuplicates(int @NotNull [] nums) {
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

    public int strStr(@NotNull String haystack, @NotNull String needle) {
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

    public boolean stoneGame(int @NotNull [] piles) {
        int alex = 0;
        int lee = 0;
        int first = 0;
        int last = piles.length - 1;
        while (first < last) {
            if (piles[first] > piles[last]) {
                alex += piles[first];
                first++;
            } else {
                alex += piles[last];
                last--;
            }
            if (piles[first] > piles[last]) {
                lee += piles[last];
                last--;
            } else {
                lee += piles[first];
                first++;
            }
        }
        return (alex > lee);
    }

    public boolean stoneGame(int[] piles, boolean Simple) {
        return true;
    }

    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target)
                return m;
            if (nums[m] < target)
                l = m + 1;
            else
                r = m - 1;
        }
        return 0;
    }


    // SLOW - 14ms
    public String shiftingLetters(String s, int[] shifts) {
        final int shiftsLength = shifts.length - 1;
        char[] arr = s.toCharArray();
        int tmp = 0;
        for (int i = shiftsLength; i >= 0; i--) {
            tmp += shifts[i];
            if (tmp >= 26) {
                tmp %= 26;
            }
            int ascii = (int) arr[i] + tmp;
            if (ascii > 122) {
                ascii -= 26;
            }
            arr[i] = (char) ascii;
        }
        return String.valueOf(arr);
    }

}

