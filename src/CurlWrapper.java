package com.sjp.sjpapi;

public class CurlWrapper {

    public String wrappCurl(String curlOutput) {
        return deleteHeadFromOutput(curlOutput);
    }

    public String deleteHeadFromOutput(String curlOutput) {

        String outputWithoutHeadSection = curlOutput;

        String bodySectionStart = "<body>";
        int startBodySection = outputWithoutHeadSection.indexOf("<body>") + bodySectionStart.length() ;
        int finishBodySection = outputWithoutHeadSection.indexOf("</body>");
        outputWithoutHeadSection = outputWithoutHeadSection.substring(startBodySection,finishBodySection);

        return outputWithoutHeadSection;
    }


}
