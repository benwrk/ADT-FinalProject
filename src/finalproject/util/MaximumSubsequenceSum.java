package finalproject.util;

/**
 * Maximum sub-sequence summation calculation utility.
 *
 * @author Benjapol Worakan 5710546577
 * @version 16.3.2
 */
public class MaximumSubsequenceSum {
    /**
     * Find maximum sub-sequence summation of the given array.
     *
     * @param array is the array to be processed
     * @return the maximum sub-sequence summation result of the given array.
     */
    public static int findMss(int[] array) {
        int maxSum = array[0], sum;
        for (int i = 0; i < array.length; i++) {
            sum = 0;
            for (int j = i; j < array.length; j++) {
                sum += array[j];
                maxSum = sum > maxSum ? sum : maxSum;
            }
        }
        return maxSum;
    }

    /**
     * Find maximum sub-sequence summation of the given array recursively by
     * using the divide-and-conquer technique.
     *
     * @param array is the array to be processed
     * @return the maximum sub-sequence summation result of the given array.
     */
    public static int findMssDivideAndConquer(int[] array) {
        return findMssDivideAndConquer(array, 0, array.length - 1);
    }

    /**
     * A helper method for {@link #findMssDivideAndConquer(int[])}.
     */
    private static int findMssDivideAndConquer(int[] array, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return array[startIndex] > 0 ? array[startIndex] : 0;
        }

        int left = findMssDivideAndConquer(array, startIndex, (startIndex + endIndex) / 2);

        int right = findMssDivideAndConquer(array, (startIndex + endIndex) / 2 + 1, endIndex);

//        System.out.println("Left of " + startIndex + "-" + endIndex + " = " + left);
//        System.out.println("Right of " + startIndex + "-" + endIndex + " = " + left);

        int halfLeft = 0;
        for (int i = (startIndex + endIndex) / 2, sum = 0; i >= startIndex; sum += array[i--]) {
            halfLeft = sum > halfLeft ? sum : halfLeft;
        }

//        System.out.println("HalfLeft of " + startIndex + "-" + endIndex + " = " + halfLeft);

        int halfRight = 0;
        for (int i = (startIndex + endIndex) / 2 + 1, sum = 0; i <= endIndex; sum += array[i++]) {
            halfRight = sum > halfRight ? sum : halfRight;
        }

//        System.out.println("HalfRight of " + startIndex + "-" + endIndex + " = " + halfRight);

        return Math.max(Math.max(left, right), halfLeft + halfRight);
    }
}
