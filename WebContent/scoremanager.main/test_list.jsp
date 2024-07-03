<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../common/header.html" %>

<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>得点管理システム</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h2 {
            color: #2c3e50;
        }
        .container {
            width: 100%;
            margin: 0 auto;
            text-align: left;
            background-color: #C0C0C0;

        }
        .message {
            background-color: #33CC99;
            font-weight: bold;
            text-align: center;

        }
        .links a {
            display: block;
            margin: 10px 0;
            color: #2980b9;
            text-decoration: none;
        }
        .links a:hover {
            text-decoration: underline;
        }
        .Sentence {
        	  color:#33CCFF;
        }
        .line{
           width: 280px;               /* 幅指定 */
   		   height: 100px;              /* 高さ指定 */
    	   border: solid 2px #000;     /* 枠線指定 */
    	   border-radius: 10px;        /* 角丸指定 */
        	}
    </style>
</head>
<body>
    <div class="container">
        <h2>成績参照</h2> <!-- ①画面タイトル -->
        </div>


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
            </div>
            <div class="Sentence">
            <p>科目情報を選択または学生情報を入力して検索ボタンをクリックしてください</p> <!-- ⑭利用方法案内メッセージ -->
            </div>
            <input type="hidden" name="sj" value="${sj}"> <!-- ⑮科目情報識別コード -->
            <input type="hidden" name="st" value="${st}"> <!-- ⑯学生情報識別コード -->
        </form>

</body>
</html>
<%@include file="../common/footer.html" %>