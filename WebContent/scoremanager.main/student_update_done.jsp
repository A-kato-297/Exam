<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/subject_update_done_style.css">

    <div class="container">

    <%@include file="../common/sidebar.jsp" %>

    <div class="content">
    <div class="h2">
        <h2>学生情報変更</h2>
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

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
    <div>
        <a href="StudentList.action">学生一覧</a>

    </div>
</div>
</div>

<%@include file="../common/footer.html" %>