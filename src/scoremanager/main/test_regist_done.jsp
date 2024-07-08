<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/header.html" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>得点管理システム</title>
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
</head>
<body>
    <div class="container">
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
        <a href="<%= request.getContextPath() %>/back">戻る</a>
        <a href="<%= request.getContextPath() %>/reference">成績参照</a>
    </div>
</body>
</html>
<%@include file="../common/footer.html" %>
