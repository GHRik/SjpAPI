package sjpAPI;

public class SjpAPI {

    private CurlHelper curlHelper = new CurlHelper();

    public static boolean canBeUsedInScrabble(String word) {

        return false;
    }

    public static boolean isWordExistInDictionary(String word) {

        return false;
    }

    public static String getMeaningOf(String word) {

        String mean;
        mean = "empty";
        return mean;
    }

}
