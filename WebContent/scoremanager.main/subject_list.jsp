<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/style.css">

<div class="container">
    <div class="sidebar">
        <%@include file="/common/sidebar.jsp" %>
    </div>
    <div class="container">
        <div class="main">
        <h2>科目管理</h2>
            <table>
                <thead>
                    <tr>
                    	<th>入学年度</th>
                        <th>学生番号</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="subject" items="${subject_list}">
                        <tr>
                            <td>${subject.entYear}</td>
                            <td>${subject.no}</td>
                            <td><a href="#">変更</a></td>
                            <td><a href="#">変更</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../common/footer.html" %>