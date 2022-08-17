package sjpapi.api;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SjpWrapper {

    public String getWrapped (String curlOutput) throws JSONException, UnsupportedEncodingException {
        List<List<String>> wordsFromCurlOutput = regexForInfo(curlOutput);
        return translateArrayToJSON(wordsFromCurlOutput);

    }

    private List<List<String>> regexForInfo (String curlOutput) {

        List<List<String>> wrappedCurl = new ArrayList<>();
        if (isInDictionary(curlOutput)) {

            final String regex = "<h1[^>]*>(.+?)<\\/h1>.<p[^>]*>(.+?)<.+?(?=.*)href=\"\\/(.+?)\".+?znaczenie.+?<p[^>]*>(.+?)<\\/p>";
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

        return !curlOutput.contains("nie występuje w słowniku");
    }

    private String translateArrayToJSON(List<List<String>> wordsFromCurlOutput ) throws JSONException, UnsupportedEncodingException {
        String allWrappedWord;
        JSONObject jsonObject = new JSONObject();
        if (wordsFromCurlOutput.isEmpty()) {
            jsonObject.put("name", "-1");
            jsonObject.put("count","-1");
            jsonObject.put("variant","-1");
            jsonObject.put("canBeUsed", false);
            jsonObject.put("meaning", "-1");
        }
        else
        {
            jsonObject.put("name",wordsFromCurlOutput.get(0).get(0));
            jsonObject.put("count",wordsFromCurlOutput.size());
            for( int i = 0; i < wordsFromCurlOutput.size(); i++){
                jsonObject.put("canBeUsed"+"["+i+"]",TranslateCanBeUsed(wordsFromCurlOutput.get(i).get(1)));
                jsonObject.put("variant"+"["+i+"]", StringUtils.htmlToPolishLetter(wordsFromCurlOutput.get(i).get(2)));
                jsonObject.put("meaning"+"["+i+"]", wrappedDescription(wordsFromCurlOutput.get(i).get(3)));
            }
        }
        allWrappedWord = jsonObject.toString();
        return allWrappedWord;
    }

    private Boolean TranslateCanBeUsed(String oneParamOfWordFromCurl){
        return !oneParamOfWordFromCurl.startsWith("niedopuszczalne");

    }


    private boolean isDescriptionGoodFormat(String description) {
        return !StringUtils.hasSpecyficHTMLTags(description) && !description.contentEquals("KOMENTARZE:") && !description.contentEquals("POWIĄZANE HASŁA:");
    }

    private String wrappedDescription( String description ) {
        String desc = description;
        if (!isDescriptionGoodFormat(desc)){
            desc = "BAD FORMAT";
        }
        else {
            desc = changeBrTagOnNewLine(desc);
            desc = StringUtils.unescapeHTML(desc, 0);
        }

        return desc;
    }

    private String changeBrTagOnNewLine(String descritption ) {
        descritption = descritption.replaceAll("(?i)<br */?>","\n");
        return descritption;
    }


}
