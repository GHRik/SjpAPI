package sjpAPI;

import org.apache.commons.lang3.StringUtils;

public class CurlWrapper {

    public String deleteHeadFromOutput(String output) {

        String outputWithoutHeadSection = output;
        outputWithoutHeadSection = StringUtils.substringBetween(outputWithoutHeadSection, "<body>", "</body>");

        return outputWithoutHeadSection;
    }


}
