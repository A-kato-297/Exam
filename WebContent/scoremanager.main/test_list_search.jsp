<!-- インクルードした際の文字化け防止 -->
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	form {
	    border: 1px solid #cccccc;
	    border-radius: 10px;
	    padding: 20px;
	    margin: 20px 0;
	}

	/* 各項目の横並び設定 */
	form:first-of-type p,
	form:first-of-type select,
	form:first-of-type button,
	form:nth-of-type(2) p,
	form:nth-of-type(2) input,
	form:nth-of-type(2) button {
	    display: inline-block;
	    vertical-align: middle;
	    margin-right: 10px;
	}

	form:first-of-type p:nth-of-type(1),
	form:first-of-type p:nth-of-type(2),
	form:first-of-type p:nth-of-type(3),
	form:first-of-type button {
	    width: 15%;
	}

	form:first-of-type select:nth-of-type(1),
	form:first-of-type select:nth-of-type(2),
	form:first-of-type select:nth-of-type(3) {
	    width: 20%;
	}

	form:nth-of-type(2) p:nth-of-type(1),
	form:nth-of-type(2) button {
	    width: 25%;
	}

	form:nth-of-type(2) input {
	    width: 50%;
	}

	/* フォーム間の薄い線 */
	form + form {
	    border-top: 1px solid #dddddd;
	    padding-top: 20px;
	    margin-top: 20px;
	    clear: both;
	}
</style>

<form action="TestListSubjectExecute.action" method="get">
    <p>科目情報</p>
    <p>入学年度</p>
    <select name="entYear">
        <c:forEach var="year" items="${entYears}">
            <option value="${year}">${year}</option>
        </c:forEach>
    </select>
    <p>クラス</p>
    <select name="classNum">
        <c:forEach var="classNum" items="${classNumbers}">
            <option value="${classNum}">${classNum}</option>
        </c:forEach>
    </select>
    <p>科目</p>
    <select name="subjectName">
        <c:forEach var="subject" items="${subjects}">
            <option value="${subject}">${subject}</option>
        </c:forEach>
    </select>
    <button type="submit">検索</button>
</form>

<form action="TestListStudentExecute.action" method="get">
    <p>学生情報</p>
    <p>学生番号</p>
    <input type="text" name="studentNo" maxlength="10">
    <button type="submit">検索</button>
</form>