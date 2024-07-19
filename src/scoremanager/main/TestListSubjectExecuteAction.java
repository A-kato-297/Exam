package scoremanager.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Test;
import bean.TestListSubject;
import dao.TestListSubjectDao;
import tool.Action;

public class TestListSubjectExecuteAction extends Action {
    public void execute(
        HttpServletRequest request, HttpServletResponse response
    ) throws Exception {

        String entYear = request.getParameter("entYear");
        String classNum = request.getParameter("classNum");
        String subjectCd = request.getParameter("subjectCd");

        TestListSubjectDao dao = new TestListSubjectDao();

        // 科目名を取得
        String subjectName = dao.getSubjectName(subjectCd);
        // 科目のテスト結果を取得
        List<Test> testResults = dao.getTestResultsBySubjectCd(entYear, classNum, subjectCd);

        TestListSubject testListSubject = new TestListSubject();
        testListSubject.setSubjectCd(subjectCd);
        testListSubject.setSubjectName(subjectName);
        testListSubject.setTestResults(testResults);

        request.setAttribute("testListSubject", testListSubject);

        request.getRequestDispatcher("test_list_subject.jsp").forward(request, response);
    }
}