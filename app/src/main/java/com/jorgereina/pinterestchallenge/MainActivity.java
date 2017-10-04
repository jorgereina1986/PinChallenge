package com.jorgereina.pinterestchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jorgereina.pinterestchallenge.models.PinsResponse;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.text);

//        try {
//            JsonReader reader = new JsonReader(new FileReader(String.valueOf(getApplicationContext().getAssets().open("pins_formatted.json"))));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        Gson gson = new Gson();
        Type listType = new TypeToken<List<PinsResponse>>(){}.getType();

        List<PinsResponse> pinsResponses = gson.fromJson(loadJSONFromAsset(), listType);

        textView.setText(pinsResponses.get(0).getDescription());


    }

    public String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getApplicationContext().getAssets().open("pins_formatted.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }


}
