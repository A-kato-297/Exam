package scoremanager.main;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Subject;
import bean.Teacher;
import bean.TestListStudent;
import dao.SubjectDao;
import dao.TestListStudentDao;
import dao.TestListSubjectDao;
import tool.Action;

public class TestListAction extends Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher) session.getAttribute("user");

        String entYearStr = "";
        String classNum = "";
        Subject subject = null;
        int no = 0;
        List<TestListStudent> TestListStudents = null;
        TestListStudentDao tListStudentDao = new TestListStudentDao();
        SubjectDao sDao = new SubjectDao();
        TestListSubjectDao tListSubjectDao = new TestListSubjectDao();

        entYearStr = request.getParameter("f1");
        classNum = request.getParameter("f2");

    }

    public void setTestListSubject(HttpServletRequest request, HttpServletResponse response) {
        
    }

    public void setTestListStudent(HttpServletRequest request, HttpServletResponse response) {
        // Implement method logic
    }
}
