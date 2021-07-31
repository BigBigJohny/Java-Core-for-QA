package ru.geekbrains.lesson8;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.*;
import java.util.Scanner;

import static ru.geekbrains.lesson8.Repository.saveBd;
import static ru.geekbrains.lesson8.Repository.selectAll;

public class Main {
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String API_VERSION = "v1";
    private static final String FORECAST_TYPE = "daily";
    private static final String FORECAST_PERIOD = "5day";

    private static final String API_KEY = "jo2eGkAGcQ5QsDZ0LR8fgI4GGVucU74E";

    private static final String BELGOROD_KEY = "292195";
    private static final String SAINT_PETERSBURG_KEY = "295212";
    private static final String MOSСOW_KEY = "294021";
    private static final String SARATOV_KEY = "295382";
    private static final String UFA_KEY = "292177";
    private static final String KAZAN_KEY = "295954";
    private static final String IRKUTSK_KEY = "292712";
    private static final String VORONEZH_KEY = "296543";
    private static final String SAMARA_KEY = "290396";
    private static final String OMSK_KEY = "294463";

    private static final String BELGOROD_NAME = "Белгород";
    private static final String SAINT_PETERSBURG_NAME = "Санкт- Петербург";
    private static final String MOSСOW_NAME = "Москва";
    private static final String SARATOV_NAME = "Саратов";
    private static final String UFA_NAME = "Уфа";
    private static final String KAZAN_NAME = "Казань";
    private static final String IRKUTSK_NAME = "Иркутск";
    private static final String VORONEZH_NAME = "Воронеж";
    private static final String SAMARA_NAME = "Самара";
    private static final String OMSK_NAME = "Омск";

    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String menu = "Меню\n" + "1 - Погода в Белгороде\n" + "2 - Погода в Санкт- Петербурге\n" + "3 - Погода в Москве\n" +
                "4 - Погода в Саратове\n" + "5 - Погода в Уфе\n" + "6 - Погода в Казане\n" + "7 - Погода в Иркутске\n" +
                "8 - Погода в Воронеже\n" + "9 - Погода в Самаре\n" + "10 - Погода в Омске\n" +
                "11 - Вывести все данные из БД\n" + "12 - Выход\n";

        System.out.println(menu);
        boolean isQuit = false;
        while (!isQuit) {
            byte functuion = scan.nextByte();

            switch (functuion) {

                case 1:
                    requestWeather(BELGOROD_KEY, BELGOROD_NAME);
                    break;

                case 2:
                    requestWeather(SAINT_PETERSBURG_KEY, SAINT_PETERSBURG_NAME);
                    break;

                case 3:
                    requestWeather(MOSСOW_KEY, MOSСOW_NAME);
                    break;

                case 4:
                    requestWeather(SARATOV_KEY, SARATOV_NAME);
                    break;

                case 5:
                    requestWeather(UFA_KEY, UFA_NAME);
                    break;

                case 6:
                    requestWeather(KAZAN_KEY, KAZAN_NAME);
                    break;

                case 7:
                    requestWeather(IRKUTSK_KEY, IRKUTSK_NAME);
                    break;

                case 8:
                    requestWeather(VORONEZH_KEY, VORONEZH_NAME);
                    break;

                case 9:
                    requestWeather(SAMARA_KEY, SAMARA_NAME);
                    break;

                case 10:
                    requestWeather(OMSK_KEY, OMSK_NAME);
                    break;

                case 11:
                    selectAll();
                    break;

                case 12:
                    isQuit = true;
                    break;
            }
            System.out.println(menu);
        }
    }

    public static void requestWeather(String cityKey, String cityName) throws IOException {
        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host(BASE_HOST)
                .addPathSegment(FORECAST)
                .addPathSegment(API_VERSION)
                .addPathSegment(FORECAST_TYPE)
                .addPathSegment(FORECAST_PERIOD)
                .addPathSegment(cityKey)
                .addQueryParameter("apikey", API_KEY)
                .addQueryParameter("language", "ru-ru")
                .addQueryParameter("metric", "true")
                .build();

        System.out.println(url.toString());

        Request requesthttp = new Request.Builder()
                .addHeader("accept", "application/json")
                .url(url)
                .build();

        String jsonResponse = client.newCall(requesthttp).execute().body().string();

        ObjectMapper objectMapper = new ObjectMapper();

        WeatherResponse weatherResponse = objectMapper.readValue(jsonResponse, WeatherResponse.class);

        DailyForecasts[] dailyForecasts = weatherResponse.getDailyForecasts();

        for (int i = 0; i < 5; i++) {
            Temperature temperature = dailyForecasts[i].getTemperature();
            saveBd(cityName, dailyForecasts[i].getDate(),String.valueOf(dailyForecasts[i].getDay().getIconPhrase() + " ," + dailyForecasts[i].getNight().getIconPhrase()), temperature.getMaximum().getValue());
            System.out.println("Погода в городе " + cityName + " на дату " + dailyForecasts[i].getDate() + " ожидается " +
                    dailyForecasts[i].getDay().getIconPhrase() + " ," + dailyForecasts[i].getNight().getIconPhrase() +
                    ", температура - " + temperature.getMaximum().getValue() + "C - " + temperature.getMinimum().getValue() + "C");
        }
    }
}

