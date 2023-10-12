package sjpapi.api;

import java.io.IOException;

public class CurlHelper {

    private static final CurlReader reader = new CurlReader();
    private static final CurlValidator validator = new CurlValidator();

    private CurlHelper() {
    }

    public static String getOutputFromCurl(String word) throws IOException {

        if (word.trim().isEmpty()){
            word = "empty";
        }

        String outputFromCurl = readCurlFromSJP(word);

        if (!validator.isCurlValidate(outputFromCurl)){
            return "";
        }
        return outputFromCurl;
    }

    private static String readCurlFromSJP(String word) throws IOException {
        return reader.getCurlOutput("https://sjp.pl/"+word);
    }
}
