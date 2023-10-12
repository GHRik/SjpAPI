package sjpapi.api;

public class CurlValidator {

    public Boolean isCurlValidate( String curlOutput ) {

        return (isResponseOK(curlOutput) || isResponseNotFound(curlOutput)) && isBodySection(curlOutput);
    }

    private Boolean isResponseOK( String curlOutput ) {

        return curlOutput.startsWith("200");
    }

    private Boolean isResponseNotFound( String curlOutput ) {

        return curlOutput.startsWith("400");
    }

    private Boolean isBodySection( String curlOutput ) {
        return curlOutput.contains("<body>") && curlOutput.contains("</body>");
    }
}
