<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/student_update_style.css">

<div class="container">
<%@include file="/common/sidebar.jsp" %>
<div class="content">
    <h2>学生情報変更</h2>
    <form action="StudentUpdateExecute.action" method="post">
        <div>
        <br>
    		<label>入学年度</label>
    		<span>${student.entYear}</span>
		</div>
		<div>
    		<label>学生番号</label>
    		<span>${student.no}</span>
		</div>

        <div>
            <label>氏名</label>
            <input type="text"   name="name" value="${student.name}" placeholder="氏名を入力してください" required>
        </div>
        <div>
            <label>クラス</label>
            <br>
            <select name="classNum">
                <c:forEach var="classNum" items="${classNums}">
                    <option value="${classNum}" <c:if test="${classNum == student.classNum}">selected</c:if>>${classNum}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <label>在学中</label>
            <input type="checkbox" name="isAttend" <c:if test="${student.isAttend}">checked</c:if>>
        </div>
        <div>
            <input type="hidden" name="no" value="${student.no}">
            <input type="hidden" name="entYear" value="${student.entYear}">
            <button type="submit">変更</button>

           <br><br>
            <a href="StudentList.action">戻る</a>
        </div>
    </form>
</div>
</div>
<%@include file="../common/footer.html" %>