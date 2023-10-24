package adapter_pattern;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

// Adaptee 1: Example of a weather API with a different data format
class WeatherApiJson {
    public File getData() {
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/adapter_pattern/JsonFile.json"));
            objectOutputStream.writeObject(new WeatherData("Almaty", 5, 10, 10));
            objectOutputStream.close();
            return new File("src/adapter_pattern/JsonFile.json");
        }catch (IOException e){
            System.out.println("!Correct file path!");
            System.exit(0);
        }
        return new File("");
    }
}

// Adaptee 2: Example of another weather API with a different data format
class WeatherApiTxt {
    public File getData() {
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/adapter_pattern/TxtFile.txt"));
            objectOutputStream.writeObject(new WeatherData("Almaty", 8, 8, 8));
            objectOutputStream.close();
            return new File("src/adapter_pattern/TxtFile.txt");
        }catch (IOException e){
            System.out.println("!Correct file path!");
            System.exit(0);
        }
        return new File("");
    }
}