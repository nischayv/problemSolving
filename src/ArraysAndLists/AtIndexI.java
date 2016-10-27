package ArraysAndLists;

/**
 * Given an array with fixed length, check if each element is the same as the index
 * Tried a binary search type approach. May not be that effective since we have to iterate
 * through the entire array regardless. Unless we just want to know if there is any index that
 * is incorrect and not the first incorrect.
 */
public class AtIndexI {
    public static void main(String args[]) {
        int[] arr = {1, 2, 3};
        System.out.println(find(arr, 0, arr.length - 1));
    }

    private static int find(int arr[], int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        int left = find(arr, start, mid - 1);
        if(left != -1) {
            return left;
        }
        if(mid != arr[mid]) {
            return mid;
        }
        return find(arr, mid + 1, end);
    }

}
