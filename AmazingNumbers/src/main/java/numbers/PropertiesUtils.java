package numbers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class PropertiesUtils {

    private final static HashSet<String> properties = new HashSet<>(List.of("even", "odd",
            "buzz", "duck", "palindromic", "gapful", "spy", "square", "sunny", "jumping", "happy", "sad", "-even",
            "-odd", "-buzz", "-duck", "-palindromic", "-gapful", "-spy", "-square", "-sunny", "-jumping", "-happy", "-sad"));

    public static boolean isProperty(String property) {
        return properties.contains(property);
    }

    public static String[] isPropertiesMutuallyExclusive(ArrayList<String> properties) {
        HashSet<String> propertiesSet = new HashSet<>();
        for (String property : properties) {
            if (property.equals("even") && propertiesSet.contains("odd")) {
                return new String[]{"odd", "even"};
            }
            if (property.equals("odd") && propertiesSet.contains("even")) {
                return new String[]{"even", "odd"};
            }
            if (property.equals("-even") && propertiesSet.contains("-odd")) {
                return new String[]{"-odd", "-even"};
            }
            if (property.equals("-odd") && propertiesSet.contains("-even")) {
                return new String[]{"-even", "-odd"};
            }
            if (property.equals("sunny") && propertiesSet.contains("square")) {
                return new String[]{"square", "sunny"};
            }
            if (property.equals("square") && propertiesSet.contains("sunny")) {
                return new String[]{"sunny", "square"};
            }
            if (property.equals("duck") && propertiesSet.contains("spy")) {
                return new String[]{"spy", "duck"};
            }
            if (property.equals("spy") && propertiesSet.contains("duck")) {
                return new String[]{"duck", "spy"};
            }
            if (property.equals("happy") && propertiesSet.contains("sad")) {
                return new String[]{"sad", "happy"};
            }
            if (property.equals("sad") && propertiesSet.contains("happy")) {
                return new String[]{"even", "odd"};
            }
            if (property.equals("-happy") && propertiesSet.contains("-sad")) {
                return new String[]{"-sad", "-happy"};
            }
            if (property.equals("-sad") && propertiesSet.contains("-happy")) {
                return new String[]{"-happy", "-sad"};
            }
            if (property.equals("even") && propertiesSet.contains("-even")) {
                return new String[]{"-even", "even"};
            }
            if (property.equals("-even") && propertiesSet.contains("even")) {
                return new String[]{"even", "-even"};
            }
            if (property.equals("odd") && propertiesSet.contains("-odd")) {
                return new String[]{"-odd", "odd"};
            }
            if (property.equals("-odd") && propertiesSet.contains("odd")) {
                return new String[]{"odd", "-odd"};
            }
            if (property.equals("buzz") && propertiesSet.contains("-buzz")) {
                return new String[]{"-buzz", "buzz"};
            }
            if (property.equals("-buzz") && propertiesSet.contains("buzz")) {
                return new String[]{"buzz", "-buzz"};
            }
            if (property.equals("duck") && propertiesSet.contains("-duck")) {
                return new String[]{"-duck", "duck"};
            }
            if (property.equals("-duck") && propertiesSet.contains("duck")) {
                return new String[]{"duck", "-duck"};
            }
            if (property.equals("palindromic") && propertiesSet.contains("-palindromic")) {
                return new String[]{"-palindromic", "palindromic"};
            }
            if (property.equals("-palindromic") && propertiesSet.contains("palindromic")) {
                return new String[]{"palindromic", "-palindromic"};
            }
            if (property.equals("gapful") && propertiesSet.contains("-gapful")) {
                return new String[]{"-gapful", "gapful"};
            }
            if (property.equals("-gapful") && propertiesSet.contains("gapful")) {
                return new String[]{"gapful", "-gapful"};
            }
            if (property.equals("spy") && propertiesSet.contains("-spy")) {
                return new String[]{"-spy", "spy"};
            }
            if (property.equals("-spy") && propertiesSet.contains("spy")) {
                return new String[]{"spy", "-spy"};
            }
            if (property.equals("square") && propertiesSet.contains("-square")) {
                return new String[]{"-square", "square"};
            }
            if (property.equals("-square") && propertiesSet.contains("square")) {
                return new String[]{"square", "-square"};
            }
            if (property.equals("sunny") && propertiesSet.contains("-sunny")) {
                return new String[]{"-sunny", "sunny"};
            }
            if (property.equals("-sunny") && propertiesSet.contains("sunny")) {
                return new String[]{"sunny", "-sunny"};
            }
            if (property.equals("jumping") && propertiesSet.contains("-jumping")) {
                return new String[]{"-jumping", "jumping"};
            }
            if (property.equals("-jumping") && propertiesSet.contains("jumping")) {
                return new String[]{"jumping", "-jumping"};
            }
            if (property.equals("happy") && propertiesSet.contains("-happy")) {
                return new String[]{"-happy", "happy"};
            }
            if (property.equals("-happy") && propertiesSet.contains("happy")) {
                return new String[]{"happy", "-happy"};
            }
            if (property.equals("sad") && propertiesSet.contains("-sad")) {
                return new String[]{"-sad", "sad"};
            }
            if (property.equals("-sad") && propertiesSet.contains("sad")) {
                return new String[]{"sad", "-sad"};
            }
            propertiesSet.add(property);
        }
        return null;
    }
}