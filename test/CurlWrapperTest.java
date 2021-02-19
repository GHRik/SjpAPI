package sjpAPI;

import junit.framework.TestCase;

import org.junit.Assert;

public class CurlWrapperTest extends TestCase {

    private CurlWrapper wrapper = new CurlWrapper();

    public void testIsNOTHeadInOutput() {
        String mockCurl = "<head>asdasdsadasd</head> <body>fgdfggfhtyjfhghfgd</body> asfdfhtyhhjdffsdc";
        mockCurl = wrapper.wrappCurl(mockCurl);
        assertEquals(mockCurl,"fgdfggfhtyjfhghfgd");

    }
}