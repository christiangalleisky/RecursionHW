package edu.gcccd.csis;

import org.junit.Test;
import java.util.Random;
import static org.junit.Assert.*;

public class RecursionTest {

    @Test
    public void printEveryOther() {
        for (int i = 0; i < 100; i++) { // number of times to run test this assert
            final int N = 1 + new Random().nextInt(100); // N length of the array, in {1..100}
            final int[] ia = new int[N];
            for (int j = 0; j < N; j++) { // init the array 0,..,N-1
                ia[j] = j;
            }
            final int k = new Random().nextInt(N); // generate an index inside [0..[N

            String s = "";
            for (int j = k; j < ia.length; j += 2) { // generate the expected result ia[k],ia[k+2],ia[k+4] ...
                s = ia[j] + s;
            }
            assertEquals(s, Recursion.printEveryOther(ia, k));
        }

        // corner cases
        assertEquals("", Recursion.printEveryOther(new int[]{}, 0));
        assertEquals("", Recursion.printEveryOther(new int[]{}, 1));
        try {
            assertEquals("", Recursion.printEveryOther(new int[]{}, -1));
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void printStars() {

        for (int i = 0; i < 100; i++) { // number of times to run test this assert
            final int N = new Random().nextInt(100); // N length of the string 0..99
            String s = "";
            String expected = "";
            for (int j = 0; j < N; j++) {
                final int k = new Random().nextInt(10); // work with the 1st 10 chars
                final char c = (char) ('a' + k);
                if (0 < j && s.charAt(s.length() - 1) == c) {
                    expected += '*';
                }
                expected+=c;
                s += c;
            }
            assertEquals(expected, Recursion.printStars(s));
        }

        // corner cases
        assertEquals("", Recursion.printStars(""));
        assertEquals("*", Recursion.printStars("*"));
        assertEquals("a", Recursion.printStars("a"));
        assertEquals("a*a", Recursion.printStars("aa"));
        assertEquals("a*a", Recursion.printStars("a*a"));
        assertEquals("a*a*a", Recursion.printStars("aaa"));
        assertEquals("a*a*a", Recursion.printStars("a*aa"));
        assertEquals("a*a*a", Recursion.printStars("aa*a"));
        assertEquals("aA", Recursion.printStars("aA"));
    }

    /*
     * we know the sum of the 1st k positive numbers is n(n+1)2
     */
    @Test
    public void sum() {
        for (int i = 0; i < 10; i++) {
            int k = new Random().nextInt(100);
            assertEquals(k * (k + 1) / 2, Recursion.sum(k));
        }
        // corner cases
        assertEquals(0, Recursion.sum(-1));
        assertEquals(0, Recursion.sum(0));
        try {
            int x = Recursion.sum(Integer.MAX_VALUE); // stackoverflow
            fail();
        } catch (StackOverflowError error) {
            assertTrue(true);
        }
    }
}