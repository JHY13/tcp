<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="s" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
</head>
<body>
	<table border="1">
		<tbody>
			<tr>
				<td>제목</td>
				<td colspan="3">${n.title}</td>
				
			</tr>
			<tr>

				<td>작성일</td>
				<td colspan="3">${n.releaseyear}</td>

			</tr>
			<tr>
				<td>작성자</td>
				<td>${n.src}</td>
				<td>조회수</td>
				<td>${n.hit}</td>
			</tr>
			<tr>
				<td>src</td>
				<td colspan="3">
					<img src="${n.poster}" />
		
				</td>
			</tr>
			<tr>
				<td colspan="4">${n.content}</td>
			</tr>
		</tbody>
	</table>

	<!-- 준모오빠가 주신 코드 16.10.31  -->
	<div>
		<c:if test="${empty pn}">
            이전글이 없습니다.
         </c:if>
		<c:if test="${not empty pn}">
			<a href="notice-detail?code=${pn.code}">이전글 :${pn.title}</a>
		</c:if>
	</div>
	<div>
		<a href="notice-detail?code=${nn.code}">다음글 :${nn.title}</a>
	</div>

	<!--  -->


	<div>
		<a href="notice">목록</a> <a href="notice-edit?code=${n.code}">수정</a>
		<!-- 하나보낼 때는 get을 많이 씀 -->
		<a href="notice-del?code=${n.code}">삭제</a>
	</div>

</body>

</html>







<%-- 
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
/* String _code = request.getParameter("code");

NoticeDao noticeDao = new MyBatisNoticeDao(); //DAO:data access object 즉 data service 하는 클래스를 분리해서 재사용하도록.
Notice notice = noticeDao.get(_code);
pageContext.setAttribute("n", notice); */

/* 
pageContext.getRequest();
pageContext.getServletContext();

request.getRemoteAddr(); */


%>

  내부적으로 자바 변수로 선언되는게 아니라 page데이터 영역의 Attribute 선언되기 떄문에
 <%=변수이름%>형태로 출력 할수 없기때문에 ${변수이름} 이렇게 사용한다
                                                            지역변수를 가지고와서 쓸수가 없어서  

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tbody>
			<tr>
				<td>제목</td>
				<td colspan="3">${n.title}/${pageContext.request.remoteAddr}/
					${ param.code} / ${requestScope.aa}</td>
				
			<tr>
				<td>번호</td>
				<td colspan="3">${n.code}</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${n.writer}</td>
				<td>조회수</td>
				<td></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="3">
					<c:forEach var="f" items="${files}" varStatus="s">
						<a href="../download?f=${f.src}">${f.src}</a>
						<c:if test="${!s.last}" >
							index : ${s.index} / count : ${s.count} / 
							,
						</c:if>
					</c:forEach>
				</td>
			</tr>
			<tr>
				<td>작성일</td>
				<td colspan="3"><fmt:formatDate pattern="yyyy-MM-dd" value="${n.regdate }" /></td>
			</tr>
			<tr>

				<td colspan="4">${n.content}</td>
			</tr>
		</tbody>
	</table>
	<div>
		<a href="notice">목록</a> 
		<a href="notice-edit?code=${n.code}">수정</a> 
		<a href="notice-del?code=${n.code}">삭제</a> }
	</div>
</body>
</html> --%>