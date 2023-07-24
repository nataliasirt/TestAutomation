package com.solvd.openweather.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;

@Endpoint(url = "${base_url}/data/2.5/weather?/", methodType = HttpMethodType.GET)
@ResponseTemplatePath(path = "resources/_getweather/rs_weather.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetWeatherMethodByLonLat extends AbstractApiMethodV2 {
    public GetWeatherMethodByLonLat(double lonArg, double latArg) {
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        addParameterIfNotNull("lon", String.valueOf(lonArg));
        addParameterIfNotNull("lat", String.valueOf(latArg));

    }
}

