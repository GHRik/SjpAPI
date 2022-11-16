package sjpapi.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CurlReader {

    private String readed = "";

    public String getCurlOutput(final String https) {


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        readed = CurlReader.this.read(https);
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return readed;
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
            if ("404".equals(response))
            {
                br = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream()));
            }
            else
            {
                br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            }

            String line;
            while ((line = br.readLine()) != null) {
                curlOutput.append(line).append(" ");
            }
            br.close();
            urlConnection.disconnect();
        }
        catch(Exception e) {
            curlOutput = new StringBuilder();
        }

        return curlOutput.toString();
    }


}
