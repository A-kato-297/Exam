<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/student_create_style.css">

<div class="container">
<%@include file="/common/sidebar.jsp" %>

<div class="content">
<div class="h2">
<h2>学生情報登録</h2>
</div>
<form action="StudentCreateExecute.action" method="post">
    <label>入学年度<br>
        <select name='ent_year'>
            <c:forEach var="year" begin="2020" end="2030">
                <option value="${year}">${year}</option>
            </c:forEach>
        </select><br>
    </label>

    <label>学生番号<br>
        <input type="text" name="no" value="学生番号を入力してください">
    </label><br>

    <label>氏名<br>
        <input type="text" name="name" value="氏名を入力してください">
    </label><br>

    <label>クラス<br>
        <select name="class_num">
            <c:forEach var="classNum" items="${classNumList}">
                <option value="${classNum.classNum}">${classNum.classNum}</option>
            </c:forEach>
        </select>
    </label><br>

    <input type="submit" value="登録して終了"><br>
</form>
<br>
<a href="menu.jsp">戻る</a>
</div>
</div>
<%@include file="../common/footer.html" %>