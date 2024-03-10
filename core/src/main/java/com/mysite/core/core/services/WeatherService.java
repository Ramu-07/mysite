package com.mysite.core.core.services;
 
import org.osgi.service.component.annotations.Component;
 
@Component(service = WeatherService.class, immediate = true)
public class WeatherService {
    public String getWeatherData() {
        // Use dummy data for the weather information
        return "{ \"temperature\": 25, \"humidity\": 60, \"windSpeed\": 10 }";
    }
}