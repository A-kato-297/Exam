package scoremanager.main;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
;

@WebServlet("/search")
public class TestListStudentExcecuteAction extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentNumber = request.getParameter("studentNumber");

        if (studentNumber == null || studentNumber.isEmpty()) {
            request.setAttribute("errorMessage", "�w����񂪑��݂��܂���ł���");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            // ���ۂ̌������W�b�N�������ɒǉ�
            // �Ⴆ�΁A�f�[�^�x�[�X����w��������������Ȃ�
        }
    }
}
