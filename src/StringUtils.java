package sjpapi.api;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    private static final HashMap<String, String> htmlEntities;

    static {
        htmlEntities = new HashMap<>();
        htmlEntities.put("&lt;", "<");
        htmlEntities.put("&gt;", ">");
        htmlEntities.put("&amp;", "&");
        htmlEntities.put("&quot;", "'");
        htmlEntities.put("&agrave;", "à");
        htmlEntities.put("&Agrave;", "À");
        htmlEntities.put("&acirc;", "â");
        htmlEntities.put("&auml;", "ä");
        htmlEntities.put("&Auml;", "Ä");
        htmlEntities.put("&Acirc;", "Â");
        htmlEntities.put("&aring;", "å");
        htmlEntities.put("&Aring;", "Å");
        htmlEntities.put("&aelig;", "æ");
        htmlEntities.put("&AElig;", "Æ");
        htmlEntities.put("&ccedil;", "ç");
        htmlEntities.put("&Ccedil;", "Ç");
        htmlEntities.put("&eacute;", "é");
        htmlEntities.put("&Eacute;", "É");
        htmlEntities.put("&egrave;", "è");
        htmlEntities.put("&Egrave;", "È");
        htmlEntities.put("&ecirc;", "ê");
        htmlEntities.put("&Ecirc;", "Ê");
        htmlEntities.put("&euml;", "ë");
        htmlEntities.put("&Euml;", "Ë");
        htmlEntities.put("&iuml;", "ï");
        htmlEntities.put("&Iuml;", "Ï");
        htmlEntities.put("&ocirc;", "ô");
        htmlEntities.put("&Ocirc;", "Ô");
        htmlEntities.put("&ouml;", "ö");
        htmlEntities.put("&Ouml;", "Ö");
        htmlEntities.put("&oslash;", "ø");
        htmlEntities.put("&Oslash;", "Ø");
        htmlEntities.put("&szlig;", "ß");
        htmlEntities.put("&ugrave;", "ù");
        htmlEntities.put("&Ugrave;", "Ù");
        htmlEntities.put("&ucirc;", "û");
        htmlEntities.put("&Ucirc;", "Û");
        htmlEntities.put("&uuml;", "ü");
        htmlEntities.put("&Uuml;", "Ü");
        htmlEntities.put("&nbsp;", " ");
        htmlEntities.put("&copy;", "\u00a9");
        htmlEntities.put("&reg;", "\u00ae");
        htmlEntities.put("&euro;", "\u20a0");
    }


    // Function from
    // https://www.rgagnon.com/javadetails/java-0307.html
    public static String unescapeHTML(String source, int start) {
        int startOfHtmlSpecialCharCombination, closeOfHtmlSpecialCharCombination;

        startOfHtmlSpecialCharCombination = source.indexOf("&", start);
        if (startOfHtmlSpecialCharCombination > -1) {
            closeOfHtmlSpecialCharCombination = source.indexOf(";", startOfHtmlSpecialCharCombination);
            if (closeOfHtmlSpecialCharCombination > startOfHtmlSpecialCharCombination) {
                String entityToLookFor = source.substring(startOfHtmlSpecialCharCombination, closeOfHtmlSpecialCharCombination + 1);
                String value = htmlEntities.get(entityToLookFor);
                if (value != null) {
                    source = source.substring(0, startOfHtmlSpecialCharCombination) +
                            value +
                            source.substring(closeOfHtmlSpecialCharCombination + 1);
                    return unescapeHTML(source, startOfHtmlSpecialCharCombination + 1); // recursive call
                }
            }
        }
        return source;
    }

    public static String htmlToPolishLetter(String htmlWithBadCoding) throws UnsupportedEncodingException {

        return URLDecoder.decode(htmlWithBadCoding, "UTF-8");
    }

    public static boolean hasSpecyficHTMLTags(String text){
        String HTML_PATTERN = "<a[^>]*>.+?<\\/a>|<span[^>]*.+?<\\/span>|<p[^>]*.+?<\\/p>";
        Pattern pattern = Pattern.compile(HTML_PATTERN);
        Matcher matcher = pattern.matcher(text);
        return matcher.find();
    }

    public static String deleteSpecialChar(String text){
        text = text.replaceAll("[^\\p{Alnum}\\s]]?", "");
        return text;
    }
}