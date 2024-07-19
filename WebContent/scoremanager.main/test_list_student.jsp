<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.html" %>

<link rel="stylesheet" href="/hcp/common/sidebar_style.css">
<link rel="stylesheet" href="/hcp/scoremanager.main/test_student_style.css">

<div class="container">
    <%@ include file="/common/sidebar.jsp" %>

    <div class="main-content">
        <h2>成績一覧(学生)</h2>
<<<<<<< HEAD

=======



<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>成績管理一覧画面</title>
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <%@ include file="/common/sidebar.jsp" %>
        </div>
        <div class="content">
            <div class="h2">
                <h2>成績一覧(科目)</h2>
            </div>
            <div class="line1">
                <div class="line">
                    <form action="search" method="post">
                        <p>科目情報</p>
                        <table>
                            <tr>
                                <th>入学年度</th>
                                <th>クラス</th>
                                <th>科目</th>
                            </tr>
                            <tr>
                                <td>
                                    <select name="f1">
                                        <option value="--------">--------</option>
                                        <!-- 他のオプションをここに追加 -->
                                    </select>
                                </td>
                                <td>
                                    <select name="f2">
                                        <option value="--------">--------</option>
                                        <!-- 他のオプションをここに追加 -->
                                    </select>
                                </td>
                                <td>
                                    <select name="f3">
                                        <option value="--------">--------</option>
                                        <!-- 他のオプションをここに追加 -->
                                    </select>
                                </td>
                                <td>
                                    <button type="submit" name="searchSubject" value="31">検索</button>
                                </td>
                            </tr>
                        </table>

                        <div>学生情報</div>
                        <div>学生番号</div>
                        <input type="text" name="f4" placeholder="学生番号を入力してください" maxlength="10" required>
                        <button type="submit" name="searchStudent" value="32">検索</button>

                        <p id="error-message" style="color: red;">
                            <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
<%@ include file="../common/footer.html" %>
>>>>>>> branch 'master' of https://github.com/A-kato-297/Exam.git


<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <title>成績管理一覧画面</title>
</head>
<body>
    <div class="container">
        <div class="sidebar">
            <%@ include file="/common/sidebar.jsp" %>
        </div>
        <div class="content">
            <div class="h2">
                <h2>成績一覧(科目)</h2>
            </div>
            <div class="line1">
                <div class="line">
                    <form action="search" method="post">
                        <p>科目情報</p>
                        <table>
                            <tr>
                                <th>入学年度</th>
                                <th>クラス</th>
                                <th>科目</th>
                            </tr>
                            <tr>
                                <td>
                                    <select name="f1">
                                        <option value="--------">--------</option>
                                        <!-- 他のオプションをここに追加 -->
                                    </select>
                                </td>
                                <td>
                                    <select name="f2">
                                        <option value="--------">--------</option>
                                        <!-- 他のオプションをここに追加 -->
                                    </select>
                                </td>
                                <td>
                                    <select name="f3">
                                        <option value="--------">--------</option>
                                        <!-- 他のオプションをここに追加 -->
                                    </select>
                                </td>
                                <td>
                                    <button type="submit" name="searchSubject" value="31">検索</button>
                                </td>
                            </tr>
                        </table>

                        <div>学生情報</div>
                        <div>学生番号</div>
                        <input type="text" name="f4" placeholder="学生番号を入力してください" maxlength="10" required>
                        <button type="submit" name="searchStudent" value="32">検索</button>

                        <p id="error-message" style="color: red;">
                            <%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
<%@ include file="../common/footer.html" %>

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

        <p>氏名：${studentName} (${studentNo})</p>

        <!-- 検索結果 -->
        <c:choose>
            <c:when test="${not empty testResults}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>科目名</th>
                            <th>科目コード</th>
                            <th>回数</th>
                            <th>点数</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="result" items="${testResults}">
                            <tr>
                                <td>
                                    <c:forEach var="subject" items="${subjects}">
                                        <c:if test="${subject.cd == result.subjectCd}">
                                            ${subject.name}
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>${result.subjectCd}</td>
                                <td>${result.no}</td>
                                <td><c:out value="${result.point}" default="-"/></td>
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

<<<<<<< HEAD
<%@ include file="../common/footer.html" %>

=======
<%@ include file="../common/footer.html" %>

>>>>>>> branch 'master' of https://github.com/A-kato-297/Exam.git
