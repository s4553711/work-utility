<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
		<title>Insert title here</title>
		<link rel="stylesheet" href="css/bootstrap.min.css">
		<link rel="stylesheet" href="css/main.css">
		<script src="js/jquery-1.11.1.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
	</head>
<body>
	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Dev Tool</a>
			</div>
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li class="active"><a href="system_update">System Update</a></li>
				    <li><a href="grid_check">Grid Check</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<div class="main-body">
			<div class="row">
				<table class="table table-striped table-bordered table-condensed">
					<tr><th>Node</th><th>System</th><th>storage1</th><th>storage2</th><th>storage3</th></tr>
					<c:forEach var="node" items="${model}">
						<tr>
							<td>${node.node}</td>
							<td>${node.cmd_status}</td>
							<td>${node.stor1_status}</td>
							<td>${node.stor2_status}</td>
							<td>${node.stor3_status}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>