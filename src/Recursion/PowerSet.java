package Recursion;

import java.util.ArrayList;

/**
 * Cracking the Coding Interview Powerset
 * Time Complexity(n2^n)
 */
public class PowerSet {

    private static ArrayList<ArrayList<Integer>> powerset(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allsubsets;
        if(set.size() == index) {
            allsubsets = new ArrayList<ArrayList<Integer>>();
            allsubsets.add(new ArrayList<Integer>());
        }
        else {
            allsubsets = powerset(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
            for(ArrayList<Integer> subset : allsubsets) {
                ArrayList<Integer> newsubset = new ArrayList<Integer>();
                newsubset.addAll(subset);
                newsubset.add(item);
                moresubsets.add(newsubset);
            }
            allsubsets.addAll(moresubsets);
        }
        return allsubsets;
    }

    public static void main(String args[]) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        ArrayList<ArrayList<Integer>> subsets;
        subsets = powerset(arrayList, 0);

        for(ArrayList<Integer> subset: subsets) {
            for(Integer item: subset) {
                System.out.print(item + " ");
            }
            System.out.println("");
        }
    }
}
