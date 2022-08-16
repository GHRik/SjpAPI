package com.sjp.sjpapi;

import java.io.IOException;

public class CurlHelper {

    private static CurlReader reader = new CurlReader();
    private static CurlValidator validator = new CurlValidator();


    public static String getOutputFromCurl(String word) throws IOException {

        if (word.trim().isEmpty() == true){
            word = "empty";
        }

        String outputFromCurl = readCurlFromSJP(word);

        if (validator.isCurlValidate(outputFromCurl) == false) {
	    return "";
        }
    }

    private static String readCurlFromSJP(String word) throws IOException {
        return reader.getCurlOutput("https://sjp.pl/"+word);
    }






}
