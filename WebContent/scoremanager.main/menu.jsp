<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/menu_style.css">

<div class="container">
    <div class="sidebar">
        <%@include file="/common/sidebar.jsp" %>
    </div>

    <!-- メインコンテンツ -->
    <div class="main-content">
        <h2>メニュー</h2>
        <div class="flex-row">

            <div class="flex-item bg-light-red">
                <a href="PreStudentList.action">学生管理</a>
            </div>

            <div class="flex-item bg-light-green">
                <div>成績管理</div><br>
                <a href="TestRegist.action">成績登録</a><br>
                <a href="TestList.action">成績参照</a>
            </div>

            <div class="flex-item bg-light-purple">
                <a href="SubjectList.action">科目管理</a>
            </div>
        </div>
    </div>
</div>

<%@include file="../common/footer.html" %>