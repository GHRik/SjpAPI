package sjpAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SjpWrapper {

    public List<MyWord> getWrapped (String curlOutput) {
        List<List<String>> wordsFromCurlOutput = regexForInfo(curlOutput);
        return translateArrayToMyWord(wordsFromCurlOutput);

    }

    private List<List<String>> regexForInfo (String curlOutput) {

        List<List<String>> wrappedCurl = new ArrayList<List<String>>();
        if (isInDictionary(curlOutput) == true) {

            final String regex = "<h1[^>]*>(.+?)<\\/h1>.<p[^>]*>(.+?)<.+?(?=.*)znaczenie.+?<p[^>]*>(.+?)<\\/p>";
            final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
            final Matcher matcher = pattern.matcher(curlOutput);

            wrappedCurl = new ArrayList<List<String>>();
            while (matcher.find()) {
                List<String> definitionOfWord = new ArrayList<String>();
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

    private List<MyWord> translateArrayToMyWord( List<List<String>> wordsFromCurlOutput ) {
        List<MyWord> allWrappedWords = new ArrayList<>();
        if ( wordsFromCurlOutput.isEmpty() == true ) {
            MyWord emptyWord = new MyWord("-1",false,"-1");

            allWrappedWords.add(emptyWord);
        }
        else
        {
            for( int i = 0; i < wordsFromCurlOutput.size(); i++){
                String name = wordsFromCurlOutput.get(i).get(0);
                Boolean canBeUsed = TranslateCanBeUsed(wordsFromCurlOutput.get(i).get(1));
                String description = changeBrTagOnNewLine(wordsFromCurlOutput.get(i).get(2));
                MyWord newWord = new MyWord(name,canBeUsed,description);
                allWrappedWords.add(newWord);
            }
        }
        return allWrappedWords;
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
        descritption.replaceAll("<br>|</br>","\n");
        return descritption;
    }
}
