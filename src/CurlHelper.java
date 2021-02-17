package sjpAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CurlHelper {

    private static CurlReader reader = new CurlReader();
    private static CurlValidator validator = new CurlValidator();
    private static CurlWrapper wrapper = new CurlWrapper();

    private static String readCurlFromSJP(String word) throws MalformedURLException {
        return reader.getCurlOutput("https://sjp.pl/"+word);
    }

    public static String getOutputFromCurl(String word) throws MalformedURLException {
        String outputFromCurl = readCurlFromSJP(word);

        if (validator.isCurlValidate(outputFromCurl) == true) {
            return wrapper.deleteHeadFromOutput(outputFromCurl);
        }
        return "";
    }




}
