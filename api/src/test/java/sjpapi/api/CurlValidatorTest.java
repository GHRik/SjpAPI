package sjpapi.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CurlValidatorTest {

    private CurlValidator validator = new CurlValidator();

    @Test
    void testIsHTTPNotFound() {
        String mockCurl = "404 Not Found\n" +
                "Server: nginx\n" +
                "Date: Thu, 18 Feb 2021 08:56:46 GMT\n" +
                "Content-Type: text/html; charset=iso-8859-1\n" +
                "Transfer-Encoding: chunked" +
                "<body>Test</body>";
        assertFalse(validator.isCurlValidate(mockCurl));
    }

    @Test
    void testIsHTTP200() {
        String mockCurl = "200 OK\n" +
                "Server: nginx\n" +
                "Date: Thu, 18 Feb 2021 08:56:46 GMT\n" +
                "Content-Type: text/html; charset=iso-8859-1\n" +
                "Transfer-Encoding: chunked" +
                "<body>Test</body>";
        assertTrue(validator.isCurlValidate(mockCurl));
    }

    @Test
    void testIsHTTP200WithoutBody() {
        String mockCurl = "200 OK\n" +
                "Server: nginx\n" +
                "Date: Thu, 18 Feb 2021 08:56:46 GMT\n" +
                "Content-Type: text/html; charset=iso-8859-1\n" +
                "Transfer-Encoding: chunked";
        assertFalse(validator.isCurlValidate(mockCurl));
    }
}