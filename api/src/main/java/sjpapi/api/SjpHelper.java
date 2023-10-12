package sjpapi.api;

import org.json.JSONException;

import java.io.UnsupportedEncodingException;

public class SjpHelper {

    private static final SjpValidator validator = new SjpValidator();
    private static final SjpWrapper wrapper = new SjpWrapper();

    private SjpHelper() {
    }

    public static String translateFromCurlToJSON(String curl ) throws JSONException, UnsupportedEncodingException {

        String json = "EMPTY";

        if (validator.isCurlWithWordValidate(curl)) {
            json = wrapper.getWrapped(curl);
        }
        return json;
    }


}
