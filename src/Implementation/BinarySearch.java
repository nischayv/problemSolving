package Implementation;

/**
 * Recursive and Iterative implementation of Binary Search
 */
public class BinarySearch {

    private static int binarySearchIterative(int arr[], int x) {
        int first = 0;
        int last = arr.length - 1;

        while(first <= last) {
            int mid = (first + last) / 2;
            if(x == arr[mid]) {
                return mid;
            }
            else if(x < arr[mid]) {
                last = mid - 1;
            }
            else {
                first = mid + 1;
            }
        }

        return -1;
    }

    private static int binarySearchRecursive(int arr[], int beg, int end, int x) {
        if(beg > end) {
            return -1;
        }
        int mid = (beg + end) / 2;

        if(x == arr[mid]) {
            return mid;
        }
        else if(x < arr[mid]) {
            return binarySearchRecursive(arr, beg, mid - 1 , x);
        }
        else {
            return binarySearchRecursive(arr, mid + 1, end, x);
        }
    }

}
