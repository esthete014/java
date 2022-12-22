import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;

import java.io.*;
import java.sql.*;
import java.util.List;

public class engine {
/*
Необходимо реализовать систему классов описания магазина часов.

Количество часов в магазине не ограничено.

Предполагается, что каждые часы содержат информацию о стоимости и названии марки часов.

При реализации необходимо описать два типа часов.

В первом типе часов две стрелки – часовая и минутная, а во втором типе часов добавляется секундная стрелка.

Классы часы должен позволять получать стоимость, название марки часов, устанавливать начальное время,
а также переводить время вперед.

При переводе времени необходимо контролировать корректность введенных данных.

При некорректном задании времени должна возникать исключительная ситуация.
*/
    void test_clock(){
        System.out.println("================CLOCK================");
        System.out.println(java.time.LocalDateTime.now().getHour());
        clock_interface my_clock = new clock();
        my_clock.PrintDisplay();
        System.out.println("--------------------------------------");
        clock second_clock = new clock("", 1300);
        second_clock.PrintDisplay();
        System.out.println("--------------------------------------");
        clock three_clock = new clock("Other clocks", 11111, 11, 32);
        three_clock.PrintDisplay();
        System.out.println("--------------------------------------");
        three_clock.plusTime(clock_interface.types_arrow.M, 10);
        three_clock.PrintDisplay();
        System.out.println(three_clock);
        System.out.println("--------------------------------------");
        try {
            three_clock.plusTime(clock_interface.types_arrow.H, -32);
            System.out.println(three_clock);
        } catch (NullPointerException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println("--------------------------------------");
    }
    void test_clock_seconds(){
        System.out.println("|=========CLOCK with SECONDS==========|");
        clock_interface my_clocks = new clock_seconds();
        System.out.println(my_clocks);
        my_clocks.plusTime(clock_interface.types_arrow.H, 12);
        System.out.println(my_clocks);
        System.out.println("--------------------------------------");
        clock_seconds clocks2 = new clock_seconds("New clock", 2500);
        clocks2.plusTime(clock_interface.types_arrow.M, 144);
        System.out.println(clocks2);
        System.out.println("--------------------------------------");
        clock_seconds clocks3 = new clock_seconds("Samsung new", 21999, 2,32, 14);
        System.out.println(clocks3);
        System.out.println("--------------------------------------");
        clocks3.set_time(clock_interface.types_arrow.H, 5);
        System.out.println(clocks3);
    }

/*
Магазин должен позволять:

Получать описания самых дорогих часов.
Устанавливать заданное время на всех часах.
Получать название наиболее часто встречающейся марки часов в магазине.
Выводить марки часов без повторения в упорядоченном виде.
*/
    void test_shop(){
        System.out.println("|================SHOP================|");
        shop my_shop = new shop();
        System.out.println(my_shop);
        System.out.println("Max price: " + my_shop.getMaxPrice());
        System.out.println("Max count name: " + my_shop.getMaxCountName());
        System.out.println("|------------SortList----------------|");
        my_shop.printAllMarksOneCount();
    }

    public void test_GUI() {
        GUI gui = new GUI();
        gui.setVisible(true);
        shop s = new shop();
        gui.fillList(s);
    }

    public void test_GSON() {
        GSON g = new GSON();
        shop s = new shop();
        String objJSON = g.writeJson(s.list, true);
        g.readJson(objJSON, true);
    }

    public void test_write_obj() {
        write w = new write();
        shop s = new shop();
        w.write_object(s.list, true);
    }

    public void test_read_obj() {
        read w = new read();
        w.read_object(true);
    }



    public void test_db_add(clock cl) {
        String DB_URL = "jdbc:sqlite:sqlite.db";
        String USERNAME = "root";
        String PASSWORD = "root";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            String sql = "INSERT INTO clock (name, hours, minutes, price) " +
                    "VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, cl.name);
            preparedStatement.setInt(2, cl.arrowHours);
            preparedStatement.setInt(3, cl.arrowMinutes);
            preparedStatement.setInt(4, cl.price);

            int addedRows = preparedStatement.executeUpdate();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void test_db_get() {
        String DB_URL = "jdbc:sqlite:sqlite.db";
        String USERNAME = "root";
        String PASSWORD = "root";
        try {
            Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from clock;");
            while (rs.next()) {
                System.out.println("==================================");
                System.out.println("name = " + rs.getString("name"));
                System.out.println("hours = " + rs.getString("hours"));
                System.out.println("minutes = " + rs.getString("minutes"));
                System.out.println("price = " + rs.getString("price"));
                System.out.println("==================================");
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void test_db_create() {
        String DB_URL = "jdbc:sqlite:sqlite.db";
        String USERNAME = "root";
        String PASSWORD = "root";
        try(Connection conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
        ) {
            String sql = "CREATE TABLE clock " +
                    " (name VARCHAR(255), " +
                    " hours INTEGER, " +
                    " minutes INTEGER, " +
                    " price INTEGER)";

            stmt.executeUpdate(sql);
            System.out.println("Created table in given database...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
/*
    static public void utiliseHibernate(clock watches) {
        System.out.println("example.maven.mainClass.main()");
        Session session = hibernate_session.getSessionFactory().openSession();
        session.clear();
        Transaction tx1 = session.beginTransaction();
        clock_to_hibernate p = new clock_to_hibernate();
        String temp = Integer.toString(watches.getHours()) + Integer.toString(watches.getMinutes()) + Integer.toString(watches.getHours());
        p.setTime(temp);
        p.setBrand(watches.getName());
        p.setPrice(watches.getPrice());
        session.save(p);
        tx1.commit();
        session.close();

        List<clock_to_hibernate> watchess = (List<clock_to_hibernate>)hibernate_session.
                getSessionFactory().openSession().createQuery("From hibWatches").list();
        for (clock_to_hibernate watch : watchess) {
            System.out.println(watch.getBrand() +" " + watch.getTime()+" " + watch.getPrice());
        }
    }
    static public void saveElems(shop _shop, String _fileName) {
        try{
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(_fileName));
            String tempStr = "";
            for(int i = 0; i < _shop.size(); i++) {
                tempStr += _store.getListElem(i).toString();
            }
            oos.writeObject(tempStr);
        } catch (FileNotFoundException ex) {
            System.out.println("ошибка записи тип 1");
        } catch(IOException ex) {
            System.out.println("ошибка записи тип 2");
        }
    }
    static public void loadElems(String _fileName) {
        try{
            String rm;
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream(_fileName));
            rm = (String)oos.readObject();
            System.out.println(rm);
        } catch (IOException ex) {
            System.out.println("ошибка чтения тип 1");
        } catch(ClassNotFoundException ex) {
            System.out.println("ошибка чтения тип 2");
        }
    }

    public static void main(String[] args) {
        shop Store = new shop();
//        Watches watches = new Watches(0,0,20, "test");
//        Watches watches1 = new Watches(0,0,60, "test2");
//        Watches watches2 = new Watches(0,0,20000, "test2");
//        Watches watches3 = new Watches(0,0,10000, "test2");
//        Store.addElem(watches);
//        Store.addElem(watches1);
//        Store.addElem(watches2);
//        Store.addElem(watches3);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String obj = gson.toJson(Store);
        System.out.println(obj);
        shop Store2;
        Store2 = gson.fromJson(obj, shop.class);
        System.out.println(Store2);
        GUI gui = new GUI();
        gui.setVisible(true);
        for(int i = 0; i < Store.size(); i++){
            gui.addToList(Store.getListElem(i));
        }

        saveElems(Store, "test.txt");
        loadElems("test.txt");
    }*/
}
