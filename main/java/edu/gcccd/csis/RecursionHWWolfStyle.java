package edu.gcccd.csis;

public class RecursionHWWolfStyle {
    /*
     * Recursive method to output every other element in the given array backwards,
     * ending with the element at index k.
     * An example input array {1,2,3,4,5,6,7,8,9,10}, called with k=2, should output 9753
     */
    static String printEveryOther(final int[] ia, final int k) {

        if (k < 0) throw new IllegalArgumentException("index must be greater or equal 0");
        return k < ia.length ? printEveryOther(ia, k + 2) + ia[k] : "";
    }

    /*
     * Recursively take in a string and place a * between adjacent letters that are the same
     * An example input String "hello" should return hel*lo.
     */
    static String printStars(final String s) {
        if (s == null || s.length() < 2) {
            return s;
        } else {
            return s.charAt(0) == s.charAt(1) ? s.charAt(0) + "*" + printStars(s.substring(1)) : s.charAt(0) + printStars(s.substring(1));
        }
    }
}
