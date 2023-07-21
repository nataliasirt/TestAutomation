package com.solvd.openweather;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import java.lang.invoke.MethodHandles;

public class APITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @Test
    //Test case 1: Verify user get valid weather data for London, GB in Fahrenheit in English
    public void testGetWeatherDataForLondonGB() {
        GetWeatherMethod getWeatherMethod = new GetWeatherMethod();
        getWeatherMethod.addParameter("q", "London");
        getWeatherMethod.addParameter("units", "imperial");
        getWeatherMethod.addParameter("appid", "18ea40b1276c29a5b18dff1d740509f4");
        getWeatherMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethod.callAPI();
        String rs = getWeatherMethod.callAPI().asString();
        getWeatherMethod.validateResponseAgainstSchema("_getweather/rs_weather.schema");
    }

    @Test
    //Test case 2: Verify user get valid weather data for Kyiv, UA in Fahrenheit in Ukranian
    public void testUserGetsValidWeatherDataForKyivInUkranian() {
        GetWeatherMethod getWeatherMethod = new GetWeatherMethod();
        getWeatherMethod.addParameter("q", "Kyiv");
        getWeatherMethod.addParameter("units", "imperial");
        getWeatherMethod.addParameter("lang", "ua");
        getWeatherMethod.addParameter("appid", "18ea40b1276c29a5b18dff1d740509f4");
        getWeatherMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethod.callAPI();
        getWeatherMethod.validateResponseAgainstSchema("_getweather/rs_weather.schema");
    }
    @Test
    //Test case 3: Verify user get valid weather data for Madrid, Spain in Fahrenheit in English
    public void testUserGetsValidWeatherDataForMadridInEnglish() {
        GetWeatherMethod getWeatherMethod = new GetWeatherMethod();
        getWeatherMethod.addParameter("q", "Madrid");
        getWeatherMethod.addParameter("units", "imperial");
        getWeatherMethod.addParameter("lang", "en");
        getWeatherMethod.addParameter("appid", "18ea40b1276c29a5b18dff1d740509f4");
        getWeatherMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethod.callAPI();
        getWeatherMethod.validateResponseAgainstSchema("_getweather/rs_weather.schema");
    }
    @Test
    //Test case 4: Verify that the user gets valid data by lat and lon example Kyiv, UA
    public void testUserGetsValidWeatherDataByLatAndLon() {
        GetWeatherMethodByLonLat getWeatherMethodByLonLat = new GetWeatherMethodByLonLat(30.5167, 50.4333);
        getWeatherMethodByLonLat.addParameter("appid", "18ea40b1276c29a5b18dff1d740509f4");
        getWeatherMethodByLonLat.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethodByLonLat.callAPI();
        String rs = getWeatherMethodByLonLat.callAPI().asString();
        getWeatherMethodByLonLat.validateResponseAgainstSchema("_getweather/rs_weather.schema");
    }
    @Test
    //Test case 5:Verify, that the user gets valid data by city id, example Kyiv, UA
    public void testUserGetsValidWeatherForKyivDataById() {
        GetWeatherById getWeatherById = new GetWeatherById(703448);
        getWeatherById.addParameter("appid", "18ea40b1276c29a5b18dff1d740509f4");
        getWeatherById.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherById.callAPI();
        String rs = getWeatherById.callAPI().asString();
        getWeatherById.validateResponseAgainstSchema("_getweather/rs_weather.schema");
    }
    @Test
    //Test case 6:Verify, that the user gets valid data by city id, example Madrid, ES
    public void testUserGetsValidWeatherForMadridDataById() {
        GetWeatherById getWeatherById = new GetWeatherById(6359304);
        getWeatherById.addParameter("appid", "18ea40b1276c29a5b18dff1d740509f4");
        getWeatherById.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherById.callAPI();
        String rs = getWeatherById.callAPI().asString();
        getWeatherById.validateResponseAgainstSchema("_getweather/rs_weather.schema");
    }
    @Test
    //Test case 7:Verify, that the user gets valid data by OneAPICall with free plan - requires a separate subscription to the One Call by Call plan
    public void testUserGetsValidWeatherByOneAPICall(){
        GetWeatherOneApiCall getWeatherOneApiCall = new GetWeatherOneApiCall(27.566668, 53.900002 );
        getWeatherOneApiCall.addParameter("appid", "18ea40b1276c29a5b18dff1d740509f4");
        getWeatherOneApiCall.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherOneApiCall.callAPI();
        getWeatherOneApiCall.validateResponseAgainstSchema("_getoneapicall/rs_oneapicall.schema");
    }
}



