package campus.system;

import static campus.system.LoginInterface.Rs;
import static campus.system.LoginInterface.sql;
import static campus.system.LoginInterface.stmt;
import java.sql.SQLException;

public class User extends course {

    public void setPoineterStudent() throws SQLException {
        String sqlStudent = sql + "student";
        Rs = stmt.executeQuery(sqlStudent);
    }

    public void setPoineterCourses() throws SQLException {
        String sqlStudent = sql + "COURSES";
        Rs = stmt.executeQuery(sqlStudent);
    }

    public void setPoineterStudentMark() throws SQLException {
        String sqlStudent = sql + "MARK";
        Rs = stmt.executeQuery(sqlStudent);
    }

    public void setPoineterProfessors() throws SQLException {
        String sqlStudent = sql + "PROFESSOR";
        Rs = stmt.executeQuery(sqlStudent);
    }

}
