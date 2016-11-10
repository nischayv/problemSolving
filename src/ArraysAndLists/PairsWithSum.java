package ArraysAndLists;

import java.util.HashMap;

/**
 * Cracking the coding interview pairs with sum
 */
public class PairsWithSum {

    public static void main(String[] args) {
        int arr[] = {2, 6, 3, 5, 1, 7, 4, 8};
        pairs(arr, 9);
    }

    private static void pairs(int arr[], int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i <arr.length; i++) {
            if(hm.containsKey(sum - arr[i] )) {
                int temp = sum - arr[i];
                System.out.println(arr[i] + " " +  temp);
            }
            else {
                hm.put(arr[i], i);
            }
        }
    }
}
