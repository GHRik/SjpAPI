package com.sjp.sjpapi;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

public class SjpAPI {

    public String getWord(String word) throws IOException, JSONException {

            String json = "";

            json = SjpHelper.translateFromCurlToJSON(CurlHelper.getOutputFromCurl(word));
            return json;
    }


}
