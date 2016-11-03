package Implementation;

/**
 * Implementation of MergeSort
 */
public class MergeSort {


    private static void mergeSort(int arr[], int start, int end) {
        if(start < end) {
            int mid = (start + end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, end, mid);
        }
    }

    private static void merge(int arr[], int start, int end, int mid) {

        int n1 = mid - start + 1;
        int n2 = end - mid;

        int left[] = new int[n1];
        int right[] = new int[n2];

        for(int i = start; i <= mid; i++) {
            left[i] = arr[i];
        }

        for(int i = mid + 1; i <= end; i++) {
            right[i] = arr[i];
        }

        int i = 0, j = 0, k = 0;

        while(i < n1 && j < n2) {
            if(left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while(i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while(j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
