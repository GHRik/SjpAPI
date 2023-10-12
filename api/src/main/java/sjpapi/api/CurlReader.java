package sjpapi.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

import static java.util.logging.Level.SEVERE;

public class CurlReader {

    private String readResult = "";
    private static final Logger logger = Logger.getLogger(CurlReader.class.getName());

    public String getCurlOutput(final String https) {

        Thread thread = new Thread(() -> {
            try {
                readResult = read(https);
            } catch (MalformedURLException e) {
                logger.log(SEVERE, "MalformedURLException");
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        return readResult;
    }


    private String read(String https) throws IOException {

        StringBuilder curlOutput = new StringBuilder();
        HttpURLConnection urlConnection;
        URL url = new URL(https);


        urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setReadTimeout(500);
        urlConnection.setDefaultUseCaches(false);
        urlConnection.setUseCaches(false);
        try {
            urlConnection.connect();
            curlOutput.append(urlConnection.getResponseCode());

            BufferedReader br;
            String response = curlOutput.toString();
            if ("404".equals(response)) {
                br = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            }

            String line;
            while ((line = br.readLine()) != null) {
                curlOutput.append(line).append(" ");
            }
            br.close();
            urlConnection.disconnect();
        } catch (Exception e) {
            curlOutput = new StringBuilder();
        }

        return curlOutput.toString();
    }
}
