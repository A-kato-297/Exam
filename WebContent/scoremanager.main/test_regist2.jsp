<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.html" %>
<link rel="stylesheet" href="/hcp/scoremanager.main/menu_style.css">

<div class="container">
    <div class="sidebar">
        <%@ include file="../common/sidebar.jsp" %>
    </div>

    <div class="main-content">
        <h2>成績管理</h2>

        <form action="PreTestRegist.action" method="post">
            <div class="search-bar" style="display: flex; gap: 10px;">

                入学年度:
                <select name="entYear">
                    <c:forEach var="year" items="${entYears}">
                        <option value="${year}">${year}</option>
                    </c:forEach>
                </select>

                クラス:
                <select name="classNum">
                    <c:forEach var="classNum" items="${classNums}">
                        <option value="${classNum}">${classNum}</option>
                    </c:forEach>
                </select>

                科目:
                <select name="subject">
                    <c:forEach var="subject" items="${subjects}">
                        <option value="${subject}">${subject}</option>
                    </c:forEach>
                </select>

                回数:
                <select name="testNo">
                    <c:forEach var="testNo" items="${testNos}">
                        <option value="${testNo}">${testNo}</option>
                    </c:forEach>
                </select>

                <button type="submit">検索</button>
            </div>
        </form>

        <!-- 検索結果の表示 -->
        <c:if test="${not empty results}">
            <table>
                <thead>
                    <tr>
                        <th>学生番号</th>
                        <th>氏名</th>
                        <th>点数</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="result" items="${results}">
                        <tr>
                            <td><c:out value="${result.studentNo}" /></td>
                            <td><c:out value="${result.studentName}" /></td>
                            <td><c:out value="${result.point}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <!-- 登録して終了ボタン -->
        	<form action="TestRegistExecute.action" method="post">
            	<button type="submit">登録して終了</button>
        	</form>
        </c:if>
    </div>
</div>

<%@ include file="../common/footer.html" %>
