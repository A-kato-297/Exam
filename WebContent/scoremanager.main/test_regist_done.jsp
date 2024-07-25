<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/score_style.css">


 <div class="container">

        <%@include file="/common/sidebar.jsp" %>

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
        <a href="TestRegist.action">戻る</a>　　　　　　　　　　
        <a href="TestList.action">成績参照</a>
        </div>

    </div>
    </div>
 </div>
<%@include file="../common/footer.html" %>
