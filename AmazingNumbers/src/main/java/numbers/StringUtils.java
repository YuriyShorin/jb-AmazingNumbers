package numbers;

public class StringUtils {

    public static boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNatural(String str) {
        long numberToCheck;
        try {
            numberToCheck = Long.parseLong(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return numberToCheck > 0;
    }
}

