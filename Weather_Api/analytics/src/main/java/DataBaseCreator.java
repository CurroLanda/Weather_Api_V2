import java.sql.*;

public  class DataBaseCreator {
    public String url;

    public DataBaseCreator(String url) {
        this.url = url;
    }

    public void createNewDatabase() {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:"+url+"/weather.db")) {
            if (conn != null) {
                conn.getMetaData();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void createNewTable() {
        String sql = "CREATE TABLE IF NOT EXISTS weather (\n"
                + "	ts long,\n"
                + "	lat double,\n"
                + "	lon double,\n"
                + "	temp double,\n"
                + "	humidity double,\n"
                + "	pressure double\n"
                + ");";
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:"+url+"/weather.db");
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}