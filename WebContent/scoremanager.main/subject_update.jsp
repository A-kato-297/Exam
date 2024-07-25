<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/subject_update.css">

<%@ include file="../common/header.html" %>

<div class="container">
    <%@ include file="../common/sidebar.jsp" %>
    <div class="main-content">
        <div class="h2-container">
            <h2 class="h2">科目情報変更</h2>
        </div>
        <c:if test="${not empty subject}">
            <form action="SubjectUpdateExecute.action" method="post">
                <input type="hidden" name="cd" value="${subject.cd}">
                <div class="subject-info">
                    <div class="info-row">
                        <label class="label">科目コード</label>
                        <div class="code-value right-align">
                            <input type="text" id="code" name="code" value="${subject.cd}" style="background: transparent; border: none; color: black; text-align: left; width: auto; padding: 0;">
                        </div>
                    </div>
                    <div class="info-row">
                        <label class="label">科目名</label>

                        <div class="name-value">
                          <input type="text" id="name" name="name" value="${subject.name}" required style="width: 500%; padding: 8px; box-sizing: border-box;">
                        </div>

                    </div>
                </div>

                <div class="form-actions">
                    <input type="submit" value="変更">
                    <a href="SubjectList.action" class="btn-back">戻る</a>
                </div>
            </form>
        </c:if>
        <c:if test="${empty subject}">
            <p>${error}</p>
        </c:if>
    </div>
</div>

<%@ include file="../common/footer.html" %>

