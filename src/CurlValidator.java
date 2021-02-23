package com.sjp.sjpapi;

public class CurlValidator {

    public Boolean isCurlValidate( String curlOutput ) {

        if (isResponseOK(curlOutput) && isBodySection(curlOutput)) {
            return true;
        }
        else {
            return false;
        }
    }

    private Boolean isResponseOK( String curlOutput ) {

        if (curlOutput.startsWith("200")) {
            return true;
        }
        else {
            return false;
        }
    }

    private Boolean isBodySection( String curlOutput ) {
        if (curlOutput.contains("<body>") && curlOutput.contains("</body>")){
            return true;
        }
        else {

        }
        return false;
    }
}
