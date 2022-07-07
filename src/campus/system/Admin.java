package campus.system;

import static campus.system.LoginInterface.Rs;
import static campus.system.LoginInterface.con;
import static campus.system.LoginInterface.sql;
import static campus.system.LoginInterface.stmt;
import java.sql.*;
import javax.swing.JOptionPane;

public class Admin extends User {

    private static PreparedStatement Ps;
    public int Foundcourse = 0;

    Admin() {

    }

    public void addStudent(int id, String password, String Name, int courseId1, int courseId2) throws SQLException {
        if (checkcourse(courseId1) == 1 && checkcourse(courseId2) == 1) {
            Ps = con.prepareStatement("insert into student(id,password,Name,course1Id,course2Id)  values(?,?,?,?,?)");
            Ps.setInt(1, id);
            Ps.setString(2, password);
            Ps.setString(3, Name);
            Ps.setInt(4, courseId1);
            Ps.setInt(5, courseId2);
            Ps.executeUpdate();
            Ps = con.prepareStatement("insert into MARK(ID,COURSEID,MARK)  values(?,?,?)");
            Ps.setInt(1, id);
            Ps.setInt(2, courseId1);
            Ps.setDouble(3, 0);
            Ps.executeUpdate();
            Ps = con.prepareStatement("insert into MARK(ID,COURSEID,MARK)  values(?,?,?)");
            Ps.setInt(1, id);
            Ps.setInt(2, courseId2);
            Ps.setDouble(3, 0);
            Ps.executeUpdate();
        }
    }

    public void addCourse(int courseid, String Name, String Booklet, String videoLink, String TestSolution, String Day, String Time) throws SQLException {
        Ps = con.prepareStatement("insert into COURSES(id,Name,Booklet,video,TestSolution,Date,Time)  values(?,?,?,?,?,?,?)");
        Ps.setInt(1, courseid);
        Ps.setString(2, Name);
        Ps.setString(3, Booklet);
        Ps.setString(4, videoLink);
        Ps.setString(5, TestSolution);
        Ps.setString(6, Day);
        Ps.setString(7, Time);
        Ps.executeUpdate();

    }

    public void UpdateTimetable(int courseid, String Day, String Time) throws SQLException {
        Foundcourse = checkcourse(courseid);
        if (Foundcourse == 1) {
            Rs.updateString(6, Day);
            Rs.updateString(7, Time);
            Rs.updateRow();

        }

    }

    public void addProfessor(int id, String password, int courseId) throws SQLException {
        if (checkcourse(courseId) == 1) {

            Ps = con.prepareStatement("insert into PROFESSOR(ID,PASSWORD,COURSEID)  values(?,?,?)");
            Ps.setInt(1, id);
            Ps.setString(2, password);
            Ps.setInt(3, courseId);
            Ps.executeUpdate();

        } else {
            JOptionPane.showMessageDialog(null, "ID is already exist", "Erorr", JOptionPane.ERROR_MESSAGE);
        }
    }

}
