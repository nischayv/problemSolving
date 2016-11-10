package ArraysAndLists;

/**
 * Cracking the coding interview magic index
 */
public class MagicIndex {

    public static void main(String[] args) {
        int arr[] = {-10, -5, -1, 2, 2, 3, 4, 7, 9, 12, 13};
        System.out.println(magic(arr, 0, arr.length-1));
    }

    private static int magic(int arr[], int start, int end) {
        if(end < start) {
            return -1;
        }

        int mid = (start + end) /2;

        if(arr[mid] == mid) {
            return mid;
        }


        int left = Math.min(arr[mid], mid - 1);
        int leftMagic = magic(arr, start, left);
        if( leftMagic >= 0 ){
            return leftMagic;
        }

        int right = Math.max(arr[mid], mid + 1);
        int rightMagic = magic(arr, right, end);
        return rightMagic;
    }
}
