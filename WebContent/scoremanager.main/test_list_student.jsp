<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.html" %>

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
        <%@include file="/common/sidebar.jsp" %>
    </div>
<div class="content">
<div class="h2">
<h2>成績一覧(科目)</h2>
</div>
<div class="line1">
        <div class="line">
            <form action="TestList.action" method="post">
                <p>科目情報</p>
                <table>
                    <tr>
                         <!-- ②科目情報 -->
                        <th>入学年度</th> <!-- ③ヘッダー(入学年度) -->
                        <th>クラス</th> <!-- ④ヘッダー(クラス) -->
                        <th>科目</th> <!-- ⑤ヘッダー(科目) -->
                    </tr>

                             <tr>
                        <td>
                            <select name="f1"> <!-- ⑥入学年度セレクトボックス -->
                                <option value="--------">--------</option>
                                <!-- 他のオプションをここに追加 -->
                            </select>
                        </td>
                        <td>
                            <select name="f2"> <!-- ⑦クラスセレクトボックス -->
                                <option value="--------">--------</option>
                                <!-- 他のオプションをここに追加 -->
                            </select>
                        </td>
                        <td>
                            <select name="f3"> <!-- ⑧科目セレクトボックス -->
                                <option value="--------">--------</option>
                                <!-- 他のオプションをここに追加 -->
                            </select>
                        </td>
                        <td>
                            <button type="submit" name="searchSubject" value="31">検索</button> <!-- ⑨検索ボタン -->

                        </td>
                    </tr>
                </table>


                <div>学生情報</div> <!-- ⑩学生情報 -->
                <div>学生番号</div> <!-- ⑪ヘッダー(学生番号) -->
                <input type="text" name="f4" value="${f4}" placeholder="学生番号を入力してください" maxlength="10" required> <!-- ⑫学生番号入力テキスト -->
                <button type="submit" name="searchStudent" value="32">検索</button> <!-- ⑬検索ボタン -->


            </form>
            </div>
        </div>
        </div>
        </div>

</body>
</html>
<%@ include file="../common/footer.html" %>




