import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        engine test = new engine();
        test.test_clock();
        test.test_clock_seconds();
        test.test_shop();
        test.test_GUI();
        test.test_GSON();
        test.test_write_obj();
        test.test_read_obj();

        //test.test_db_create();
        clock c1 = new clock("Samsung Gear S4", 50000);
        clock c2 = new clock("Samsung Gear S3", 25000);
        test.test_db_add(c1);
        test.test_db_add(c2);
        test.test_db_get();
        //test.database_create();
    }
}