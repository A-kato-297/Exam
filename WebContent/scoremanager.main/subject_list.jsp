<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/style.css">

<div class="container">
    <div class="sidebar">
        <%@include file="/common/sidebar.jsp" %>
    </div>
    <div class="main-content">
        <h2>科目管理</h2>
        <a href="SubjectCreate.action" class="sub-cre">科目登録</a>
            <table>
                <thead>
                    <tr>
                    	<th>科目コード</th>
                        <th>科目名</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="subject" items="${subject_list}">
                        <tr>
                            <td>${subject.cd}</td>
                            <td>${subject.name}</td>
                            <td><a href="SubjectUpdate.action?cd=${subject.cd}">変更</a></td>
                            <td><a href="SubjectDelete.action?cd=${subject.cd}">削除</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>


<%@include file="../common/footer.html" %>