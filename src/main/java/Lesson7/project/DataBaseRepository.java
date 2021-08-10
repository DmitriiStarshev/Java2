package Lesson7.project;

import Lesson7.project.entity.Weather;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.PrimitiveIterator;

public class DataBaseRepository {
    String insertWeather = "insert into weather (city,localdate,temperature) values (?,?,?)";
    private static final String DB_PATH = "jdbc:sqlite:geekbrains.db";
    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void saveWeatherToDataBase (List<Weather> weatherList) throws SQLException {
        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
            PreparedStatement saveWeather = connection.prepareStatement(insertWeather);
            for (Weather weather : weatherList) {
                saveWeather.setString(1, weather.getCity());
                saveWeather.setString(2, weather.getLocalDate());
                saveWeather.setDouble(3, weather.getTemperature());
                saveWeather.addBatch();
            }
            saveWeather.executeBatch();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new SQLException("Cохранение погоды в базу данных не произошло");
    }

//    public List<Weather> getSaveToDBWeather(){
//        try (Connection connection = DriverManager.getConnection(DB_PATH)) {
////TODO: реализовать метод получения данных из таблицы погоды
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//    }

    public static void main(String[] args) throws SQLException {
        DataBaseRepository dataBaseRepository = new DataBaseRepository();
        dataBaseRepository.saveWeatherToDataBase(new Weather("Moscow","12.12.12",30.0));
    }
}

