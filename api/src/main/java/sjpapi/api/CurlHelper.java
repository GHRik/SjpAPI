package sjpapi.api;

import java.io.IOException;

public class CurlHelper {

    private static final CurlReader reader = new CurlReader();
    private static final CurlValidator validator = new CurlValidator();

    private CurlHelper() {
    }

    public static String getOutputFromCurl(String word) {

        if (word.trim().isEmpty()){
            word = "empty";
        }

        String outputFromCurl = readCurlFromSJP(word);

        if (Boolean.FALSE.equals(validator.isCurlValidate(outputFromCurl))){
            return "";
        }
        return outputFromCurl;
    }

    private static String readCurlFromSJP(String word) {
        return reader.getCurlOutput("https://sjp.pl/"+word);
    }
}
