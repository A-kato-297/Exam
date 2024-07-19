<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/header.html" %>
<%@include file="../common/sidebar.jsp" %>

<div class="container">
    <div class="main-content">
        <h2>成績参照</h2>

        <form action="TestListSubjectExecute.action" method="get">
            <div class="search-bar">
                <p>科目情報</p>
                <p>入学年度</p>
                <select name="entYear">
                    <option value="">選択してください</option>
                    <c:forEach var="student" items="${students}">
                        <option value="${student.entYear}">${student.entYear}</option>
                    </c:forEach>
                </select>
                <p>クラス</p>
                <select name="classNum">
                    <option value="">選択してください</option>
                    <c:forEach var="student" items="${students}">
                        <option value="${student.classNum}">${student.classNum}</option>
                    </c:forEach>
                </select>
                <p>科目</p>
                <select name="subjectCd">
                    <option value="">選択してください</option>
                    <!-- 科目選択のオプションを追加する必要があります -->
                </select>
                <input type="submit" value="検索">
            </div>
        </form>

        <form action="TestListStudentExecute.action" method="get">
            <div class="search-bar">
                <p>学生情報</p>
                <p>学生番号</p>
                <select name="studentNo">
                    <option value="">選択してください</option>
                    <c:forEach var="student" items="${students}">
                        <option value="${student.no}">${student.no}</option>
                    </c:forEach>
                </select>
                <input type="submit" value="検索">
            </div>
        </form>
        <p>科目情報を選択または学生情報を入力して検索ボタンをクリックしてください</p>
    </div>
</div>

<%@include file="../common/footer.html" %>