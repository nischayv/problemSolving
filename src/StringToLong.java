public class StringToLong {

    public static void main(String args[]) {
        try {
            long l = convert("-123");
            if (l == -123L) {
                System.out.println("Success");
            } else {
                System.out.println("Failure");
            }
        }
        catch(Exception e) {
            System.out.println("Exception:" + e);
        }
    }

    private static Long convert(String str) throws Exception {

        int length = str.length();
        boolean isNegative = str.startsWith("-");
        int start = 0;

        if(isNegative || str.startsWith("+")) {
            start = 1;
        }

        long result = 0;

        for (int i = start; i < length; i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') {
                result = result * 10 +  Character.getNumericValue(c);
                if(result < 0) {
                    throw new Exception("Number out of bounds");
                }
            }
            else {
                throw new Exception("Invalid number format");
            }
        }
        return isNegative ? -result : result;
    }
}
