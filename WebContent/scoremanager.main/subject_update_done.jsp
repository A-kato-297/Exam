<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/subject_update_done_style.css">

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
        <h2>科目情報変更</h2>
    </div>

    <p class="message">
        <%
            String message = (String) request.getAttribute("message");
            if (message == null) {
                message = "変更が完了しました";
            }
            out.print(message);
        %>
    </p>

    <div>
     <br>
        <br>
        <br>
        <br>
        <br>
        <a href="SubjectList.action">科目一覧</a>
    </div>
</div>
</div>
<%@include file="../common/footer.html" %>