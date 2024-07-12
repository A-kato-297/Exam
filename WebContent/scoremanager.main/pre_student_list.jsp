<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/scoremanager.main/style.css">

<div class="container">
    <div class="sidebar">
        <%@include file="/common/sidebar.jsp" %>
    </div>
    <div class="container">
        <div class="main">
            <h2>学生管理</h2>
            <div style="text-align: right;">
                <form action="StudentCreate.action" method="post">
                    <input type="submit" value="新規登録">
                </form>
            </div>
            <form action="PreStudentList.action" method="get">
                <div>
                    <div>
                        <label>入学年度</label>
                        <select name="ent_year">
                            <option value="">選択してください</option>
                            <c:forEach var="year" items="${entYears}">
                                <option value="${year}">${year}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <label>クラス</label>
                        <select name="class_num">
                            <option value="">選択してください</option>
                            <c:forEach var="classNum" items="${classNums}">
                                <option value="${classNum}">${classNum}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div>
                        <label>在学中</label>
                        <input type="checkbox" name="is_attend">
                    </div>
                    <div>
                        <input type="submit" value="絞り込み">
                    </div>
                </div>
            </form>
            <c:choose>
                <c:when test="${result_count > 0}">
                    <p>検索結果：${result_count}件</p>
                </c:when>
                <c:otherwise>
                    <p>学生情報が存在しませんでした</p>
                </c:otherwise>
            </c:choose>
            <table>
                <thead>
                    <tr>
                        <th>入学年度</th>
                        <th>学生番号</th>
                        <th>氏名</th>
                        <th>クラス</th>
                        <th>在学中</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="student" items="${student_list}">
                        <tr>
                            <td>${student.entYear}</td>
                            <td>${student.no}</td>
                            <td>${student.name}</td>
                            <td>${student.classNum}</td>
                            <td><c:choose>
                                <c:when test="${student.isAttend}">O</c:when>
                                <c:otherwise>X</c:otherwise>
                            </c:choose></td>
                            <td><a href="StudentUpdate.action?no=${student.no}&entYear=${student.entYear}">変更</a></td>

                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<%@include file="../common/footer.html" %>
