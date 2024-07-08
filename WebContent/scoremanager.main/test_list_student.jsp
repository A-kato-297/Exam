<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>成績管理一覧画面</title>
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid black;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
</head>
<body>
    <h1>成績管理一覧画面</h1>
    <div>
        <!-- ここに成績管理一覧画面のメッセージを表示することができます -->
    </div>
    <table>
        <thead>
            <tr>
                <th>入学年度</th>
                <th>クラス</th>
                <th>学生番号</th>
                <th>氏名</th>
                <th>1回の点数</th>
                <th>2回の点数</th>
            </tr>
        </thead>
        <tbody>
            <!-- ここで JSTL を使用してデータベースから取得したデータをループ表示 -->
            <c:forEach var="record" items="${records}">
                <tr>
                    <td>${record.enrollmentYear}</td>
                    <td>${record.class}</td>
                    <td>${record.studentNumber}</td>
                    <td>${record.name}</td>
                    <td>
                        <c:choose>
                            <c:when test="${record.firstScore != null}">
                                ${record.firstScore}
                            </c:when>
                            <c:otherwise>
                                -
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>
                        <c:choose>
                            <c:when test="${record.secondScore != null}">
                                ${record.secondScore}
                            </c:when>
                            <c:otherwise>
                                -
                            </c:otherwise>
                        </c:choose>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
