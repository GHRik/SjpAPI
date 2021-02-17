package sjpAPI;

public class CurlValidator {

    public Boolean isCurlValidate( String curlOutput ) {

        if (isResponseOK( curlOutput ) == true) {
            return true;
        }
        else {
            return false;
        }
    }

    private Boolean isResponseOK( String curlOutput ) {

        if (curlOutput.contains("200 OK")) {
            return true;
        }
        else {
            return false;
        }
    }
}
