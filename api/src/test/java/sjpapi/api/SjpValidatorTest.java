package sjpapi.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SjpValidatorTest {

    private final SjpValidator validator = new SjpValidator();

    @Test
    void testIsCurlHaveH1Tag() {
        String mockCurl = "<asd asd as das d <h1 (any style options)>dsa</h1>";
        assertTrue(validator.isCurlWithWordValidate(mockCurl));
    }

    @Test
    void testIsCurlDONTHaveH1Tag() {
        String mockCurl = "das asdas dd dasdas daas dd<body>something</body>";
        assertFalse(validator.isCurlWithWordValidate(mockCurl));
    }

}