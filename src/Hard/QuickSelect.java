package Hard;

public class QuickSelect {

    public static void main(String[] args) {

    }


    // Kth smallest
    public static int selectSmallest(int[] arr, int left, int right, int k) {
        if (k > 0 && k <= right-left+1) {
            int pos = partition(arr, left, right);
            if (pos-left == k-1) {
                return arr[pos];
            } else if (pos-left < k-1) {
                return selectSmallest(arr, left, pos-1, k);
            } else {
                return selectSmallest(arr, pos+1, right, k-pos-1+left);
            }
        }
        return Integer.MIN_VALUE;
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[(left+right)/2];
        while(left <= right) {
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return left;
    }
}
