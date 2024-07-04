<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/style.css">

<h2>学生情報登録</h2>

<form action="StudentCreateExecute.action" method="post">
    <label>入学年度<br>
        <select name='ent_year'>
            <c:forEach var="year" begin="2020" end="2030">
                <option value="${year}">${year}</option>
            </c:forEach>
        </select><br>
    </label>

    <label>学生番号<br>
        <input type="text" name="no" value="">
    </label><br>

    <label>氏名<br>
        <input type="text" name="name" value="">
    </label><br>

    <label>クラス<br>
        <select name="class_num">
            <option value="1">131</option>
            <option value="2">132</option>
            <option value="3">133</option>
            <!-- Add more options as needed -->
        </select>
    </label><br>

    <input type="submit" value="登録して終了"><br>
</form>

<a href="menu.jsp">戻る</a>

<%@include file="../common/footer.html" %>

