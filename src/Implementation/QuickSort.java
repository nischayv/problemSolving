package Implementation;

import java.util.Arrays;

import static java.lang.Math.min;

/**
 * Implementation of QuickSort
 */
public class QuickSort {

    public static void main(String args[]) {
//        int arr[] = {2, 6, 3, 9, 1, 0};
//        System.out.println(Arrays.toString(arr));
//        quicksort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));
          long t1 = System.currentTimeMillis();
          Fastgcd(3267000013L, 2860486313L);
          long t2 = System.currentTimeMillis();
          System.out.println(t2-t1);

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

    private static long GCD(long a, long  b) {
        long n = min(a, b);
        for (long i = n; i >=1; i--) {
            if (a%i ==0 && b%i == 0)
                return i;
        }
        return -1;
    }

    private static long Fastgcd (long a, long b) {
        if (b == 0)
            return a;
        else
            return Fastgcd(b, a % b);
    }

}
