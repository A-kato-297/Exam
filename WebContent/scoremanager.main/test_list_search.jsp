<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    .container {
        display: flex;
        margin: 20px;
    }

    .sidebar {
        width: 300px;
        height: auto;
        padding: 10px;
        box-sizing: border-box;
        border-right: 3px solid #d3d3d3;
        flex-shrink: 0;
    }

    .form-container {
        flex: 1;
        padding: 10px;
    }

    .form-section {
        margin-bottom: 20px;
        padding: 10px;
        border: 2px solid #d3d3d3;
        border-radius: 10px;
    }

    .form-container h2 {
        background-color: #EEEEEE;
        padding: 10px;
        margin: 0;
        text-align: left;
        font-weight: bold;
    }

    .form-group-inline {
        display: flex;
        align-items: center;
        margin-bottom: 10px;
    }

    .form-group-inline > div {
        margin-right: 10px;
    }

    .form-group-inline > div:first-child {
        margin-right: 20px; /* Add more space for the label section */
    }

    .form-group-inline > p,
    .form-group-inline > select,
    .form-group-inline > input,
    .form-group-inline > button {
        display: inline-block;
    }

    .form-group-inline > p {
        width: 100px; /* Label width */
        margin: 0;
    }

    .form-group-inline > select,
    .form-group-inline > input,
    .form-group-inline > button {
        width: 150px; /* Adjust based on your needs */
    }

    .divider {
        border-top: 1px solid #d3d3d3;
        margin: 20px 0;
    }
</style>

<div class="container">
    <%@include file="/common/sidebar.jsp" %>

    <div class="form-container">
        <h2>成績参照</h2><br>
        <div class="form-section">
            <form action="TestListSubjectExecute.action" method="get">
                <div class="form-group-inline">
                    <div><p>科目情報</p></div>
                    <div><p>入学年度</p><select name="entYear">
                        <c:forEach var="year" items="${entYears}">
                            <option value="${year}">${year}</option>
                        </c:forEach>
                    </select></div>
                    <div><p>クラス</p><select name="classNum">
                        <c:forEach var="classNum" items="${classNumbers}">
                            <option value="${classNum}">${classNum}</option>
                        </c:forEach>
                    </select></div>
                    <div><p>科目</p><select name="subjectName">
                        <c:forEach var="subject" items="${subjects}">
                            <option value="${subject}">${subject}</option>
                        </c:forEach>
                    </select></div>
                    <div><button type="submit">検索</button></div>
                </div>
            </form>
        </div>

        <div class="divider"></div>

        <div class="form-section">
            <form action="TestListStudentExecute.action" method="get">
                <div class="form-group-inline">
                    <div><p>学生情報</p></div>
                    <div><p>学生番号</p><input type="text" name="studentNo" maxlength="10" placeholder="学生番号を入力してください" required></div>
                    <div><button type="submit">検索</button></div>
                </div>
            </form>
        </div>