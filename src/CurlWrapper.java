package com.sjp.sjpapi;

public class CurlWrapper {

    public String wrappCurl(String curlOutput) {
        return deleteHeadFromOutput(curlOutput);
    }

    public String deleteHeadFromOutput(String curlOutput) {

        String outputWithoutHeadSection = curlOutput;

        String bodySectionStart = "<body>";
        String bodySectionFinis = "</body>";
        outputWithoutHeadSection = StringUtils.substringBettwen(outputWithoutHeadSection,bodySectionStart,bodySectionFinis);

        return outputWithoutHeadSection;
    }


}
