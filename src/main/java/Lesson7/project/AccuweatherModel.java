package Lesson7.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class AccuweatherModel implements WeatherModel  {
    //    http://dataservice.accuweather.com/forecasts/v1/daily/1day/349727
//    http://dataservice.accuweather.com/forecasts/v1/daily/5day/349727
    private static final String PROTOCOL = "http";
    private static final String BASE_HOST = "dataservice.accuweather.com";
    private static final String FORECAST = "forecasts";
    private static final String VERSION = "v1";
    private static final String DAILY = "daily";
    private static final String ONE_DAY = "1day";
    private static final String FIVE_DAY= "5day";
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
//                System.out.println(weatherResponse);
//                TODO: сделать читаемый вид погоды
                int minimalTemperatureInFahrenheit = objectMapper.readTree(weatherResponse)
                        .at("/DailyForecasts")
                        .get(0)
                        .at("/Temperature/Minimum/Value")
                        .asInt();

                System.out.println("Миниальная температура: " + minimalTemperatureInFahrenheit +" " +
                        "градусов по фаренгейту");
                break;
            case FIVE_DAYS:
                HttpUrl httpUrl5day = new HttpUrl.Builder()
                        .scheme(PROTOCOL)
                        .host(BASE_HOST)
                        .addEncodedPathSegment(FORECAST)
                        .addEncodedPathSegment(VERSION)
                        .addEncodedPathSegment(DAILY)
                        .addEncodedPathSegment(FIVE_DAY)
                        .addEncodedPathSegment(detectCityKey(selectedCity))
                        .addQueryParameter(API_KEY_QUERY_PARAM, API_KEY)
                        .build();

                Request request5day = new Request.Builder()
                        .url(httpUrl5day)
                        .build();
                Response fiveDayForecastResponse = okHttpClient.newCall(request5day).execute();
                String weatherResponse5day = fiveDayForecastResponse.body().string();
//                System.out.println(weatherResponse5day);
                int maximumTemperatureInFahrenheit = objectMapper.readTree(weatherResponse5day)
                        .at("/DailyForecasts")
                        .get(0)
//                        .get(1) При добавлении других дней из массива Json выдает Exeption
//                        .get(2)
//                        .get(3)
//                        .get(4)
                        .at("/Temperature/Maximum/Value")
                        .asInt();



                System.out.println("Максимальная температура: " + maximumTemperatureInFahrenheit +" " +
                        "градусов по фаренгейту");
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
