package sjpAPI;

import android.content.res.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class CurlReader {

    public String getCurlOutput(String https) throws IOException {
        return this.read(https);
    }

    private String read(String https) throws IOException {

        String curlOutput = "";
        HttpURLConnection urlConnection = null;
        URL url = new URL(https);
        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.connect();

        curlOutput += urlConnection.getResponseCode();

        BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = br.readLine()) != null) {
            curlOutput += line + " ";
        }
        br.close();

        return curlOutput;
    }


}
