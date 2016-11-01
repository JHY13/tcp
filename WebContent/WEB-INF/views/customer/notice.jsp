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

<link href="../css/reset.css" type="text/css" rel="stylesheet" />
<link href="../css/style.css" type="text/css" rel="stylesheet" />

<script src="../js/modernizr-custom.js" type="text/javascript">
	document.createElement("main");
</script>

</head>
<body>

	<!-- 이미지를 넣어줄때는 상대경로를 사용한다!. alt는 대체한다는뜻(뉴렉처 온라인 제목을 이미지로 대체함.원래있던 제목을 지우지는말것)  -->

	<!-- ------------------------------------------------------<헤더>----------------------------------------------------------------------- -->

	<div id="header">
		<div class="content-container">

			<h1>
				<img src="../images/logo.png" alt="뉴렉처 온라인" />
			</h1>


			<header>
				<section>
					<h1>헤더</h1>
					<nav id="main-menu">
						<h1>메인 메뉴</h1>

						<ul>
							<li><a href="" lang="ko-a" class="first">학습가이드</a></li>
							<li><a href="" lang="ko-b">뉴렉과정</a></li>
							<li><a href="" lang="en-a">강좌선택</a></li>
						</ul>
					</nav>
					<section id="search-form">
						<h1>강좌검색 폼</h1>
						<form>
							<fieldset>
								<legend>과정검색필드</legend>
								<label>과정검색</label> 
								<input type="text" value="" /> 
								<input type="submit" value="검색" />
							</fieldset>
						</form>
					</section>
					<nav id="member-menu">
						<h1>회원 메뉴</h1>
						<ul>
							<li><a href="">HOME</a></li>
							<li><a href="">로그인</a></li>
							<li><a href="">회원가입</a></li>
						</ul>
					</nav>
					<nav id="customer-menu">
						<h1>고객 메뉴</h1>
						<ul>
							<li><a href=""><img src="../images/txt-mypage.png"
									alt="마이페이지" /></a></li>
							<li><a href=""><img src="../images/txt-customer.png"
									alt="고객센터" /></a></li>
						</ul>
					</nav>
				</section>
			</header>
		</div>
	</div>

	<!-- -------------------------------------------------------<visual>------------------------------------------------------------------- -->
	<div id="visual">

		<div class="content-container"></div>

	</div>

	<!-- -------------------------------------------------------<body>------------------------------------------------------------------- -->
	<div id="body">
		<div class="content-container clearfix">

			<!-- -------------------------------------------------------aside------------------------------------------------------------------- -->
			<aside id="aside">
				<h1>고객센터</h1>
				<nav>
					<h1 class="h-menu clearfix">고객센터 메뉴</h1>
					<ul>
						<li><a href="">공지사항</a></li>
						<li><a href="">1:1고객문의</a></li>
						<li><a href="">학습안내</a></li>
					</ul>
				</nav>
				<nav>
					<h1>추천사이트</h1>
					<ul>
						<li><a href="">앤서이즈</a></li>
						<li><a href="">W3C</a></li>
						<li><a href="">마이크로소프트</a></li>
					</ul>
				</nav>
				<nav>
					<h1>
						<a href="">구글광고</a>
					</h1>
				</nav>
			</aside>

			<!-- -------------------------------------------------------메인------------------------------------------------------------------- -->
			<main>

			<h1>공지사항</h1>
			<div>
				<nav>
					<h1>고객센터 메뉴</h1>
					<ul>
						<li><a href="">home</a></li>
						<li><a href="">고객센터</a></li>
						<li><a href="">공지사항</a></li>
					</ul>
				</nav>
				<form>검색</form>
				</select> <label>검색어</label> <input name="q" value="${param.q}" /> <input
				type="submit" value="검색" />

				<table border="1">
					<thead>
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>작성자</td>
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
	<footer id="footer">
		<!-- <div class="content-container">

         <h2>회사정보</h2>
         <dl>
            <dt>주소</dt>
            <dd>서울특별시 마포구 토정로35길 11, 인우빌딩 5층 266호</dd>
            <dt>관리자메일</dt>
            <dd>admin@newlecture.com</dd>
            <dt>사업자 등록번호</dt>
            <dd>132-18-46763 통신 판매업 신고제 2013-서울강동-0969 호</dd>
            <dt>상호</dt>
            <dd>뉴렉처</dd>
            <dt>대표</dt>
            <dd>박용우</dd>
            <dt>전화번호</dt>
            <dd>070-4206-4084 [죄송합니다. 당분간 문의내용은 고개센터 메뉴에서 1:1 문의를
               이용해주시기바랍니다]</dd>
         </dl>
         <div>Copyright ⓒ newlecture.com 2012-2014 All Right Reserved.
            Contact admin@newlecture.com for more information</div>
      </div> -->
	</footer>

</body>
</html>