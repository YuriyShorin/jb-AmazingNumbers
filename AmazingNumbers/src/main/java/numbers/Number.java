package numbers;

import java.util.HashSet;

public class Number {

    private final long number;

    Number(long number) {
        this.number = number;
    }

    public long getNumber() {
        return number;
    }

    public boolean isEven() {
        return number % 2 == 0;
    }

    public boolean isBuzz() {
        return number % 10 == 7 || number % 7 == 0;
    }

    public boolean isDuck() {
        long copy = number;
        while (copy > 0) {
            if (copy % 10 == 0) {
                return true;
            }
            copy /= 10;
        }
        return false;
    }

    public boolean isPalindromic() {
        String numberString = Long.toString(number);
        for (int i = 0; i < numberString.length() / 2; ++i) {
            if (numberString.charAt(i) != numberString.charAt(numberString.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean isGapful() {
        if (number < 100) {
            return false;
        }
        String numberString = String.valueOf(number);
        String firstAndLastDigitConcat = String.valueOf(numberString.charAt(0)) + numberString.charAt(numberString.length() - 1);
        return number % Integer.parseInt(firstAndLastDigitConcat) == 0;
    }

    public boolean isSpy() {
        int sumOfDigits = 0;
        int prodOfDigits = 1;
        long copy = number;
        while (copy > 0) {
            int digit = (int) (copy % 10);
            sumOfDigits += digit;
            prodOfDigits *= digit;
            copy /= 10;
        }
        return sumOfDigits == prodOfDigits;
    }

    public boolean isSunny() {
        return Math.sqrt(number + 1) == (int) Math.sqrt(number + 1);
    }

    public boolean isSquare() {
        return Math.sqrt(number) == (int) Math.sqrt(number);
    }

    public boolean isJumping() {
        String numberString = String.valueOf(number);
        for (int i = 1; i < numberString.length(); ++i) {
            if (Math.abs(numberString.charAt(i - 1) - numberString.charAt(i)) != 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isHappy() {
        long copy = number;
        HashSet<Integer> setOfSquares = new HashSet<>();
        while (true) {
            int sumOfSquares = 0;
            while (copy > 0) {
                int lastDigit = (int) (copy % 10);
                sumOfSquares += lastDigit * lastDigit;
                copy /= 10;
            }
            if (sumOfSquares == 1) {
                return true;
            }
            if (setOfSquares.contains(sumOfSquares)) {
                return false;
            }
            setOfSquares.add(sumOfSquares);
            copy = sumOfSquares;
        }
    }
}

