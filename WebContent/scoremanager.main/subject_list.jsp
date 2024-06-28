<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/style.css">

<div class="container">
    <div class="sidebar">
        <%@include file="/common/sidebar.jsp" %>
    </div>

    <!-- メインコンテンツ -->
    <div class="main-content">
        <h2>科目管理</h2>
        <a href="SubjectCreate.action" class="insert-subject">新規登録</a>

            <tr>
                <th>科目コード</th>
                <th>科目名</th>
            </tr>

            <c:forEach var="subject" items="${subjectList}">
                <tr>
                	<td>${subject.cd}</td>
                    <td>${subject.Name}</td>
                    <td>
                    	変更
                    </td>
                    <td>
                    	削除
                    </td>
                </tr>
            </c:forEach>
    </div>

</div>

<%@include file="../common/footer.html" %>