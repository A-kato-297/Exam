<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../common/header.html" %>

<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>得点管理システム</title>
    <style>
        /* Basic styling */
        body {
            font-family: Arial, sans-serif;
        }
        .container {
            width: 80%;
            margin: 0 auto;
        }
        .header {
            text-align: center;
            margin-top: 20px;
        }
        .form-container {
            margin: 20px 0;
        }
        .form-container table {
            width: 100%;
            border-collapse: collapse;
        }
        .form-container th, .form-container td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }
        .form-container th {
            background-color: #f2f2f2;
        }
        .button-container {
            text-align: right;
            margin-top: 20px;
        }
        .error-message {
            color: red;
            font-weight: bold;
            margin: 10px 0;
        }
        .header {
            display: flex;
            justify-content: left;
            background-color: #C0C0C0;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h2>成績管理</h2>
        </div>
        <div class="form-container">
            <form action="scoremanager" method="post">
                <div id="error-message-1" class="error-message"></div>
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
                            <button type="button" onclick="validateForm()">検索</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
    <script>
        function validateForm() {
            var year = document.getElementById("f1").value;
            var classValue = document.getElementById("f2").value;
            var subject = document.getElementById("f3").value;
            var errorMessage1 = document.getElementById("error-message-1");

            if (year === "" || classValue === "" || subject === "") {
                errorMessage1.innerText = "入学年度とクラスと科目を選択してください";
            } else {
                errorMessage1.innerText = "";
                document.form
<%@include file="../common/footer.html" %>