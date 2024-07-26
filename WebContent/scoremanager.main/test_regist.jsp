<!-- インクルードした際の文字化け防止 -->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="../common/header.html" %>
<%@ include file="/common/sidebar.jsp" %>

<div class="main-content">
    <div class="container">
        <h2>成績管理</h2>

        <form method="post" action="TestRegist.action">
            <div class="search-bar">
                <div class="block">
                    <label>入学年度</label>
                    <select name="entYear">
                        <option value="">--------</option>
                        <c:forEach var="year" items="${entYears}">
                            <option value="${year}">${year}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="block">
                    <label>クラス</label>
                    <select name="classNum">
                        <option value="">--------</option>
                        <c:forEach var="classNum" items="${classNumbers}">
                            <option value="${classNum}">${classNum}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="block">
                    <label>科目</label>
                    <select name="subjectName">
                        <option value="">--------</option>
                        <c:forEach var="subject" items="${subjects}">
                            <option value="${subject}">${subject}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="block">
                    <label>回数</label>
                    <select name="testNo">
                        <option value="">--------</option>
                        <c:forEach var="testNo" items="${testNos}">
                            <option value="${testNo}">${testNo}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="block">
                    <button type="submit" name="search">検索</button>
                </div>
            </div>
        </form>

        <c:if test="${not empty searchResults}">
            <h3>科目：${subjectName}(${testNo}回)</h3>
            <form action="TestRegistExecute.action" method="post">
                <table>
                    <tr>
                        <th>入学年度</th>
                        <th>クラス</th>
                        <th>学生番号</th>
                        <th>氏名</th>
                        <th>点数</th>
                    </tr>
                    <c:forEach var="result" items="${searchResults}">
                        <tr>
                            <td>${result.entYear}</td>
                            <td>${result.classNum}</td>
                            <td>${result.studentNo}</td>
                            <td>${result.name}</td>
                            <td>
                                <input type="hidden" name="studentNo" value="${result.studentNo}">
                                <input type="number" name="point" value="${result.point}">
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <button type="submit">登録して終了</button>
            </form>
        </c:if>
    </div>
</div>

<%@ include file="../common/footer.html" %>

<style>
    body {
        display: flex;
        flex-direction: column;
    }

    .main-content {
        display: flex;
        position: relative;
    }

    .sidebar {
        flex-shrink: 0;
    }

    .container {
        position: absolute;
        top: -500px;
        left: 320px;
        padding: 20px;
        width: calc(100% - 320px);
    }

    h2 {
        background-color: #EEEEEE;
        padding: 10px;
        margin: 10px 0;
        border-radius: 5px;
    }

    .search-bar {
        display: flex;
        align-items: flex-start;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 10px;
    }

    .block {
        margin-right: 20px;
    }

    .block label {
        display: block;
        margin-bottom: 5px;
    }

    .block select {
        display: block;
    }

    table {
        width: 100%;
        border-collapse: collapse;
    }

    table, th, td {
        border: none;
    }

    table tr {
        border-bottom: 1px solid #ccc;
    }

    th, td {
        padding: 10px;
        text-align: left;
    }
</style>