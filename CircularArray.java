/**
 * https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
 */
package pract.hackerrank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CircularArray
{
    public static void main(String[] args)
    {
        int[] i = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(rotLeft(i, 1)));

    }

    public static int[] rotLeft(int[] a, int d)
    {
        int[] retval = new int[a.length];

        for (int i = 0; i < a.length; i++) // access each element in the array
        {
            retval[i] = a[(i + d) % a.length];
        }

        return retval;
    }
}
