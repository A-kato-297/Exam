<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.html" %>

<div class="container">
    <%@ include file="/common/sidebar.jsp" %>

    <div class="main-content">
        <h2>成績一覧(科目)</h2>

        <!-- 科目検索バー -->
        <div>
            <p>科目情報</p>
            <form action="TestListSubjectExecute.action" method="post">
                <p>入学年度
                    <select name="entYear">
                        <c:forEach var="year" items="${entYears}">
                            <option value="${year}">${year}</option>
                        </c:forEach>
                    </select>
                </p>
                <p>クラス
                    <select name="classNum">
                        <c:forEach var="class" items="${classNums}">
                            <option value="${class}">${class}</option>
                        </c:forEach>
                    </select>
                </p>
                <p>科目
                    <select name="subjectCd">
                        <c:forEach var="subject" items="${subjects}">
                            <option value="${subject.cd}">${subject.name}</option>
                        </c:forEach>
                    </select>
                </p>
                <p><button type="submit">検索</button></p>
            </form>
        </div>

        <!-- 学生検索バー -->
        <div>
            <p>学生情報</p>
            <form action="TestListStudentExecute.action" method="post">
                <p>学生番号
                    <select name="studentNo">
                        <c:forEach var="student" items="${students}">
                            <option value="${student.no}">${student.no}</option>
                        </c:forEach>
                    </select>
                </p>
                <p><button type="submit">検索</button></p>
            </form>
        </div>

        <p>科目：${selectedSubjectName}</p>

        <!-- 検索結果 -->
        <c:choose>
            <c:when test="${not empty testResults}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>入学年度</th>
                            <th>クラス</th>
                            <th>学生番号</th>
                            <th>氏名</th>
                            <th>1回</th>
                            <th>2回</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="result" items="${testResults}">
                            <tr>
                                <td>${result.entYear}</td>
                                <td>${result.classNum}</td>
                                <td>${result.studentNo}</td>
                                <td>${result.name}</td>
                                <td><c:out value="${result.point1}" default="-"/></td>
                                <td><c:out value="${result.point2}" default="-"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
            <c:otherwise>
                <p>科目情報が存在しませんでした</p>
            </c:otherwise>
        </c:choose>
    </div>
</div>

<%@ include file="../common/footer.html" %>