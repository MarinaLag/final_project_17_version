package model.db;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Objects;
import java.util.Properties;

@UtilityClass
public class ConnectionManager {
    public static final String DRIVER = "driver";
    public static final String URL = "url";
    public static final String DB_FILE_PROPS = "db.properties";

    private static Connection cn;
    private static Properties props;

    public static void init() {
        loadProps();
        loadDriver();
    }

    public static void loadProps() {
        props = PropertiesManager.getProperties(DB_FILE_PROPS);
    }

    public static void loadDriver() {
        try {
            Class.forName(props.getProperty(DRIVER));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //получаем коннекшион с БД
    public static Connection getConnection() throws SQLException {
        return Objects.isNull(cn) || cn.isClosed()
                ? DriverManager.getConnection(props.getProperty(URL), props)
                : cn;
    }

}
