<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.html" %>
<link rel="stylesheet" href="/hcp/common/sidebar_style.css">
<link rel="stylesheet" href="/hcp/scoremanager.main/score_style.css">



<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>得点管理システム</title>
</head>
<body>
 <div class="container">
     <div class="sidebar">
        <%@include file="/common/sidebar.jsp" %>
    </div>
    <div class="content">
    <div class="h2">
        <h2>成績管理</h2>
    </div>

    <div class="message">
        <%
            String message = (String) request.getAttribute("message");
            if (message == null) {
                message = "登録が完了しました";  // デフォルトメッセージ
            }
            out.print(message);
        %>
    </div>
    <br>
        <br>
        <br>
        <br>
        <br>
        <br>

    <div class="links">
        <a href="<%= request.getContextPath() %>/back">戻る</a>　　　　　　　　　　
        <a href="<%= request.getContextPath() %>/reference">成績参照</a>
        </div>

    </div>
    </div>
</body>
</html>
<%@include file="../common/footer.html" %>
