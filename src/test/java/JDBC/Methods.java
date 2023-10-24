package JDBC;
import com.mysql.cj.protocol.Resultset;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.*;

public class Methods {
    Connection connection;
    Statement statement;

    @BeforeTest
    public void before() throws SQLException {
        String URL = "jdbc:mysql://test.medis.mersys.io:33306/company";
        String username = "technostudy";
        String password = "zhTPis0l9#$&";
        connection = DriverManager.getConnection(URL, username, password);
        statement = connection.createStatement(); //sorguları çalıştırabilmek

    }

    @AfterTest
    public void closeConnection() throws SQLException {

        connection.close();
    }

    @BeforeMethod
    public void afterMethod() {
        System.out.println(" --------------------------**************************************-------------------------------------");
    }


    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from employees");

        rs.next();
        String name = rs.getString("first_name");
        System.out.println(name);

        rs.next();
        name = rs.getString("first_name");
        System.out.println(name);


        rs.next();
        name = rs.getString("first_name");
        System.out.println(name);

    }

    @Test
    public void geneYazdirma1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from employees");

        rs.next();

        while (rs.next()){

            String first_name=rs.getString("first_name");
            System.out.println(first_name);
        }
    }

    @Test
    public void absolute() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from employees");
        rs.absolute(1);

        String name= rs.getString(2);
        System.out.println(name);

        rs.absolute(10);
        name= rs.getString(2);
        System.out.println(name);

        rs.next();
        name= rs.getString(2);
        System.out.println(name);


    }
    @Test
    public void relative() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from employees");
        rs.absolute(2 );

        String name= rs.getString(3);
        System.out.println(name);


        rs.relative(2);

        name= rs.getString(3);
        System.out.println(name);

        rs.relative(2);

        name= rs.getString(3);
        System.out.println(name);

    }
    @Test
    public void first_last_previous() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from employees");

        rs.first();
        String name = rs.getString(4);
        System.out.println(name);

        rs.next();
        name = rs.getString(4);
        System.out.println(name);


        rs.relative(10);
        name = rs.getString(4);
        System.out.println(name);


        rs.previous();
        name = rs.getString(4);
        System.out.println(name);

    }

    @Test
    public void isimSoyisimYazdirma() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from employees");

        while (rs.next()){

            String first_name =rs.getString("first_name");
            String last_name =rs.getString("last_name");

            System.out.println(first_name + "  " + last_name);
        }
    }

    @Test
    public void genelYazdirma() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from employees");

        ResultSetMetaData metaData = rs.getMetaData();

        int colonSayisi = metaData.getColumnCount();

        System.out.println(colonSayisi);

        while (rs.next()){

            for (int i = 1; i <=colonSayisi-3 ; i++) {
                System.out.print(rs.getString(i)+ "  |  ");


            }
            System.out.println();
        }


    }

}
