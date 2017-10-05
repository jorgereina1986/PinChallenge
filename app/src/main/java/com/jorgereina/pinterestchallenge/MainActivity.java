package com.jorgereina.pinterestchallenge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jorgereina.pinterestchallenge.models.PinsResponse;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private List<PinsResponse> pinsResponses;
    private List<PinsResponse> pinList;
    private RecyclerView pinsRecyclerView;
    private PinsAdapter pinsAdapter;
    private LinearLayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        layoutManager = new GridLayoutManager(this,2);
        pinList = new ArrayList<>();
        pinsAdapter = new PinsAdapter(pinList, getApplicationContext());
        textView = (TextView) findViewById(R.id.text);
        pinsRecyclerView = (RecyclerView) findViewById(R.id.pins_rv);
        pinsRecyclerView.setLayoutManager(layoutManager);
        pinsRecyclerView.setAdapter(pinsAdapter);

        pinsRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (layoutManager.findLastCompletelyVisibleItemPosition() == pinList.size()-1){
                    pinList.addAll(pinList);
                    pinsAdapter.notifyDataSetChanged();
                }
            }
        });

        populateJsonDataToRecyclerView();

    }

    private void populateJsonDataToRecyclerView() {

        Gson gson = new Gson();
        Type listType = new TypeToken<List<PinsResponse>>() {
        }.getType();

        pinsResponses = gson.fromJson(loadJSONFromAsset(), listType);
        pinList.addAll(pinsResponses);
        pinsAdapter.notifyDataSetChanged();

    }


    private String loadJSONFromAsset() {
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
