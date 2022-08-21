package basic;

import java.util.Optional;

public class NullSafety {

    public static String getNullStr() {
        return null;
    }

    public static int getLengthIfNotNull(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }

        return str.length();
    }

    public static void main(String[] args) {
        String nullStr = getNullStr();

        String str = Optional.ofNullable(nullStr).orElse("test nullable");
        System.out.println(str.length());

        System.out.println(getLengthIfNotNull(nullStr));
    }
}
