package com.sjp.sjpapi;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class SjpAPI {

    public String getWord(String word) throws IOException, JSONException {
        String json = "";
        String wordWithoutSpecialChar = "";
        wordWithoutSpecialChar = StringUtils.deleteSpecialChar(word);
        json = SjpHelper.translateFromCurlToJSON(CurlHelper.getOutputFromCurl(wordWithoutSpecialChar));
        return json;
    }


}
