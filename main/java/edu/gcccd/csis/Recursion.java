package edu.gcccd.csis;

public class Recursion {
    /*
     * Recursive method to output every other element in the given array backwards,
     * ending with the element at index k.
     * An example input array {1,2,3,4,5,6,7,8,9,10}, called with k=2, should output 9753
     */
    static String printEveryOther(final int[] ia, final int k) {
        if (k < 0) throw new IllegalArgumentException("index must be greater or equal 0");
        if((k == ia.length) || (k == ia.length-1)){
            return String.valueOf(ia[k]);
        }
        return printEveryOther( ia, (k+2));
       }

    /*
     * Recursively take in a string and place a * between adjacent letters that are the same
     * An example input String "hello" should return hel*lo.
     */
    static String printStars(final String s) {
        if(s.length() == 1){
            return s;
        }else if (s.charAt(0) == s.charAt(1)) {
           return String.format(s.substring(0, 1) + "*") + printStars(s.substring(1));
        }else
           return s.format(s.substring(0, 1)) + printStars(s.substring(1));
    }

    /*
     * Recursively computes the sum of the 1st k positive numbers.
     * An example input 4 should return 10.
     */
    static int sum(int k) {
        return k > 0 ? k + sum(k - 1) : 0;
    }

    public static void main(String[] args) {
        System.out.println(printStars("Hellloo"));
        System.out.println(printEveryOther(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 2));
        System.out.println(sum(4));
    }
}