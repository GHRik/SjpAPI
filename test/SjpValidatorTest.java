package sjpapi.api;

import junit.framework.TestCase;

public class SjpValidatorTest extends TestCase {

    private SjpValidator validator = new SjpValidator();


    public void testIsCurlHaveH1Tag() {
        String mockCurl = "<asd asd as das d <h1 (any style options)>dsa</h1>";
        assertTrue(validator.isCurlWithWordValidate(mockCurl));
    }
    public void testIsCurlDONTHaveH1Tag() {
        String mockCurl = "das asdas dd dasdas daas dd<body>something</body>";
        assertFalse(validator.isCurlWithWordValidate(mockCurl));
    }

}