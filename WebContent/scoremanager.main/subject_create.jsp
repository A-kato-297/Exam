<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/create_style.css">

<div class="container">
        <%@include file="/common/sidebar.jsp" %>

    <div class="content">
    <div class="h2">
        <h2>科目情報登録</h2>
        </div><br><br>

        <form action="SubjectCreateExecute.action" method="post" class="sub-cre-form">
            <div class="form-group">
                <label for="cd">科目コード</label>
                <input type="text" id="cd" name="cd" maxlength="20" placeholder="科目コードを入力してください" required>
            </div>

            <div class="form-group">
                <label for="name">科目名</label>
                <input type="text" id="name" name="name" maxlength="40" placeholder="科目名を入力してください" required>
            </div>


                <input type="submit" id="input" name="input" value="登録">

        </form>
        <br>


        <a href="SubjectList.action">戻る</a>
    </div>
</div>

<%@include file="../common/footer.html" %>