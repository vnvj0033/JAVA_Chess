package util;

public class StringUtil {
    public final static String NEW_LINE = System.lineSeparator();

    private StringUtil() {}

    public static String appendNewLine(String s) {
        return s + NEW_LINE;
    }
}
