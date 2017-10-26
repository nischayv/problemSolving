package DynamicProgramming;

import java.util.*;

public class Decode {
    private static Hashtable<String, HashSet<String>> ht = new Hashtable<>();

    public static void main(String[] args) {
        System.out.println(find("1123"));
    }

    public static HashSet<String> find(String s) {
        HashSet<String> list = new HashSet<>();
        if (s.length() == 0) {
            list.add("");
            return list;
        }

        if (s.charAt(0) == '0') {
            return list;
        }

        if (!ht.containsKey(s.substring(1))) {
            ht.put(s.substring(1), find(s.substring(1)));
        }
        HashSet<String> newList = ht.get(s.substring(1));

        char c = (char) (s.charAt(0) - '1' + 'a');
        for (String l: newList) {
            list.add(c + l);
        }

        if (s.length() >= 2 && s.charAt(0) <= '2' && s.charAt(1) <= '6') {
            int number = Integer.parseInt(s.substring(0,2));
            char c2 = (char) (number - 1 + 'a');
            if (!ht.containsKey(s.substring(2))) {
                ht.put(s.substring(1), find(s.substring(2)));
            }
            HashSet<String> list1 = ht.get(s.substring(2));
            for (String l: list1) {
                list.add(c2 + l);
            }
        }
        return list;
    }
}
