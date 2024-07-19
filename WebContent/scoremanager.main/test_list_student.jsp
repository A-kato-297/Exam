<%@ page contentType="text/html; charset=UTF-8" %>
<%@ include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/common/sidebar_style.css">
<link rel="stylesheet" href="/hcp/scoremanager.main/test_student_style.css">

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>成績管理一覧画面</title>
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <%@ include file="/common/sidebar.jsp" %>
        </div>
        <div class="content">
            <div class="h2">
                <h2>成績一覧(科目)</h2>
            </div>
            <div class="line1">
                <div class="line">
                    <form action="search" method="post">
                        <p>科目情報</p>
                        <table>
                            <tr>
                                <th>入学年度</th>
                                <th>クラス</th>
                                <th>科目</th>
                            </tr>
                            <tr>
                                <td>
                                    <select name="f1">
                                        <option value="--------">--------</option>
                                        <!-- 他のオプションをここに追加 -->
                                    </select>
                                </td>
                                <td>
                                    <select name="f2">
                                        <option value="--------">--------</option>
                                        <!-- 他のオプションをここに追加 -->
                                    </select>
                                </td>
                                <td>
                                    <select name="f3">
                                        <option value="--------">--------</option>
                                        <!-- 他のオプションをここに追加 -->
                                    </select>
                                </td>
                                <td>
                                    <button type="submit" name="searchSubject" value="31">検索</button>
                                </td>
                            </tr>
                        </table>

                        <div>学生情報</div>
                        <div>学生番号</div>
                        <input type="text" name="f4" placeholder="学生番号を入力してください" maxlength="10" required>
                        <button type="submit" name="searchStudent" value="32">検索</button>

                        <p id="error-message" style="color: red;">
                            <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
<%@ include file="../common/footer.html" %>
