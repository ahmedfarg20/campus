package campus.system;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static campus.system.LoginInterface.Rs;
import static campus.system.LoginInterface.sql;
import static campus.system.LoginInterface.stmt;

public class Login {

    private int id;
    private String password;
    User user;
    public int result = 0;

    Login(int id, String password) {
        this.id = id;
        this.password = password;
        try {
            searchAdmin(id);
            if (result == 1) {
                if (password.equals((Rs.getString("password")))) {
                    this.user = new Admin();
                    this.result = 2;
                }
            } else {
                searchProfessor(id);
                if (result == 1) {
                    if (password.equals((Rs.getString("password")))) {
                        this.user = new professor(this.id);
                        this.result = 3;
                    }
                } else {
                    searchStudent(id);
                    if (result == 1) {
                        if (password.equals((Rs.getString("password")))) {
                            this.user = new Student(this.id);
                            this.result = 4;
                        }
                    }
                }
            }

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public User getUser() {

        return this.user;

    }

    private void searchAdmin(int AdminId) throws SQLException {
        result = 0;
        String sqlAdmin = sql + "admin";
        Rs = stmt.executeQuery(sqlAdmin);
        Rs.absolute(0);
        while (Rs.next()) {
            int iddd = Rs.getInt("id");
            if (AdminId == iddd) {
                this.result = 1;
                break;
            }

        }
    }

    private void searchStudent(int StudentId) throws SQLException {
        result = 0;
        String sqlStudent = sql + "student";
        Rs = stmt.executeQuery(sqlStudent);
        Rs.absolute(0);
        while (Rs.next()) {

            if (StudentId == (Rs.getInt("id"))) {
                result = 1;
                break;
            }

        }
    }

    private void searchProfessor(int ProfessorId) throws SQLException {
        result = 0;
        String sqlProfessor = sql + "professor";
        Rs = stmt.executeQuery(sqlProfessor);
        Rs.absolute(0);
        while (Rs.next()) {

            if (ProfessorId == (Rs.getInt("id"))) {
                result = 1;
                break;
            }

        }
    }

    public int checklogin() {
        return this.result;
    }
}
