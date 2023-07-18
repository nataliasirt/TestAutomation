package com.solvd.openweather;
import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.core.IAbstractTest;
import io.restassured.path.json.JsonPath;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.lang.invoke.MethodHandles;

public class APITest implements IAbstractTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    //Test case 1: Verify user get valid weather data for London, GB in celcium in english
    //{
        //    "id": 2643743,
        //    "name": "London",
        //    "state": "",
        //    "country": "GB",
        //    "coord": {
        //        "lon": -0.12574,
        //        "lat": 51.50853
        //    }
        //}
        // "timezone": 3600,
    @Test
    public void testUserGetsValidWeatherDataForLondonBritainInCelsiumInEnglish() {
        GetWeatherMethod getWeatherMethod = new GetWeatherMethod();
        getWeatherMethod.addParameter("q", "London");
        getWeatherMethod.addParameter("units", "metric");
        getWeatherMethod.addParameter("lang", "eng");
        getWeatherMethod.addParameter("appid", "cefb78b4ff8ef92994c1f20445ba028d");
        getWeatherMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
        getWeatherMethod.callAPI();

        String rs = getWeatherMethod.callAPI().asString();
        Assert.assertEquals(new JsonPath(rs).getString("sys.country"), "GB", "Country name is incorrect!");
        Assert.assertEquals(new JsonPath(rs).getString("name"), "London", "City name is incorrect!");
        Assert.assertEquals(new JsonPath(rs).getInt("id"), 2643743, "Id is incorrect!");
        Assert.assertEquals(new JsonPath(rs).getInt("timezone"), 3600, "Time zone is incorrect!");
        Assert.assertTrue(new JsonPath(rs).getDouble("main.temp_max") < 33, "Maximal temperature is incorrect!");
        Assert.assertTrue(new JsonPath(rs).getDouble("coord.lon") > -0.5, "Longitude is incorrect!");
        Assert.assertTrue(new JsonPath(rs).getDouble("coord.lat") < 51.6, "Latitude is incorrect!");
        getWeatherMethod.validateResponseAgainstSchema("_getweather/rs_weather.schema");
    }

    }

