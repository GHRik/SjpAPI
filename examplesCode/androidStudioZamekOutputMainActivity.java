package scrabble.helper;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.net.MalformedURLException;

import sjpAPI.CurlHelper;
import sjpAPI.SjpAPI;

public class MainActivity extends AppCompatActivity {

    private SjpAPI sjpApi = new SjpAPI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CurlHelper curlHelper = new CurlHelper();


        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    try {
                        sjpApi.getWord("zamek");
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

        Log.i("Output",sjpApi.getJson());
    }
}