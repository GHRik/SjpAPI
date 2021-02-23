package com.sjp.sjpapi;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SjpWrapper {

    public String getWrapped (String curlOutput) throws JSONException {
        List<List<String>> wordsFromCurlOutput = regexForInfo(curlOutput);
        return translateArrayToJSON(wordsFromCurlOutput);

    }

    private List<List<String>> regexForInfo (String curlOutput) {

        List<List<String>> wrappedCurl = new ArrayList<>();
        if (isInDictionary(curlOutput) == true) {

            final String regex = "<h1[^>]*>(.+?)<\\/h1>.<p[^>]*>(.+?)<.+?(?=.*)znaczenie.+?<p[^>]*>(.+?)<\\/p>";
            final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            final Matcher matcher = pattern.matcher(curlOutput);

            wrappedCurl = new ArrayList<>();
            while (matcher.find()) {
                List<String> definitionOfWord = new ArrayList<>();
                for (int j = 1; j <= matcher.groupCount(); j++) {
                    definitionOfWord.add(matcher.group(j));
                }
                wrappedCurl.add(definitionOfWord);
            }
        }
        return wrappedCurl;

    }

    private Boolean isInDictionary( String curlOutput ) {

        if (curlOutput.contains("nie występuje w słowniku")) {
            return false;
        } else {
            return true;
        }
    }

    private String translateArrayToJSON(List<List<String>> wordsFromCurlOutput ) throws JSONException {
        String allWrappedWord = "";
        JSONObject jsonObject = new JSONObject();
        if ( wordsFromCurlOutput.isEmpty() == true ) {
            jsonObject.put("name", "-1");
            jsonObject.put("count","-1");
            jsonObject.put("canBeUsed", false);
            jsonObject.put("meaning", "-1");

            String emptyWord = jsonObject.toString();
            allWrappedWord = emptyWord;
        }
        else
        {
            jsonObject.put("name",wordsFromCurlOutput.get(0).get(0));
            jsonObject.put("count",wordsFromCurlOutput.size());
            for( int i = 0; i < wordsFromCurlOutput.size(); i++){
                jsonObject.put("canBeUsed"+"["+i+"]",TranslateCanBeUsed(wordsFromCurlOutput.get(i).get(1)));
                jsonObject.put("meaning"+"["+i+"]", changeBrTagOnNewLine(wordsFromCurlOutput.get(i).get(2)));
            }
            String newWord = jsonObject.toString();
            allWrappedWord = newWord;

        }
        return allWrappedWord;
    }

    private Boolean TranslateCanBeUsed(String oneParamOfWordFromCurl){
        if ( oneParamOfWordFromCurl.startsWith("niedopuszczalne") ) {
            return false;
        }
        else {
            return true;
        }

    }

    private String changeBrTagOnNewLine(String descritption ) {
        descritption = descritption.replaceAll("(?i)<br */?>","\n");
        return descritption;
    }

}
