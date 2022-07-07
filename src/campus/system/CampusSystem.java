package campus.system;

import static campus.system.LoginInterface.ConnectDataBase;
import java.sql.*;
import java.util.Scanner;
import java.sql.SQLException;

public class CampusSystem {

    public static void main(String[] args) throws Exception {
        try {
            ConnectDataBase();
            Scanner input = new Scanner(System.in);
            LoginInterface Login = new LoginInterface();
            //Login.show();
            Login.setLocation(400, 100);
            Login.setVisible(true);
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }

    }
}
