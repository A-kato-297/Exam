package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Test;
import bean.TestListStudent;
import dao.TestListStudentDao;
import tool.Action;

public class TestListStudentExecuteAction extends Action {
    public void execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {

        String studentNo = request.getParameter("studentNo");
        TestListStudentDao dao = new TestListStudentDao();

        // 学生の名前を取得
        String studentName = dao.getStudentName(studentNo);
        // 学生のテスト結果を取得
        List<Test> testResults = dao.getTestResultsByStudentNo(studentNo);

        TestListStudent testListStudent = new TestListStudent();
        testListStudent.setStudentName(studentName);
        testListStudent.setStudentNo(studentNo);
        testListStudent.setTestResults(testResults);

        request.setAttribute("testListStudent", testListStudent);

        request.getRequestDispatcher("test_list_student.jsp").forward(request, response);
    }
}