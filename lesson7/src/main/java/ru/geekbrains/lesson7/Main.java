package ru.geekbrains.lesson7;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class Main {
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";

    private static final String SAINT_PETERSBURG_KEY = "295212";
    private static final String API_KEY = "iuonDKQLZgKVwlkW6bGT81TUP5C0Fgno";


    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(SAINT_PETERSBURG_KEY)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

//        System.out.println(url.toString());

        Request requesthttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String jsonResponse = client.newCall(requesthttp).execute().body().string();

        ObjectMapper objectMapper = new ObjectMapper();

        WeatherResponse weatherResponse = objectMapper.readValue(jsonResponse, WeatherResponse.class);

//        System.out.println(weatherResponse.toString());

        DailyForecasts[] dailyForecasts = weatherResponse.getDailyForecasts();

        for (int i = 0; i < 5 ; i++) {
            Temperature temperature = dailyForecasts[i].getTemperature();
            System.out.println("Погода в городе Санкт-Петербург на дату " + dailyForecasts[i].getDate() + " ожидается " + dailyForecasts[i].getDay().getIconPhrase() + " ," + dailyForecasts[i].getNight().getIconPhrase() +  ", температура - " + temperature.getMaximum().getValue() + "C - " + temperature.getMinimum().getValue() + "C");
        }
    }
}

