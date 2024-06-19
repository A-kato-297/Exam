<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/no_login_header.html" %>

    <!-- メインコンテンツ -->
    <div class="main-content">
        <h2>ログイン</h2>

            <c:if test="${not empty error}">
        		<p>${error}</p>
    		</c:if>

        <form action="LoginExecute.action" method="post" class="login-form">
            <div class="form-group">
                <label for="id">ID</label>
                <input type="text" id="id" name="id" maxlength="20" placeholder="半角でご入力ください" required>
            </div>

            <div class="form-group">
                <label for="password">パスワード</label>
                <input type="password" id="password" name="password" maxlength="20" placeholder="20文字以内の半角英数字でご入力ください" required>
            </div>

            <div class="form-group center-align">
            	<input type="checkbox" id="chk_d_ps" name="chk_d_ps">
            	<label for="chk_d_ps">パスワードを表示</label>
            </div>

            <div class="form-group center-align">
                <input type="submit" id="login" name="login" value="ログイン">
            </div>
        </form>
    </div>

    <script>
        // パスワード表示/非表示を切り替えるJavaScript
        document.getElementById('chk_d_ps').addEventListener('change', function() {
            const passwordInput = document.getElementById('password');
            if (this.checked) {
                passwordInput.type = 'text';
            } else {
                passwordInput.type = 'password';
            }
        });
    </script>

<%@include file="../common/footer.html" %>