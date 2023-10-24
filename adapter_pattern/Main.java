package adapter_pattern;

public class Main {
    public static void main(String[] args) {
        WeatherApiAdapter jsonAdapter = new JsonApiAdapter(new WeatherApiJson());
        WeatherApiAdapter txtAdapter = new TxtApiAdapter(new WeatherApiTxt());

        // Fetch and display weather data using the adapters
        WeatherData jsonData = jsonAdapter.fetchWeatherData();
        WeatherData txtData = txtAdapter.fetchWeatherData();

        System.out.println("Json" + jsonData);

        System.out.println("\nTxt" + txtData);
    }
}
