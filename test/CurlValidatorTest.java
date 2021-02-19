package sjpAPI;

import junit.framework.TestCase;

public class CurlValidatorTest extends TestCase {

    private CurlValidator validator = new CurlValidator();

    public void testIsHTTPNotFound() {
        String mockCurl = "HTTP/1.1 404 Not Found\n" +
                "Server: nginx\n" +
                "Date: Thu, 18 Feb 2021 08:56:46 GMT\n" +
                "Content-Type: text/html; charset=iso-8859-1\n" +
                "Transfer-Encoding: chunked" +
                "<body>Test</body>";
        assertFalse(validator.isCurlValidate(mockCurl));
    }

    public void testIsHTTP200() {
        String mockCurl = "HTTP/1.1 200 OK\n" +
                "Server: nginx\n" +
                "Date: Thu, 18 Feb 2021 08:56:46 GMT\n" +
                "Content-Type: text/html; charset=iso-8859-1\n" +
                "Transfer-Encoding: chunked" +
                "<body>Test</body>";
        assertTrue(validator.isCurlValidate(mockCurl));
    }

    public void testIsHTTP200WithoutBody() {
        String mockCurl = "HTTP/1.1 200 OK\n" +
                "Server: nginx\n" +
                "Date: Thu, 18 Feb 2021 08:56:46 GMT\n" +
                "Content-Type: text/html; charset=iso-8859-1\n" +
                "Transfer-Encoding: chunked";
        assertFalse(validator.isCurlValidate(mockCurl));
    }

}