/*
Problem: Allocate Minimum Pages
Given an array arr[] of integers, where each element arr[i] represents the number of pages in the i-th book. You also have an integer k representing the number of students. The task is to allocate books to each student such that:
    -> Each student receives atleast one book.
    -> Each student is assigned a contiguous sequence of books.
    -> No book is assigned to more than one student.
    -> All books must be allocated.

The objective is to minimize the maximum number of pages assigned to any student. In other words, out of all possible allocations, find the arrangement where the student who receives the most pages still has the smallest possible maximum. If it is not possible to allocate books to all students, return -1;

Note: Test cases are generated such that the answer always fits in a 32-bit integer.

# Example 1:
Input: arr[] = [12, 34, 67, 90], k = 2
Output: 113
Explanation: Allocation can be done in following ways:
=> [12] and [34, 67, 90] Maximum Pages = 191
=> [12, 34] and [67, 90] Maximum Pages = 157
=> [12, 34, 67] and [90] Maximum Pages = 113.
The third combination has the minimum pages assigned to a student which is 113.

# Example 2:
Input: arr[] = [15, 17, 20], k = 5
Output: -1
Explanation: Since there are more students than total books, it's impossible to allocate a book to each student.

# Constraints:
1 ≤ arr.size() ≤ 106
1 ≤ arr[i], k ≤ 104
 */

class AllocateMinimumPages {

    public static void main(String[] args) {
        int[] arr1 = {12, 34, 67, 90};
        int[] arr2 = {15, 17, 20};
        int[] arr3 = {10, 20, 30, 40};

        System.out.println(findPages(arr1, 2));
        System.out.println(findPages(arr2, 5));
        System.out.println(findPages(arr3, 2));
    }

    public static int findPages(int[] arr, int k) {
        int n = arr.length;

        if (n < k) {
            return -1;
        }

        /*
            Binary search range:
            low  = largest single book
            high = total number of pages
         */
        int low = 0;
        int high = 0;

        for (int pages : arr) {
            low = Math.max(low, pages);
            high += pages;
        }

        /*
            We are looking for the SMALLEST value of "maximum pages"
            for which allocation is possible.
         */
        while (low <= high) {
            int mid = low + (high - low) / 2;

            /*
             * Check whether it is possible to allocate all books
             * such that no student gets more than 'mid' pages.
             */
            if (canAllocate(arr, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }


    /*
     * Checks whether we can allocate all books to at most 'k'
     * students when each student can receive at most 'maxPages'.
     *
     * Greedy approach:
     *
     * Start from the first book and keep giving books to the
     * current student until adding the next book would exceed
     * maxPages.
     *
     * Then move to the next student.
     */
    private static boolean canAllocate(int[] arr, int k, long maxPages) {

        int studentsRequired = 1;

        long currentPages = 0;

        for (int pages : arr) {

            /*
             * If adding this book does not exceed maxPages,
             * give it to the current student.
             */
            if (currentPages + pages <= maxPages) {

                currentPages += pages;

            } else {

                /*
                 * Adding this book would exceed the limit.
                 *
                 * Therefore, the current student cannot take it.
                 * Start a new student.
                 */
                studentsRequired++;

                // The new student gets this book.
                currentPages = pages;

                /*
                 * If we need more than k students,
                 * this maximum limit is impossible.
                 */
                if (studentsRequired > k) {
                    return false;
                }
            }
        }

        /*
         * We used k or fewer students.
         *
         * Therefore, this maxPages limit is feasible.
         */
        return true;
    }
}
