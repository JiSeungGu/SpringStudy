<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href='http://fonts.googleapis.com/css?family=Questrial' rel='stylesheet' type='text/css'>
<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
<script src="../js/skel.min.js"></script>
<script src="../js/skel-panels.min.js"></script>
<script src="../js/init.js"></script>
<link rel="stylesheet" href="../css/skel-noscript.css" />
<link rel="stylesheet" href="../css/style.css" />
<link rel="stylesheet" href="../css/style-desktop.css" />
</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<%-- Header 영역 --%>
<tiles:insertAttribute name="header"/>
<!-- Content 영역 -->
<tiles:insertAttribute name="content"/>
<!-- footer 영역 -->
<tiles:insertAttribute name="footer"/>

</body>
</html>
