package sjpAPI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

public class SjpAPI {

    private List<MyWord> actualWords = null;

    public void getWord(String word) throws IOException {
        this.actualWords = SjpHelper.translateFromCurlToMyWord(CurlHelper.getOutputFromCurl(word));

    }

    public boolean canBeUsedInScrabble() {
        if (actualWords.isEmpty() == false) {
            for(int i = 0; i < actualWords.size(); i++) {
                if (actualWords.get(i).isCanBeUsed() == true){
                    return true;
                }
            }

        }
        return false;
    }

    public boolean isWordExistInDictionary() {
        if (actualWords.isEmpty() == false)
        {
            return false;
        }
        else {
            return true;
        }
    }


    public String getJson()
    {

        String json = "\n"+'"'+actualWords.get(0).getName()+'"'+"\n{";
        for(int i = 0; i < actualWords.size(); i++) {
            json += actualWords.get(i).getJSON();
        }
        json += "\n}";

        return json;
    }


}
