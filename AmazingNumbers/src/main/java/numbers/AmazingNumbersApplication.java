package numbers;

import java.util.ArrayList;
import java.util.Scanner;

public class AmazingNumbersApplication {
    public void run() {
        printInstructions();
        String[] request;
        boolean isExit = false;
        while (!isExit) {
            request = inputRequest();
            isExit = processRequest(request);
        }
    }

    private void printInstructions() {
        System.out.println("Welcome to Amazing Numbers!\n");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("    * the first parameter represents a starting number;");
        System.out.println("    * the second parameter shows how many consecutive numbers are to be processed;");
        System.out.println("- two natural numbers and properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");
    }

    private String[] inputRequest() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nEnter a request > ");
        String request = scanner.nextLine();
        System.out.println();
        return request.split(" ");
    }

    private boolean processRequest(String[] request) {
        if (request.length == 0) {
            printInstructions();
            return false;
        }
        if (!StringUtils.isNumeric(request[0])) {
            System.out.println("The first parameter should be a natural number or zero.");
            return false;
        }
        long firstParameter = Long.parseLong(request[0]);
        if (firstParameter == 0) {
            System.out.println("Goodbye");
            return true;
        }
        if (firstParameter < 0) {
            System.out.println("The first parameter should be a natural number or zero.");
            return false;
        }
        if (request.length == 1) {
            printProperties(firstParameter);
            return false;
        }
        if (!StringUtils.isNatural(request[1])) {
            System.out.println("The second parameter should be a natural number.");
            return false;
        }
        int secondParameter = Integer.parseInt(request[1]);
        if (request.length == 2) {
            printProperties(firstParameter, secondParameter);
            return false;
        }
        ArrayList<String> properties = new ArrayList<>();
        ArrayList<String> wrongProperties = new ArrayList<>();
        for (int i = 2; i < request.length; i++) {
            if (!PropertiesUtils.isProperty(request[i].toLowerCase())) {
                wrongProperties.add(request[i].toUpperCase());
            }
            properties.add(request[i].toLowerCase());
        }
        if (wrongProperties.size() == 1) {
            System.out.println("The property [" + wrongProperties.get(0) + "] is wrong.");
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, " +
                    "GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            return false;
        }
        if (wrongProperties.size() > 1) {
            System.out.print("The properties [");
            for (int i = 0; i < wrongProperties.size(); ++i) {
                if (i != wrongProperties.size() - 1) {
                    System.out.print(wrongProperties.get(i).toUpperCase() + ", ");
                } else {
                    System.out.print(wrongProperties.get(i).toUpperCase());
                }
            }
            System.out.println("] are wrong.");
            System.out.println("Available properties: [EVEN, ODD, BUZZ, DUCK, PALINDROMIC, " +
                    "GAPFUL, SPY, SQUARE, SUNNY, JUMPING, HAPPY, SAD]");
            return false;
        }
        String[] exclusiveProperties = PropertiesUtils.isPropertiesMutuallyExclusive(properties);
        if (exclusiveProperties != null) {
            System.out.println("The request contains mutually exclusive properties: [" +
                    exclusiveProperties[0].toUpperCase() + ", " + exclusiveProperties[1].toUpperCase() + "]");
            System.out.println("There are no numbers with these properties.");
            return false;
        }
        printProperties(firstParameter, secondParameter, properties);
        return false;
    }

    private void printProperties(long numberLong) {
        Number number = new Number(numberLong);
        System.out.println("Properties of " + number.getNumber());
        System.out.println("    buzz: " + number.isBuzz());
        System.out.println("    duck: " + number.isDuck());
        System.out.println("    palindromic: " + number.isPalindromic());
        System.out.println("    gapful: " + number.isGapful());
        System.out.println("    spy: " + number.isSpy());
        System.out.println("    square: " + number.isSquare());
        System.out.println("    sunny: " + number.isSunny());
        System.out.println("    jumping: " + number.isJumping());
        System.out.println("    happy: " + number.isHappy());
        System.out.println("    sad: " + !number.isHappy());
        System.out.println("    even: " + number.isEven());
        System.out.println("    odd: " + !number.isEven());
    }

    private void printProperties(long numberLong, int repeats) {
        for (long i = numberLong; i < numberLong + repeats; ++i) {
            Number number = new Number(i);
            String output = getOutput(number);
            System.out.println(output);
        }
    }

    private void printProperties(long numberLong, int repeats, ArrayList<String> properties) {
        int counter = 0;
        while (counter < repeats) {
            Number number = new Number(numberLong);
            boolean skipThisNumber = false;
            for (String property : properties) {
                if (property.charAt(0) == '-') {
                    if (appendPropertyInOutput(property.substring(1), number).length() > 0) {
                        skipThisNumber = true;
                        break;
                    }
                } else {
                    if (appendPropertyInOutput(property, number).equals("")) {
                        skipThisNumber = true;
                        break;
                    }
                }
            }
            if (skipThisNumber) {
                numberLong++;
                continue;
            }
            String output = getOutput(number);
            System.out.println(output);
            counter++;
            numberLong++;
        }
    }

    private String appendPropertyInOutput(String property, Number number) {
        switch (property) {
            case "buzz" -> {
                if (number.isBuzz()) {
                    return "buzz, ";
                }
            }
            case "duck" -> {
                if (number.isDuck()) {
                    return "duck, ";
                }
            }
            case "palindromic" -> {
                if (number.isPalindromic()) {
                    return "palindromic, ";
                }
            }
            case "gapful" -> {
                if (number.isGapful()) {
                    return "gapful, ";
                }
            }
            case "spy" -> {
                if (number.isSpy()) {
                    return "spy, ";
                }
            }
            case "square" -> {
                if (number.isSquare()) {
                    return "square, ";
                }
            }
            case "sunny" -> {
                if (number.isSunny()) {
                    return "sunny, ";
                }
            }
            case "jumping" -> {
                if (number.isJumping()) {
                    return "jumping, ";
                }
            }
            case "happy" -> {
                if (number.isHappy()) {
                    return "happy, ";
                }
            }
            case "sad" -> {
                if (!number.isHappy()) {
                    return "sad, ";
                }
            }
            case "even" -> {
                if (number.isEven()) {
                    return "even";
                }
            }
            case "odd" -> {
                if (!number.isEven()) {
                    return "odd";
                }
            }
            default -> System.out.println("Wrong property");
        }
        return "";
    }

    private String getOutput(Number number) {
        return number.getNumber() + " is " + appendPropertyInOutput("buzz", number) +
                appendPropertyInOutput("duck", number) +
                appendPropertyInOutput("palindromic", number) +
                appendPropertyInOutput("gapful", number) +
                appendPropertyInOutput("spy", number) +
                appendPropertyInOutput("square", number) +
                appendPropertyInOutput("sunny", number) +
                appendPropertyInOutput("jumping", number) +
                appendPropertyInOutput("happy", number) +
                appendPropertyInOutput("sad", number) +
                appendPropertyInOutput("even", number) +
                appendPropertyInOutput("odd", number);
    }
}



