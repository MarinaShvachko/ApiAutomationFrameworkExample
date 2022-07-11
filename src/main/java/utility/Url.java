package utility;

public class Url {
    private final static String BASE_URI = "https://api.github.com";

    public static String getBaseUrI() {
        return BASE_URI;
    }

    public static String getBaseUrI(String resourcePath) {
        return BASE_URI + resourcePath;
    }
}
