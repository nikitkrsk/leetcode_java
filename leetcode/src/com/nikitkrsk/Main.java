package com.nikitkrsk;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Solutions solutions = new Solutions();

        // Remove Element
        int removeElement = solutions.removeElement(new int[]{3, 2, 2, 3}, 3);
        System.out.println("removeElement = " + removeElement);

        // Two Sum
        int[] twoSum = solutions.twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("twoSum = " + Arrays.toString(twoSum));

        // Valid Parentheses
        boolean isValid = solutions.isValid("{[]}");
        System.out.println("isValid = " + isValid);

        // Remove Duplicates from Sorted Array
        int removeDuplicates = solutions.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        System.out.println("removeDuplicates = " + removeDuplicates);

        // Implement strStr()
        int strStr = solutions.strStr("hello", "ll");
        System.out.println("strStr = " + strStr);

        // Palindrome Number
        boolean isPalindrome = solutions.isPalindrome(1221);
        System.out.println("isPalindrome = " + isPalindrome);

    }
}
