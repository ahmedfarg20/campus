package campus.system;

import static campus.system.LoginInterface.Rs;
import static campus.system.LoginInterface.con;
import static campus.system.LoginInterface.sql;
import static campus.system.LoginInterface.stmt;
import java.sql.SQLException;

public class course {

    private int Foundcourse = 0;

    public void searchCourse(int courseid) throws SQLException {
        Foundcourse = 0;
        String sqlcourses = sql + "courses";
        Rs = stmt.executeQuery(sqlcourses);
        Rs.absolute(0);
        while (Rs.next()) {
            if (courseid == (Rs.getInt("id"))) {
                Foundcourse = 1;
                break;
            }

        }

    }

    public int checkcourse(int courseid) throws SQLException {
        searchCourse(courseid);
        return Foundcourse;
    }

}
