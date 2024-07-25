<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/header.html" %>
<%@include file="/common/sidebar.jsp" %>

<style>

</style>
<div class="main-content">
    <div class="container">
        <h2>成績管理</h2>
        <form method="post" action="TestRegist.action">
            <div class="search-bar">
                <div class="center">入学年度</div>
                <div class="center"></div>
                <div class="center">クラス</div>
                <div class="center"></div>
                <div class="center">科目</div>
                <div class="center"></div>
                <div class="center"></div>
                <div class="center"></div>
                <div class="center"></div>
                <div class="center"></div>
                <div class="center">回数</div>
                <div class="center"></div>

                <select name="entYear">
                    <option value="">--------</option>
                    <c:forEach var="year" items="${entYears}">
                        <option value="${year}">${year}</option>
                    </c:forEach>
                </select>
                <div></div>
                <select name="classNum">
                    <option value="">--------</option>
                    <c:forEach var="classNum" items="${classNumbers}">
                        <option value="${classNum}">${classNum}</option>
                    </c:forEach>
                </select>
                <div></div>
                <select name="subjectName">
                    <option value="">--------</option>
                    <c:forEach var="subject" items="${subjects}">
                        <option value="${subject}">${subject}</option>
                    </c:forEach>
                </select>
                <div class="center"></div>
                <div class="center"></div>
                <div class="center"></div>
                <div class="center"></div>
                <div class="center"></div>
                <select name="testNo">
                    <option value="">--------</option>
                    <c:forEach var="testNo" items="${testNos}">
                        <option value="${testNo}">${testNo}</option>
                    </c:forEach>
                </select>
                <div></div>
                <div class="center">
                    <button type="submit" name="search">検索</button>
                </div>
            </div>
        </form>

        <c:if test="${not empty searchResults}">
            <h3>科目：${subjectName}(${testNo})</h3>
            <form action="TestRegistExecute.action" method="post">
                <table border="1">
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

<%@include file="../common/footer.html" %>