package com.sjp.sjpapi;

import org.json.JSONException;

import java.util.ArrayList;



public class SjpHelper {

    private static SjpValidator validator = new SjpValidator();
    private static SjpWrapper wrapper = new SjpWrapper();

    public static String translateFromCurlToJSON(String curl ) throws JSONException {

        String json = "EMPTY";

        if (validator.isCurlWithWordValidate(curl)) {
            json = wrapper.getWrapped(curl);
        }
        return json;
    }


}
