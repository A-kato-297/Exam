package scoremanager.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import tool.Action;

public class StudentUpdateExecuteAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String no = request.getParameter("no");
        String name = request.getParameter("name");
        String classNum = request.getParameter("classNum");
        boolean isAttend = request.getParameter("isAttend") != null;
        int entYear = Integer.parseInt(request.getParameter("entYear"));

        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/hcp");
            Connection con = ds.getConnection();

            PreparedStatement st = con.prepareStatement(
                "UPDATE STUDENT SET NAME = ?, CLASS_NUM = ?, IS_ATTEND = ? WHERE NO = ? AND ENT_YEAR = ?"
            );
            st.setString(1, name);
            st.setString(2, classNum);
            st.setBoolean(3, isAttend);
            st.setString(4, no);
            st.setInt(5, entYear);
            st.executeUpdate();
            st.close();
            con.close();

            request.getRequestDispatcher("student_update_done.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
