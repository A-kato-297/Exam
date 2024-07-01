<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../common/header.html" %>

<div class="container">
    <div class="main-content">
        <h2>科目削除確認</h2>
        <c:if test="${not empty subject}">
            <p>「${subject.name}」を削除してもよろしいですか？</p>
            <form action="SubjectDeleteExecute.action" method="post">
                <input type="hidden" name="cd" value="${subject.cd}">
                <input type="submit" value="削除">
            </form>
        </c:if>
        <c:if test="${empty subject}">
            <p>削除する科目が見つかりません。</p>
        </c:if>
    </div>
</div>

<%@ include file="../common/footer.html" %>