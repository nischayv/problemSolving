package Hard;

public class VolumeOfHistogram {
    public static void main(String[] args) {
        int[] towerHeight = { 0,0,4,0,0,6,0,0,3,0,5,0,1,0,0,0 };
        System.out.println(getMaxRainwater(towerHeight));
    }

    private static int getMaxRainwater(int[] arr) {
        int maxSeenRight = 0;
        int maxSeenLeft = 0;
        int[] maxRight = new int[arr.length];
        int water = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] > maxSeenRight) {
                maxSeenRight = arr[i];
            }
            maxRight[i] = maxSeenRight;
        }

        for (int i = 0; i < arr.length; i++) {
            water += Math.max(Math.min(maxSeenLeft, maxRight[i]) - arr[i], 0);
            if (arr[i] > maxSeenLeft) {
                maxSeenLeft = arr[i];
            }
        }
        return water;
    }
}
