package sjpapi.api;

public class CurlValidator {

    public Boolean isCurlValidate( String curlOutput ) {

        return isResponseOK(curlOutput) && isBodySection(curlOutput);
    }

    private Boolean isResponseOK( String curlOutput ) {

        return curlOutput.startsWith("200");
    }

    private Boolean isBodySection( String curlOutput ) {
        if (curlOutput.contains("<body>") && curlOutput.contains("</body>")){
            return true;
        }
        return false;
    }
}
