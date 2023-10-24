package adapter_pattern;

import java.io.*;


// Common data model for weather information
class WeatherData implements Serializable {
    private String location;
    private double temperature;
    private double humidity;
    private double windSpeed;

    public WeatherData() {
    }

    public WeatherData(String location, double temperature, double humidity, double windSpeed) {
        this.location = location;
        this.temperature = temperature;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    public String getLocation() {
        return location;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "location='" + location + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", windSpeed=" + windSpeed +
                '}';
    }
}
