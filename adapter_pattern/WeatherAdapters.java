package adapter_pattern;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

// Interface for Weather API Adapter
interface WeatherApiAdapter {
    WeatherData fetchWeatherData();
}

// Adapter for WeatherApiTxt
class TxtApiAdapter implements WeatherApiAdapter {
    private WeatherApiTxt weatherApiTxt;

    public TxtApiAdapter(WeatherApiTxt weatherApiTxt) {
        this.weatherApiTxt = weatherApiTxt;
    }

    @Override
    public WeatherData fetchWeatherData() {
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(weatherApiTxt.getData()));
            return (WeatherData) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("!Correct entered data!");
        }
        return new WeatherData();
    }
}

// Adapter for WeatherApi2
class JsonApiAdapter implements WeatherApiAdapter {
    private WeatherApiJson weatherApiJson;

    public JsonApiAdapter(WeatherApiJson weatherApiJson) {
        this.weatherApiJson = weatherApiJson;
    }

    @Override
    public WeatherData fetchWeatherData() {
        try{
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(weatherApiJson.getData()));
            return (WeatherData) objectInputStream.readObject();
        }catch (IOException | ClassNotFoundException e){
            System.out.println("!Correct entered data!");
        }
        return new WeatherData();
    }
}