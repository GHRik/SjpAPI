package sjpAPI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class CurlReader {
    private String output = "";

    private void read(String https) throws MalformedURLException {
        URL url = new URL(https);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
            for (String line; (line = reader.readLine()) != null;) {
                this.output = this.output + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getCurlOutput(String https) throws MalformedURLException {
        this.read(https);
        return this.output;
    }
}
