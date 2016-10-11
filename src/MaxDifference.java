public class MaxDifference {

    public static void main(String args[]) {

    }

    static int maxDifference(int[] a) {
        int max = -1000001;
        int smallest = a[0];
        for(int i = 1; i < a.length; i ++) {
            if(a[i] <= smallest) {
                smallest = a[i];
            }
            else {
                int temp = Math.abs(smallest - a[i]);
                max = temp > max ? temp : max;
            }
        }

        if(max == -1000001) {
            max = -1;
        }

        System.out.println(max);
        return max;
    }
}
