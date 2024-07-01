<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../common/header.html" %>

<div class="container">
    <div class="main-content">
        <h2>科目情報変更</h2>
        <c:if test="${not empty subject}">
            <p>科目コード: ${subject.cd}</p>
            <form action="SubjectUpdateExecute.action" method="post">
                <input type="hidden" name="cd" value="${subject.cd}">
                <p>科目名: <input type="text" name="name" value="${subject.name}"></p>
                <input type="submit" value="変更">
            </form>
        </c:if>
        <c:if test="${empty subject}">
            <p>${error}</p>
        </c:if>
        <a href="SubjectList.action">戻る</a>
    </div>
</div>

<%@ include file="../common/footer.html" %>
