package Lesson7.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuweatherModel implements WeatherModel  {
    //    http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
    private static final String PROTOCOL = "http";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String API_KEY = "voNwnz2b9Mm7kkIN8jQsMQyvGqVIribT";
    private static final String API_KEY_QUERY_PARAM = "apikey";
    private static final String LOCATIONS = "locations";
    private static final String CITIES = "cities";
    private static final String AUTOCOMPLETE = "autocomplete";

    private static final OkHttpClient okHttpClient = new OkHttpClient();
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public  void getWeather(String selectedCity, Period period) throws IOException {
        switch (period) {
            case NOW:
                HttpUrl httpUrl = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addEncodedPathSegment(FORECAST)
                        .addEncodedPathSegment(VERSION)
                        .addEncodedPathSegment(DAILY)
                        .addEncodedPathSegment(ONE_DAY)
                        .addEncodedPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request = new Request.Builder()
                        .url(httpUrl)
                        .build();
                Response oneDayForecastResponse = okHttpClient.newCall(request).execute();
                String weatherResponse = oneDayForecastResponse.body().string();
                System.out.println(weatherResponse);
//                TODO: сделать читаемый вид погоды
                break;
            case FIVE_DAYS:
                break;
        }
    }

    private  String detectCityKey(String selectCity) throws IOException {
//        http://dataservice.accuweather.com/locations/v1/cities/autocomplete
        HttpUrl httpUrl = new HttpUrl.Builder()
                .scheme(PROTOCOL)
                .host(BASE_HOST)
                .addPathSegment(LOCATIONS)
                .addPathSegment(VERSION)
                .addPathSegment(CITIES)
                .addPathSegment(AUTOCOMPLETE)
                .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                .addQueryParameter("q", selectCity)
                .build();
        Request request = new Request.Builder()
                .url(httpUrl)
                .get()
                .addHeader("accept", "application/json")
                .build();

        Response response = okHttpClient.newCall(request).execute();
        String responseString = response.body().string();


        String cityKey = objectMapper.readTree(responseString).get(0).at("/Key").asText();
        return cityKey;

    }


}
