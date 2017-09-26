package Search;

public class RotatedArray {

    public static void main(String args[]) {
        int[] a = new int[]{15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
        int[] b = new int[]{10, 15, 20, 5, 8};
        int[] c = new int[]{50, 5, 20, 30, 40};
//        System.out.println(search(a, 5, 0, a.length-1));
//        System.out.println(search(b, 5, 0, b.length-1));
        System.out.println(search(c, 5, 0, c.length-1));
    }

    // 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14
    // find 5 output: 8
    // distinct characters
    public static int search(int[] a, int val, int low, int high) {
        System.out.println("low: "+ low + " high: "+ high+ " val: "+ val);
        int mid = (low+high)/2;
        if (a[mid] == val) {
            return mid;
        }
        System.out.println("mid: "+mid+" value is: "+ a[mid]);

        if (low > high) {
            return -1;
        }

        if (a[mid] >= a[low]) {
            // left side is ordered
            if (val >= a[low] && val < a[mid]) {
                return search(a, val, low, mid-1);
            } else {
                return search(a, val, mid+1, high);
            }
        } else {
            // right side is ordered
            if (val > a[mid] && val <= a[high]) {
                return search(a, val, mid+1, high);
            } else {
                return search(a, val, low, mid-1);
            }
        }
    }
}
