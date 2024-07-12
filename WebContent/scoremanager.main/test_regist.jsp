<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="../common/header.html" %>
<link rel="stylesheet" href="/hcp/common/sidebar_style.css">
<link rel="stylesheet" href="/hcp/scoremanager.main/test_regist_style.css">


<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>得点管理システム</title>
</head>
<body>
    <div class="container">
     <div class="sidebar">
        <%@include file="/common/sidebar.jsp" %>
    </div>
<div class="content">
<div class="h2">
        <h2>成績管理</h2>
    </div>

        <div class="form-container">
            <form action="Test_RegistExecude.action" method="post">
                <table>
                    <tr>
                        <th>入学年度</th>
                        <th>クラス</th>
                        <th>科目</th>
                        <th>回数</th>
                    </tr>
                    <tr>
                        <td>
                            <select name="f1" id="f1">
                                <option value="">--------</option>
                                <c:forEach var="year" items="${year}">
                                    <option value="${year}">${year}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
                            <select name="f2" id="f2">
                                <option value="">--------</option>
                                <c:forEach var="num" items="${num}">
                                    <option value="${num}">${num}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td>
       				<select name="f3" id="f3">
                                <option value="">--------</option>
                                <c:forEach var="subject" items="${subject}">
                                    <option value="${subject.cd}">${subject.name}</option>
                                </c:forEach>
                            </select>

                        </td>

                        <td>
                            <select name="f4" id="f4">
                                <option value="">--------</option>
                                <c:forEach var="num" items="${num}">
                                    <option value="${num}">${num}</option>
                                </c:forEach>
                            </select>
                        </td>
                        <td rowspan="2" class="button-container">
                            <button type="submit" onclick="validateForm()">検索</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    </div>


<%@include file="../common/footer.html" %>