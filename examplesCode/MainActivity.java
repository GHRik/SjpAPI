package com.sjp.sjpapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;



public class MainActivity extends AppCompatActivity {

    private SjpAPI sjpApi = new SjpAPI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView meaningOfWordText = (TextView)findViewById(R.id.meaningOfWord);
        final Button goButton = (Button)findViewById(R.id.goButton);
        final EditText nameOfWord = (EditText)findViewById(R.id.nameOfWord);

        goButton.setOnClickListener(v -> {
            try {
                String mean = sjpApi.getWord(nameOfWord.getText().toString());
                meaningOfWordText.setText(mean);
                Log.i("curl",mean);
                JSONObject jsonObject = new JSONObject(mean);
                meaningOfWordText.setText(mean);


            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });


    }

}