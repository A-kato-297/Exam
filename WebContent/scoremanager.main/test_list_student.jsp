<%@ page contentType="text/html; charset=UTF-8" %>
<%@include file="../common/header.html" %>

<!DOCTYPE html>
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
            width: 80%;
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
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #000;
            padding: 8px;
            text-align: left;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>科目: <%= request.getAttribute("subjectName") %>（<%= request.getAttribute("examCount") %>回）</h2>

        <table>
            <tr>
                <th>入学年度</th>
                <th>クラス</th>
                <th>学生番号</th>
                <th>氏名</th>
                <th>点数</th>
            </tr>
            <%
              List<StudentRecord> records = (List<StudentRecord>) request.getAttribute("studentRecords");
                for (StudentRecord record : records) {
            %>
            <tr>
                <th><%= record.getEnrollmentYear() %></th>
                <td><%= record.getClassNumber() %></td>
                <td><%= record.getStudentId() %></td>
                <td><%= record.getStudentName() %></td>
                <td>
                    <input type="text" name="point_<%= record.getStudentId() %>" value="<%= record.getPoint() %>" />
                </td>
            </tr>
            <% } %>
        </table>

        <form action="submitRecord" method="post">
            <button type="submit">登録して終了</button>
        </form>
    </div>
</body>
</html>
<%@include file="../common/footer.html" %>

