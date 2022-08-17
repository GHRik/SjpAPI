package sjpapi.api;

public class SjpValidator {


    public Boolean isCurlWithWordValidate( String curlOutput ) {

        return isH1TagExist(curlOutput);
    }

    private Boolean isH1TagExist( String curlOutput ) {
       
        boolean isOpenH1 = curlOutput.contains("<h1 ");
        boolean isCloseH1 = curlOutput.contains("</h1>");
        return (isOpenH1 && isCloseH1);
    }
}
