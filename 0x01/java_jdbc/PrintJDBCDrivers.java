import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
import java.util.Iterator;

public class PrintJDBCDrivers   {
    public static void main(String[] args) {
        Enumeration<Driver> drivers = DriverManager.getDrivers();

        for (Iterator<Driver> it = drivers.asIterator(); it.hasNext();) {
            Driver driver = it.next();

            Class itClass = driver.getClass();
            int majorVersion = driver.getMajorVersion();
            int minorVersion = driver.getMinorVersion();

            System.out.printf("%s %d - %d\n", itClass, majorVersion, minorVersion);
        }
    }
}
