<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>得点管理システム</title>
</head>
<body>
    <div class="container">
        <h2>科目情報削除</h2>
    </div>

    <p class="message">
        <%
            String message = (String) request.getAttribute("message");
            if (message == null) {
                message = "削除が完了しました";
            }
            out.print(message);
        %>
    </p>

    <div>
        <a href="SubjectList.action">戻る</a>
    </div>

<%@include file="../common/footer.html" %>