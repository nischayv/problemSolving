package Moderate;

public class SubSort {

    public static void main(String args[]){
        int[] a = {1, 1, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
        subSort(a);
    }

    private static void subSort(int[] arr) {
        int leftIndex = findEndOfLeft(arr);
        if (leftIndex >= arr.length - 1) {
            // already sorted
            return;
        }
        int rightIndex = findStartOfRight(arr);

        int midMin = Integer.MAX_VALUE;
        int midMax = Integer.MIN_VALUE;

        // Find min in left index to arr.length - 1
        for(int i = leftIndex; i < arr.length; i++) {
            if(arr[i] < midMin) {
                midMin = arr[i];
            }
        }

        // Find max in 0 to rightIndex
        for(int i = 0; i <= rightIndex; i++) {
            if(arr[i] > midMax) {
                midMax = arr[i];
            }
        }

        System.out.println(midMax);
        System.out.println(midMin);

        // shrink right
        for(int i = rightIndex + 1; i < arr.length; i++) {
            if(arr[i] < midMax) {
                rightIndex = i;
            } else {
                break;
            }
        }

        //shrink left
        for(int i = leftIndex; i >= 0; i--) {
            if (arr[i] > midMin) {
                leftIndex = i;
            } else {
                break;
            }
        }

        System.out.println(leftIndex);
        System.out.println(rightIndex);
    }

    private static int findEndOfLeft(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i+1] < a[i]) {
                return i+1;
            }
        }
        return a.length - 1;
    }

    private static int findStartOfRight(int[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            if (a[i-1] > a[i]) {
                return i-1;
            }
        }
        return 0;
    }
}
