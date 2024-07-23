<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.html" %>

<%@ include file="../scoremanager.main/test_list_search.jsp" %>
<link rel="stylesheet" href="/hcp/scoremanager.main/test_list_student.css">

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