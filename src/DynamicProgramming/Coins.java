package DynamicProgramming;

import java.util.Hashtable;

public class Coins {

    public static void main(String args[]) {
        System.out.println(makeChange());
    }

    public static int makeChange () {
        return findWays(10, new int[]{25,10,5,1}, 0);
    }

    public static int findWays (int amount, int[] money, int index) {
        if (amount == 0) {
            return 1;
        }
        if (index >= money.length) {
            return 0;
        }

        int ways = 0;
        int denomination = money[index];

        for (int i = 0; i * denomination <= amount; i++) {
            int moneyRemaining = amount - i * denomination;
            ways += findWays (moneyRemaining, money, index+1);
        }
        return ways;
    }

    public static int makeChangeDp () {
        Hashtable<String, Integer> ht = new Hashtable<String, Integer>();
        return findWays(1423432285, new int[]{25,10,5,1}, 0, ht);
    }

    public static int findWays (int amount, int[] money, int index, Hashtable<String, Integer> ht) {

        if (amount == 0) {
            return 1;
        }
        if (index >= money.length) {
            return 0;
        }
        String key = amount + "-" + index;

        if (ht.containsKey(key)){
            return ht.get(key);
        }


        int ways = 0;
        int denomination = money[index];

        for (int i = 0; i * denomination <= amount; i++) {
            int moneyRemaining = amount - i * denomination;
            ways += findWays(moneyRemaining, money, index+1, ht);
        }
        ht.put(key, ways);
        return ways;
    }
}
