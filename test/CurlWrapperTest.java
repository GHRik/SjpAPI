package com.sjp;

import junit.framework.TestCase;

public class CurlWrapperTest extends TestCase {

    private CurlWrapper wrapper = new CurlWrapper();

    public void testIsBettwenH1AndCommentSection() {
        String mockCurl = "<head>asdasdsadasd</head> <body><h1>fgdfggfhtyjfhghfgd</h1>KOMENTARZE:</body> asfdfhtyhhjdffsdc";
        mockCurl = wrapper.wrappCurl(mockCurl);
        assertEquals(mockCurl,"<h1>fgdfggfhtyjfhghfgd</h1>");

    }
}