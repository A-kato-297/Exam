<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/menu_style.css">

<div class="container">
	<div class="sidebar">
        <%@include file="/common/sidebar.jsp" %>
    </div>
    <div class="main-content">
        <h2>科目削除確認</h2>
        <div class="flex-row">
        <c:if test="${not empty subject}">
            <p>「${subject.name}」を削除してもよろしいですか？</p>
            <form action="SubjectDeleteExecute.action" method="post">
                <input type="hidden" name="cd" value="${subject.cd}"><br>
                <input type="submit" value="削除">
            </form>
        </c:if>
        <c:if test="${empty subject}">
            <p>科目が存在していません。</p>
        </c:if>
    </div>
    </div>
</div>

<%@ include file="../common/footer.html" %>