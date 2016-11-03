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

	<%-- <jsp:include page="../inc/header.jsp"></jsp:include> --%>

	<!-- -------------------------------------------------------<visual>------------------------------------------------------------------- -->
	
	<jsp:include page="../inc/visual.jsp"></jsp:include>

	<!-- -------------------------------------------------------<body>------------------------------------------------------------------- -->
	<div id="body">
		
	</div>

	<!-- -------------------------------------------------------<footer>------------------------------------------------------------------- -->
	
	<%-- <jsp:include page="../inc/footer.jsp"></jsp:include> --%>

</body>
</html>