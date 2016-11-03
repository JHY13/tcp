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

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항 목록</title>


<script src="../js/modernizr-custom.js" type="text/javascript">
	document.createElement("main");
</script>

</head>
<body>

			<!-- -------------------------------------------------------메인------------------------------------------------------------------- -->
			<main>

			<h1>리스트</h1>
			<div>
				<!-- <nav>
					<h1>고객센터 메뉴</h1>
					<ul>
						<li><a href="">home</a></li>
						<li><a href="">고객센터</a></li>
						<li><a href="">공지사항</a></li>
					</ul>
				</nav> -->
				<form></form>
				</select> <label>검색어</label> <input name="q" value="${param.q}" /> <input
				type="submit" value="검색" />

				<table border="1">
					<thead>
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>사용자</td>
							<td>작성일</td>
							<td>조회수</td>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="n" items="${list}">
							<tr>
								<td>${n.code}</td>
								<td><a href="notice-detail?code=${n.code}">${n.title}</a></td>
								<td>${n.writer}</td>
								<td><fmt:formatDate pattern="yyyy-MM-dd"
										value="${n.regdate }" /></td>
								<%-- <td>${n.regDate}</td> --%>
								<td>${n.hit}</td>
							</tr>
						</c:forEach>
						<%-- <n:for>
			오마이갓<br />
			</n:for> --%>
					</tbody>
				</table>

				<div>현재 페이지</div>
				<div>1/3 pages</div>

				<div>
					<h3>
						페이저
						<div>
							<c:if test="${empty param.p}">
								<c:set var="page" value="1" />
							</c:if>
							<c:if test="${not empty param.p}">
								<c:set var="page" value="${param.p}" />
							</c:if>

							<c:set var="start" value="${page-(page-1)%5}" />
							<c:set var="end"
								value="${fn:substringBefore((count%10==0?(count/10):(count/10)+1),'.')}" />

							<div>${page }/${end }</div>

							<div>
								<a href="notice-reg">글쓰기</a>
							</div>

							<div>
								<a
									href="notice?p=${(start==1)?1:start-1}&t=${param.t}&q=${param.q}">이전</a>
							</div>
							<ul>
								<c:forEach var="i" begin="0" end="4">
									<c:if test="${start+i<=end }">
										<c:if test="${page ==start+i }">
											<li><a
												href="notice?p=${start+i}&t=${param.t}&q=${param.q}"
												class="strong">${start+i}</a></li>
										</c:if>
										<c:if test="${page !=start+i }">
											<li><a
												href="notice?p=${start+i}&t=${param.t}&q=${param.q}">${start+i}</a></li>
										</c:if>
									</c:if>
								</c:forEach>
							</ul>
							<div>
								<a href="notice?p=${start+5}">다음</a>
							</div>
						</div>
				</div>
			</div>

			</main>

		</div>
	</div>

	<!-- -------------------------------------------------------<footer>------------------------------------------------------------------- -->
	
	<jsp:include page="../inc/footer.jsp"></jsp:include>

</body>
</html>