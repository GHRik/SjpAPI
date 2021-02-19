package sjpAPI;

public class SjpValidator {


    public Boolean isCurlWithWordValidate( String curlOutput ) {

        if (isH1TagExist( curlOutput ) == true) {
            return true;
        }
        else {
            return false;
        }
    }

    private Boolean isH1TagExist( String curlOutput ) {
       
        boolean isOpenH1 = curlOutput.contains("<h1 ");
        boolean isCloseH1 = curlOutput.contains("</h1>");
        return (isOpenH1 && isCloseH1);
    }
}
