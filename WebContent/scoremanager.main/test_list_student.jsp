<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.html" %>

<h2>成績参照</h2>

<form action="TestListSubjectExecute.action" method="get">
    <p>科目情報</p>
    <p>入学年度</p>
    <select name="entYear">
        <c:forEach var="year" items="${entYears}">
            <option value="${year}">${year}</option>
        </c:forEach>
    </select>
    <p>クラス</p>
    <select name="classNum">
        <c:forEach var="classNum" items="${classNumbers}">
            <option value="${classNum}">${classNum}</option>
        </c:forEach>
    </select>
    <p>科目</p>
    <select name="subjectName">
        <c:forEach var="subject" items="${subjects}">
            <option value="${subject}">${subject}</option>
        </c:forEach>
    </select>
    <button type="submit">検索</button>
</form>

<form action="TestListStudentExecute.action" method="get">
    <p>学生情報</p>
    <p>学生番号</p>
    <input type="text" name="studentNo" maxlength="10">
    <button type="submit">検索</button>
</form>

<p>学生番号：${studentNo} の成績</p>

<table border="1">
    <tr>
        <th>学生名</th>
        <th>科目名</th>
        <th>科目コード</th>
        <th>試験番号</th>
        <th>点数</th>
    </tr>
    <c:forEach var="info" items="${studentInfo}">
        <tr>
            <td>${info.studentName}</td>
            <td>${info.subjectName}</td>
            <td>${info.subjectCd}</td>
            <td>${info.testNo}</td>
            <td>${info.point}</td>
        </tr>
    </c:forEach>
</table>

<%@ include file="../common/footer.html" %>
