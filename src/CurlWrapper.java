package com.sjp.sjpapi;

import org.apache.commons.lang3.StringUtils;

public class CurlWrapper {

    public String wrappCurl(String curlOutput) {
        return deleteHeadFromOutput(curlOutput);
    }

    public String deleteHeadFromOutput(String curlOutput) {

        String outputWithoutHeadSection = curlOutput;
        outputWithoutHeadSection = StringUtils.substringBetween(outputWithoutHeadSection, "<body>", "</body>");

        return outputWithoutHeadSection;
    }


}
