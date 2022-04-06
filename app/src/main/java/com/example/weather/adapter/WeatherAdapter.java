package com.example.weather.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.weather.R;
import com.example.weather.model.Weather;

import java.net.URL;
import java.util.List;




public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private Weather weather;
    private Context context;

    public WeatherAdapter(Weather weather, Context context){
        this.weather = weather;
        this.context = context;
    }

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_weather,parent,false);
            return new WeatherAdapter.WeatherViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherAdapter.WeatherViewHolder holder, int position) {
        Glide.with(context).load(weather.getWeather().get(position).getIcon()).into(holder.imageWeather);
        holder.txtMain.setText(weather.getWeather().get(position).getMain());
        holder.txtDescription.setText(weather.getWeather().get(position).getDescription());
        holder.txtTemperature.setText(String.valueOf(weather.getMain().getTemp()));
        holder.txtHumidity.setText(weather.getMain().getHumidity());


//        holder.imageWeather.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, DetailNews.class);
//                intent.putExtra("weather", weather.get(position));
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        ImageView imageWeather;
        TextView txtDescription, txtMain, txtTemperature, txtHumidity;

        public WeatherViewHolder(@NonNull View itemView) {
        super(itemView);
        imageWeather = itemView.findViewById(R.id.imageWeather);
        txtDescription = itemView.findViewById(R.id.txtDescription);
        txtMain = itemView.findViewById(R.id.txtMain);
        txtHumidity = itemView.findViewById(R.id.txtHumidity);
        txtTemperature = itemView.findViewById(R.id.txtTemperature);
        }
    }

}
