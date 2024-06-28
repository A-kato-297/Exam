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

import bean.Subject;
import tool.Action;

public class SubjectListAction extends Action {
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Subject> subjectList = new ArrayList<>();

        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:/comp/env/jdbc/hcp");
            Connection con = ds.getConnection();
            PreparedStatement st = con.prepareStatement("SELECT * FROM SUBJECT");
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                Subject subject = new Subject();
                subject.setCd(rs.getString("cd"));
                subject.setName(rs.getString("name"));
                subjectList.add(subject);
            }
            st.close();
            con.close();
        } catch (Exception e) {
            throw new ServletException(e);
        }

        request.setAttribute("subjectList", subjectList);
        request.getRequestDispatcher("subject_list.jsp")
        	.forward(request, response);
    }
}