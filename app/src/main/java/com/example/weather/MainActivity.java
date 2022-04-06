package com.example.weather;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;


import com.example.weather.R;
import com.example.weather.adapter.WeatherAdapter;
import com.example.weather.model.Weather;
import com.example.weather.service.WeatherApiClient;
import com.example.weather.service.WeatherApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView rvCuaca;
    Button btnSearch;
    EditText editSearch;
//    List<BeritaModel> listBerita= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvCuaca=findViewById(R.id.rvCuaca);
        btnSearch=findViewById(R.id.btnSearch);
        editSearch=findViewById(R.id.editSearch);
//        listBerita.add(new BeritaModel("Orang ini mati 3 kali, ini kata resti","Health","https://assets.pikiran-rakyat.com/crop/0x0:0x0/x/photo/2022/03/30/2810251709.jpg", "Ini adalah salah satu manusia yang paling sok tau di dunia"));
//        listBerita.add(new BeritaModel("Juara Coding itu mantap, ini kata nining","Lifestyle","https://juaracoding.com/public/dummy/img_pak_paulus.png", "Salah satu Pengajar di JuaraCoding yang teladan dan juga kadang absurd"));
//        listBerita.add(new BeritaModel("Banci ini ditangkap warga karna tidak banci","Travel","https://cdn0-production-images-kly.akamaized.net/C78TuqRI6EvujNd5nHZApBQ9apw=/1200x900/smart/filters:quality(75):strip_icc():format(jpeg)/kly-media-production/medias/3951801/original/052272700_1646356554-Tessy_1.jpg", "Artis yang baik hati dan juga humble"));

        WeatherApiInterface weatherApiInterface = WeatherApiClient.getRetrofit().create(WeatherApiInterface.class);

        Call<Weather>call = weatherApiInterface.getEverythingWeatherBySearch("jakarta", "ed15190f84b549c7af82922916a96c93");

        call.enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                WeatherAdapter adapter = new WeatherAdapter(response.body(), MainActivity.this);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
                rvCuaca.setLayoutManager(layoutManager);
                rvCuaca.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {
                System.out.println(t);
            }

        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cari =editSearch.getText().toString();
                Call<Weather>call1= weatherApiInterface.getEverythingWeatherBySearch(cari, "b170f97f0d55d140d27a2a838c67ab17");
                call1.enqueue(new Callback<Weather>() {
                    @Override
                    public void onResponse(Call<Weather> call, Response<Weather> response) {
                        WeatherAdapter adapter = new WeatherAdapter(response.body(), MainActivity.this);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false);
                        rvCuaca.setLayoutManager(layoutManager);
                        rvCuaca.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<Weather> call, Throwable t) {
                        System.out.println(t);
                    }
                });
            }

        });
    }
}

