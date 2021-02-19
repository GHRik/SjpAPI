package sjpAPI;

import java.util.List;



public class SjpHelper {

    private static SjpValidator validator = new SjpValidator();
    private static SjpWrapper wrapper = new SjpWrapper();

    public static List<MyWord> translateFromCurlToMyWord( String curl ) {

        List<MyWord> words = null;

        if (validator.isCurlWithWordValidate(curl)) {
            words = wrapper.getWrapped(curl);
        }
        return words;
    }


}
