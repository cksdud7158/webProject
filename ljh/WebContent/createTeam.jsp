<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>FootBallTogether-팀만들기</title>
<!-- loader-->
<link href="assets/css/pace.min.css" rel="stylesheet" />
<script src="assets/js/pace.min.js"></script>
<!--favicon-->
<link rel="icon" href="assets/images/favicon.ico" type="image/x-icon">
<!-- simplebar CSS-->
<link href="assets/plugins/simplebar/css/simplebar.css" rel="stylesheet" />
<!-- Bootstrap core CSS-->
<link href="assets/css/bootstrap.min.css" rel="stylesheet" />
<!-- animate CSS-->
<link href="assets/css/animate.css" rel="stylesheet" type="text/css" />
<!-- Icons CSS-->
<link href="assets/css/icons.css" rel="stylesheet" type="text/css" />
<!-- Sidebar CSS-->
<link href="assets/css/sidebar-menu.css" rel="stylesheet" />
<!-- Custom Style-->
<link href="assets/css/app-style.css" rel="stylesheet" />

<!-- Bootstrap core JavaScript-->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<!-- simplebar js -->
<script src="assets/plugins/simplebar/js/simplebar.js"></script>
<!-- sidebar-menu js -->
<script src="assets/js/sidebar-menu.js"></script>

<!-- Custom scripts -->
<script src="assets/js/app-script.js"></script>
<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>

<style type="text/css">
select option {
	background-color: #02fd89;;
	color: #6820a3;
	font-weight: bold;
}
</style>
<script>

	$(function() {
	
	});//jquery
</script>
<style>
#profilePicture{
	background-repeat: no-repeat;
	background-size : cover;
}
</style>
</head>

<body class="bg-theme bg-theme1">

	<!-- Start wrapper-->
	<div id="wrapper">

		<!--Start sidebar-wrapper-->
		<div id="sidebar-wrapper" data-simplebar=""
			data-simplebar-auto-hide="true">
			<div class="brand-logo">
				<a href="#"> <img src="ours/img/logo.png"
					class="logo-icon" alt="logo icon">
				</a>
			</div>
			<ul class="sidebar-menu do-nicescrol">
				<li class="sidebar-header"><b style="font-size: large">Menu</b></li>
				<li style="margin-left: 50px; margin-bottom: 5px;">반갑습니다. <span><strong>${uVo.name}</strong></span>님
				</li>
				<li><a href="login.jsp"> <i
						class="zmdi zmdi-view-dashboard"></i><span>내 홈으로</span>
				</a></li>
				<li><a href="profile.jsp"> <i class="zmdi zmdi-folder-star"></i>
						<span>내정보</span>
				</a></li>
				<li><a href="AllTeam.do"> <i class="zmdi zmdi-folder-star"></i>
						<span>팀 찾기</span>
				</a></li>
				<li><a href="createTeam.jsp"> <i class="zmdi zmdi-folder-star"></i>
						<span>팀 만들기</span>
				</a></li>
				<li><a href="profile.jsp"> <i
						class="icon-settings mr-2"></i> <span>설정</span>
				</a></li>
			</ul>
		</div>
		<!--End sidebar-wrapper-->

		<!--Start topbar header-->
		<header class="topbar-nav">
			<nav class="navbar navbar-expand fixed-top">
				<ul class="navbar-nav mr-auto align-items-center">
					<li class="nav-item"><a class="nav-link toggle-menu"
						href="javascript:void();"> <i class="icon-menu menu-icon"></i>
					</a></li>
					<li class="nav-item">
						<form class="search-bar">
							<input type="text" class="form-control"
								placeholder="Enter keywords"> <a
								href="javascript:void();"><i class="icon-magnifier"></i></a>
						</form>
					</li>
				</ul>

				<ul class="navbar-nav align-items-center right-nav-link">
					<li class="nav-item dropdown-lg"><a
						class="nav-link dropdown-toggle dropdown-toggle-nocaret waves-effect"
						data-toggle="dropdown" href="javascript:void();"> <i
							class="fa fa-envelope-open-o"></i></a></li>
					<li class="nav-item dropdown-lg"><a
						class="nav-link dropdown-toggle dropdown-toggle-nocaret waves-effect"
						data-toggle="dropdown" href="javascript:void();"> <i
							class="fa fa-bell-o"></i></a></li>
					<li class="nav-item"><a
						class="nav-link dropdown-toggle dropdown-toggle-nocaret"
						data-toggle="dropdown" href="#"> <span class="user-profile"><img
								src="https://via.placeholder.com/110x110" class="img-circle"
								alt="user avatar"></span>
					</a>
						<ul class="dropdown-menu dropdown-menu-right">
							<li class="dropdown-item user-details"><a
								href="javaScript:void();">
									<div class="media">
										<div class="avatar">
											<img class="align-self-start mr-3"
												src="https://via.placeholder.com/110x110" alt="user avatar">
										</div>
										<div class="media-body">
											<h6 class="mt-2 user-title">${uVo.name}</h6>
											<p class="user-subtitle">${uVo.email}</p>
										</div>
									</div>
							</a></li>
							<li class="dropdown-divider"></li>
							<li class="dropdown-item"><a href="logout.do"><i
									class="icon-power mr-2"></i>Logout</a></li>
						</ul></li>
				</ul>
			</nav>
		</header>
		<!--End topbar header-->

		<div class="clearfix"></div>

		<div class="content-wrapper">
			<div class="container-fluid">
				<div class="card">
					<div class="card-body">
						<form action="createTeam.do" method="post" enctype="multipart/form-data">
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">팀 이름</label>
								<div class="col-lg-9">
									<input type="text" name="teamName" id="teamName"
										class="form-control form-control-rounded"
										value="" placeholder="팀 이름을 입력해주세요" required="required">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">엠블럼을 추가해주세요</label>
								<div class="col-lg-9">
									<input type="file" name="emblem" id="emblem"
										class="form-control form-control-rounded">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">활동 지역 1</label>
								<div class="col-lg-9">
									<input type="text" name="area1" id="area1"
										class="form-control form-control-rounded"
										value="" placeholder="활동지역을 입력해주세요" required="required">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">활동 지역 2</label>
								<div class="col-lg-9">
									<input type="text" name="area2" id="area2"
										class="form-control form-control-rounded"
										value="" placeholder="활동지역을 입력해주세요">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">활동 지역 3</label>
								<div class="col-lg-9">
									<input type="text" name="area3" id="area3"
										class="form-control form-control-rounded"
										value="" placeholder="활동지역을 입력해주세요">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">경기장 이름</label>
								<div class="col-lg-9">
									<input type="text" name="stadiumName" id="stadiumName"
										class="form-control form-control-rounded"
										value="" placeholder="주 경기장이 있으시다면 입력해주세요">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">경기장 주소</label>
								<div class="col-lg-9">
									<input type="text" name="stadiumAddr" id="stadiumAddr"
										class="form-control form-control-rounded"
										value="" placeholder="주 경기장이 있으시다면 입력해주세요">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">경기장 가격</label>
								<div class="col-lg-9">
									<input type="number" name="stadiumCost" id="stadiumCost"
										class="form-control form-control-rounded"
										value="" placeholder="주 경기장이 있으시다면 입력해주세요">
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label">경기장 타입</label>
								<div class="col-lg-9">
									<select name="stadiumType">
										<option value="11:11">11:11 경기장 </option>
										<option value="6:6">6:6 경기장</option>
									</select>
								</div>
							</div>
							<div class="form-group row">
								<label class="col-lg-3 col-form-label form-control-label"></label>
								<div class="col-lg-9">
									<input type="reset" id="userChangeReset"
										class="btn btn-secondary" value="취소하기"> <input
										type="submit" id="userChangeSubmit"
										class="btn btn-primary" value="만들기">
								</div>
							</div>
						</form>
					</div>
				</div>
			


				<!--start overlay-->
				<div class="overlay toggle-menu"></div>
				<!--end overlay-->

			</div>
			<!-- End container-fluid-->
		</div>
		<!--End content-wrapper-->
		<!--Start Back To Top Button-->
		<a href="javaScript:void();" class="back-to-top"><i
			class="fa fa-angle-double-up"></i> </a>
		<!--End Back To Top Button-->
		<!--Start footer-->
		<footer class="footer">
			<div class="container">
				<div class="text-center">Copyright © 2020 football together</div>
			</div>
		</footer>
		<!--End footer-->

	</div>
	<!--End wrapper-->
</body>
</html>
