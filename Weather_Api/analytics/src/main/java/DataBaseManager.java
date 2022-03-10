import java.sql.*;

public class DataBaseManager {

    public void insert(String url, Weather weather) {
        String sql = "INSERT INTO weather(ts,lat,lon,temp,pressure,humidity) VALUES(?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(url);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, weather.getTs());
            pstmt.setDouble(2, weather.getLat());
            pstmt.setDouble(3, weather.getLon());
            pstmt.setDouble(4, weather.getTemp());
            pstmt.setDouble(5, weather.getPressure());
            pstmt.setDouble(6, weather.getHumidity());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ResultSet select(String url) {
        String sqlSelectAll = "SELECT ts,lat,lon,temp,pressure,humidity FROM weather";

        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sqlSelectAll);
            return resultSet;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}