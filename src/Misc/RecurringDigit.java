package Misc;

public class RecurringDigit {

    public static void main(String args[]) {
        reciprocal(9999);
    }

    //Unsure about all the requirements
    //This definitely does not work correctly
    static void reciprocal(int N) {
        Float r = (float) 1/N;
        String t = r.toString();
        StringBuilder output = new StringBuilder();

        if(N % 10 == 0) {
            output.append(t + "0 0");
            System.out.println(output);
            return;
        }

        output.append("0.");
        int len = t.length();

        for(int i = 2; i < len -1 ; i++) {
            if(t.charAt(i) != t.charAt(i + 1)) {
                output.append(t.charAt(i));
            }
            else {
                output.append(t.charAt(i) + " " + t.charAt(i));
                break;
            }
        }
        System.out.println(output);
    }
}
