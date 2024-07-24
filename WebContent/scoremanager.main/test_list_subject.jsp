<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.html" %>

<%@ include file="../scoremanager.main/test_list_search.jsp" %>
<link rel="stylesheet" href="/hcp/scoremanager.main/test_list_subject.css">

<p>科目：${subjectName}</p>

<table border="1">
    <tr>
        <th>入学年度</th>
        <th>クラス</th>
        <th>学生番号</th>
        <th>学生名</th>
        <th>科目名</th>
        <th>回数</th>
        <th>点数</th>
    </tr>
    <c:forEach var="info" items="${testSubjects}">
        <tr>
            <td>${info.entYear}</td>
            <td>${info.classNum}</td>
            <td>${info.studentNo}</td>
            <td>${info.studentName}</td>
            <td>${info.subjectName}</td>
            <td>${info.testNo}</td>
            <td>${info.point}</td>
        </tr>
    </c:forEach>
</table>

<%@ include file="../common/footer.html" %>