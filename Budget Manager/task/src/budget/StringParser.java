package budget;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringParser {

    public double getPrice(String s) {
        Pattern javaPattern = Pattern.compile("\\$.*");
        Matcher matcher = javaPattern.matcher(s);
        matcher.find();
        String s1 = matcher.group();
        return Double.parseDouble(s1.substring(1, s1.length()));
    }

    public String getName(String s) {
        Pattern javaPattern = Pattern.compile(".*\\$");
        Matcher matcher = javaPattern.matcher(s);
        matcher.find();
        return matcher.group().substring(0, matcher.end() - 1).trim();
    }
/*
    public int getPrice(String s) {
        String first = s.substring(0, s.length() - 3);
        String second = s.substring(s.length() - 2, s.length());
        return Integer.parseInt(first) * 100 + Integer.parseInt(second);
    }
*/
}
