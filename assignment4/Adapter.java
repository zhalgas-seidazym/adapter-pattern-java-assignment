package architecture.assignment4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

// Common data model for weather information
class WeatherData {
    private String location;
    private double temperature;
    private double humidity;
    private double windSpeed;

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
}

// Interface for Weather API Adapter
interface WeatherApiAdapter {
    WeatherData fetchWeatherData(String location);
}

// Adaptee 1: Example of a weather API with a different data format
class WeatherApi1 {
    public WeatherData getData(String location) {
        // Simulate fetching data from API 1
        double temperature = 25.0;
        double humidity = 60.0;
        double windSpeed = 10.0;
        return new WeatherData(location, temperature, humidity, windSpeed);
    }
}

// Adaptee 2: Example of another weather API with a different data format
class WeatherApi2 {
    public WeatherData getWeather(String location) {
        // Simulate fetching data from API 2
        double temperature = 30.0;
        double humidity = 55.0;
        double windSpeed = 12.0;
        return new WeatherData(location, temperature, humidity, windSpeed);
    }
}

// Adapter for WeatherApi1
class WeatherApi1Adapter implements WeatherApiAdapter {
    private WeatherApi1 weatherApi1;

    public WeatherApi1Adapter(WeatherApi1 weatherApi1) {
        this.weatherApi1 = weatherApi1;
    }

    @Override
    public WeatherData fetchWeatherData(String location) {
        return weatherApi1.getData(location);
    }
}

// Adapter for WeatherApi2
class WeatherApi2Adapter implements WeatherApiAdapter {
    private WeatherApi2 weatherApi2;

    public WeatherApi2Adapter(WeatherApi2 weatherApi2) {
        this.weatherApi2 = weatherApi2;
    }

    @Override
    public WeatherData fetchWeatherData(String location) {
        return weatherApi2.getWeather(location);
    }
}

class WeatherApp {
    public static void main(String[] args) throws IOException {
        WeatherApiAdapter api1Adapter = new WeatherApi1Adapter(new WeatherApi1());
        WeatherApiAdapter api2Adapter = new WeatherApi2Adapter(new WeatherApi2());

        // Fetch and display weather data using the adapters
        WeatherData data1 = api1Adapter.fetchWeatherData("City1");
        WeatherData data2 = api2Adapter.fetchWeatherData("City1");

        System.out.println("Weather in " + data1.getLocation() + ":");
        System.out.println("Temperature: " + data1.getTemperature());
        System.out.println("Humidity: " + data1.getHumidity());
        System.out.println("Wind Speed: " + data1.getWindSpeed());

        System.out.println("\nWeather in " + data2.getLocation() + ":");
        System.out.println("Temperature: " + data2.getTemperature());
        System.out.println("Humidity: " + data2.getHumidity());
        System.out.println("Wind Speed: " + data2.getWindSpeed());
        FileReader fileReader = new FileReader("src/architecture/assignment4/a");
        System.out.println("" + (char)fileReader.read() + "bb");
    }
}
