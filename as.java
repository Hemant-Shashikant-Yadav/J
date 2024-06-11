import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class as {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            System.out.println("hoo");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "123");
            System.out.println("database connected");
            Statement stmt = con.createStatement();
            stmt.executeUpdate(
                    "Create table student(roll_no number(4),name varchar2(50),class varchar2(5),score number(5) ,gender varchar(2) )");

            System.out.println("Table created");
            stmt.executeUpdate("insert into student values(1,'ABC','FY',100,'M')");
            stmt.executeUpdate("insert into student values(2,'PKZ','SY',86,'M')");
            stmt.executeUpdate("insert into student values(3,'WDC','FY',86,'F')");
            stmt.executeUpdate("insert into student values(4,'VFF','SY',50,'F')");
            stmt.executeUpdate("insert into student values(5,'XFV','FY',84,'M')");
            stmt.executeUpdate("insert into student values(6,'BFC','TY',84,'F')");
            stmt.executeUpdate("insert into student values(7,'YTD','TY',100,'F')");
            stmt.executeUpdate("insert into student values(8,'RFD','RT',84,'F')");
            stmt.executeUpdate("insert into student values(9,'ETY','FY',100,'M')");

            System.out.println("Values inserted.");

            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}