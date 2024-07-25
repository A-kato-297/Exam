<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/no_login_header.html" %>

<style>
.message{
	background-color: #80ff00;
	text-align: center;
}
.main-content{
	text-align: left;
}

</style>

<!-- メインコンテンツ -->
<div class="main-content">
    <h2>ログアウト</h2>
    <div class="message">
	<p>ログアウトしました</p>
	</div>
    <a href="/hcp/scoremanager.main/Login.action">ログイン</a>
</div>

<%@include file="../common/footer.html" %>