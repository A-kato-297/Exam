package scoremanager.main;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TestDao;
import tool.Action;

public class TestRegistExecuteAction extends Action {
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        TestDao dao = new TestDao();

        String[] studentNos = request.getParameterValues("studentNo");
        String[] points = request.getParameterValues("point");

        for (int i = 0; i < studentNos.length; i++) {
            dao.save(studentNos[i], Integer.parseInt(points[i]));
        }

        request.getRequestDispatcher("/scoremanager.main/test_regist_done.jsp").forward(request, response);
    }
}