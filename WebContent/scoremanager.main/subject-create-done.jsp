<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/subject_create_done_style.css">

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
 <br>
        <br>
        <br>
        <br>
        <br>

    <div class="links">
        <a href="subject_create.jsp">戻る</a>　　　　　　　　　　　　　　　　　　　
        <a href="subject_list">科目一覧</a>
    </div>
</div>
</div>
</body>
</html>


<%@include file="../common/footer.html" %>