package campus.system;

import static campus.system.LoginInterface.Rs;
import static campus.system.LoginInterface.con;
import static campus.system.LoginInterface.sql;
import static campus.system.LoginInterface.stmt;
import java.sql.SQLException;

public class Student extends User {

    private int id;

    Student(int ID) {
        id = ID;
    }

    private void searchStudent() throws SQLException {
        String sqlStudent = sql + "student";
        Rs = stmt.executeQuery(sqlStudent);
        while (Rs.next()) {
            if (id == (Rs.getInt("id"))) {

                break;
            }
        }
    }

    public String VeiwStudentName() throws SQLException {
        searchStudent();
        return Rs.getString("NAME");
    }

    public String VeiwCOURSEID1Name() throws SQLException {
        searchStudent();
        int COURSE1id = Rs.getInt("COURSE1ID");
        searchCourse(COURSE1id);
        return Rs.getString("NAME");

    }

    public String VeiwCOURSEID1Booklet() throws SQLException {
        searchStudent();
        int COURSE1id = Rs.getInt("COURSE1ID");
        searchCourse(COURSE1id);
        return Rs.getString("BOOKLET");
    }

    public String VeiwCOURSEID1VIDEO() throws SQLException {
        searchStudent();
        int COURSE1id = Rs.getInt("COURSE1ID");
        searchCourse(COURSE1id);
        return Rs.getString("VIDEO");
    }

    public String VeiwCOURSEID1BookletSOLUTION() throws SQLException {
        searchStudent();
        int COURSE1id = Rs.getInt("COURSE1ID");
        searchCourse(COURSE1id);
        return Rs.getString("TESTSOLUTION");
    }

    public String VeiwCOURSEID1DATE() throws SQLException {
        searchStudent();
        int COURSE1id = Rs.getInt("COURSE1ID");
        searchCourse(COURSE1id);
        return Rs.getString("DATE");
    }

    public String VeiwCOURSEID1TIME() throws SQLException {
        searchStudent();
        int COURSE1id = Rs.getInt("COURSE1ID");
        searchCourse(COURSE1id);
        return Rs.getString("TIME");
    }

    public double ViewCOURSEID1Mark() throws SQLException {
        searchStudent();
        int COURSE1id = Rs.getInt("COURSE1ID");
        GetCoulmn(COURSE1id);
        return Rs.getDouble("MARK");
    }

    public String VeiwCOURSEID2Name() throws SQLException {
        searchStudent();
        int COURSE2id = Rs.getInt("COURSE2ID");
        searchCourse(COURSE2id);
        return Rs.getString("NAME");

    }

    public String VeiwCOURSEID2Booklet() throws SQLException {
        searchStudent();
        int COURSE2id = Rs.getInt("COURSE2ID");
        searchCourse(COURSE2id);
        return Rs.getString("BOOKLET");
    }

    public String VeiwCOURSEID2VIDEO() throws SQLException {
        searchStudent();
        int COURSE2id = Rs.getInt("COURSE2ID");
        searchCourse(COURSE2id);
        return Rs.getString("VIDEO");
    }

    public String VeiwCOURSEID2BookletSOLUTION() throws SQLException {
        searchStudent();
        int COURSE2id = Rs.getInt("COURSE2ID");
        searchCourse(COURSE2id);
        return Rs.getString("TESTSOLUTION");
    }

    public String VeiwCOURSEID2DATE() throws SQLException {
        searchStudent();
        int COURSE2id = Rs.getInt("COURSE2ID");
        searchCourse(COURSE2id);
        return Rs.getString("DATE");
    }

    public String VeiwCOURSEID2TIME() throws SQLException {
        searchStudent();
        int COURSE2id = Rs.getInt("COURSE2ID");
        searchCourse(COURSE2id);
        return Rs.getString("TIME");
    }

    public double ViewCOURSEID2Mark() throws SQLException {
        searchStudent();
        int COURSE2id = Rs.getInt("COURSE2ID");
        GetCoulmn(COURSE2id);
        return Rs.getDouble("MARK");
    }

    private void GetCoulmn(int courseId) throws SQLException {
        String sqlMarks = sql + "mark";
        Rs = stmt.executeQuery(sqlMarks);
        Rs.absolute(0);
        while (Rs.next()) {
            if (id == (Rs.getInt("id"))) {
                if (courseId == (Rs.getInt("COURSEID"))) {
                    break;

                }
            }
        }

    }

}
