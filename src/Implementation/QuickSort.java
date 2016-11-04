package Implementation;

import java.util.Arrays;

/**
 * Implementation of QuickSort
 */
public class QuickSort {

    public static void main(String args[]) {
        int arr[] = {2, 6, 3, 9, 1, 0};
        System.out.println(Arrays.toString(arr));
        quicksort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quicksort(int arr[], int left, int right) {
        int index = partition(arr, left, right);
        if(left < index -1) {
            quicksort(arr, left, index - 1);
        }
        if(right > index) {
            quicksort(arr, index, right);
        }
    }

    private static int partition(int arr[], int left, int right) {
        int pivot = arr[(left + right)/2];
        while(left <= right) {
            while(arr[left] < pivot) left++;
            while(arr[right] > pivot) right--;

            if(left <= right) {
                swap(arr, left, right);
                left++;
                right--;
            }
        }
        return left;
    }

    private static void swap(int arr[], int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
