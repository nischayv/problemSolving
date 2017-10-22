package Hard;

public class Masseuse {
    public static int maxMinutes(int[] massages) {
        int oneAway = 0;
        int twoAway = 0;
        for (int i = massages.length - 1; i >= 0; i--) {
            int bestWith = massages[i] + twoAway;
            int bestWithout = oneAway;
            int current = Math.max(bestWith, bestWithout);
            twoAway = oneAway;
            oneAway = current;
        }
        return oneAway;
    }

    public static int maxMins(int[] a) {
        int oneAway = 0;
        int twoAway = 0;
        for (int i = 0; i < a.length; i++) {
            int bestWith = a[i] + twoAway;
            int bestWithout = oneAway;
            int current = Math.max(bestWith, bestWithout);
            twoAway = oneAway;
            oneAway = current;
        }
        return oneAway;
    }

    public static void main(String[] args) {
        int[] massages = {75, 105, 120, 75, 90, 135};
        int[] moreMassages = {};
        System.out.println(maxMins(massages));
    }
}
