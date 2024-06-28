package scoremanager.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import bean.Student;
import tool.Action;

public class SuListAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> student_list = new ArrayList<>();

        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/hcp");
            Connection con = ds.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT NO, NAME, ENT_YEAR, CLASS_NUM, IS_ATTEND FROM STUDENT");
//            PreparedStatement st = con.prepareStatement("SELECT NO, NAME, ENT_YEAR, CLASS_NUM, CASE WHEN IS_ATTEND THEN 'O' ELSE 'X' END AS IS_ATTEND FROM STUDENT");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Student student = new Student();
                student.setNo(rs.getString("no"));
                student.setName(rs.getString("name"));
                student.setClassNum(rs.getString("class_num"));
                student.setEntYear(rs.getInt("ent_year"));
                student.setAttend(rs.getBoolean("is_attend"));
                student_list.add(student);
            }
            st.close();
            con.close();
        } catch (Exception e) {
            throw new ServletException(e);
        }

        request.setAttribute("student_list", student_list);
        request.getRequestDispatcher("pre_student_list.jsp")
        	.forward(request, response);
    }
}