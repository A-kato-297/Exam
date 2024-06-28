<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/style.css">

<style>
        body {
            font-family: Arial, sans-serif;
        }
        h2 {
            color: #2c3e50;
        }
        .container {
            width: 80%;
            margin: 0 auto;
            text-align: left;
            background-color: #C0C0C0;
        }
        .message {
            background-color: #33CC99;
            font-weight: bold;
            text-align: center;
        }
        .links a {
            display: block;
            margin: 10px 0;
            color: #2980b9;
            text-decoration: none;
        }
        .links a:hover {
            text-decoration: underline;
        }
    </style>

<div class="container">
    <div class="sidebar">
        <%@include file="/common/sidebar.jsp" %>
    </div>

    <!-- メインコンテンツ -->
    <div class="main-content">
        <h2>科目情報登録</h2>
    </div>

    <p class="message">
        <%
            String message = (String) request.getAttribute("message");
            if (message == null) {
                message = "登録が完了しました";  // デフォルトメッセージ
            }
            out.print(message);
        %>
    </p>

    <div class="links">
        <a href="subject_create.jsp">戻る</a>
        <a href="subject_list">科目一覧</a>
    </div>
</div>

<%@include file="../common/footer.html" %>