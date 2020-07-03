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
<title>FootBallTogether - 팀가입요청</title>

<!-- loader-->
<link href="assets/css/pace.min.css" rel="stylesheet" />
<script src="assets/js/pace.min.js"></script>
<!--favicon-->
<link rel="icon" href="assets/images/favicon.ico" type="image/x-icon">
<!-- Vector CSS -->
<!-- <link href="assets/plugins/vectormap/jquery-jvectormap-2.0.2.css" rel="stylesheet" /> -->
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
<link href="assets/css/app-style.css" rel="stylesheet" />

<!-- Bootstrap core JavaScript-->
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/popper.min.js"></script>
<script src="assets/js/bootstrap.min.js"></script>

<!-- simplebar js -->
<script src="assets/plugins/simplebar/js/simplebar.js"></script>
<!-- sidebar-menu js -->
<script src="assets/js/sidebar-menu.js"></script>
<!-- loader scripts -->
<script src="assets/js/jquery.loading-indicator.js"></script>
<!-- Custom scripts -->
<script src="assets/js/app-script.js"></script>
<!-- Chart js -->

<script src="assets/plugins/Chart.js/Chart.min.js"></script>

<!-- Index js -->
<!-- <script src="assets/js/index.js"></script> -->
<script type="text/javascript">
	$(function() {
		$('#search').click(function() {
			var teamName = $('#searchTeam').val();

			$.ajax({
				type : 'post',
				url : 'searchTeam.do',
				data : 'teamName=' + teamName,

				success : function(result) {
					$('#resultView').html('');
					$('#resultView').html(result);
				}// callback
			})// ajax
		}); //click	
	}); //ready1

	var teamId = 0;
	$(function() {
		$('button[type=submit]').on('click', function() {
			teamId = $(this).attr('value');
			console.log(teamId);

			$.ajax({
				type : 'post',
				url : 'RequestToJoin.do',
				data : 'teamId=' + teamId,

				success : function(result) {
					if (result == "true") {
						alert(teamId + "에 대한 가입 신청이 완료되었습니다.");
					} else {
						alert("이미 가입 신청하셨습니다. 팀 매니저 승인 전입니다.");
					}
				}//callback
			});//ajax
		});
	}); //ready2
</script>
</head>

<body class="bg-theme bg-theme1">

	<!-- Start wrapper-->
	<div id="wrapper">

		<!--Start sidebar-wrapper-->
		<div id="sidebar-wrapper" data-simplebar=""
			data-simplebar-auto-hide="true">
			<div class="brand-logo">
				<a href="#"> <img src="ours/img/logo.png" class="logo-icon"
					alt="logo icon">
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
			<!-- 여기에 내용을 쓰면 됩니다. -->

			<div class="row" style="margin-bottom: 40px">
				<form class="search-bar">
					<input type="text" class="form-control" id="searchTeam"
						placeholder="팀 이름을 입력해주세요."> <a href="#"
						onclick="return false;"><i id="search" class="icon-magnifier"></i></a>
				</form>
			</div>

			<div class="row">
				<div class="col-lg-8">
					<div class="card">
						<div class="card-body">
							<h4 class="card-title" style="font-size: 20px">All Teams in
								FootBallTogether</h4>
							<div class="table-responsive">
								<table class="table table-hover" style="text-align: center">
									<thead>
										<tr>
											<th scope="col" style="font-size: 15px;">#</th>
											<th scope="col" style="font-size: 15px;">팀 이름</th>
											<th scope="col" style="font-size: 15px;">랭킹</th>
											<th scope="col" style="font-size: 15px;">회원수</th>
											<th scope="col" style="font-size: 15px;">홈경기장</th>
											<th scope="col" style="font-size: 15px;">가입 신청</th>
										</tr>
									</thead>
									<tbody id="resultView">
										<c:forEach items="${tvList}" var="team">
											<tr>
												<th scope="row"><img src="${team.emblem}"
													style="width: 40px; height: 40px;"></th>
												<td>${team.teamName}</td>
												<td><c:if test="${team.ti.ranking != '0'}">${team.ti.ranking}</c:if>
													<c:if test="${team.ti.ranking == '0'}">랭킹자료없음</c:if></td>
												<td>${team.ti.memberNum}</td>
												<td><c:if test="${team.stadiumId != null}">있음</c:if> <c:if
														test="${team.stadiumId == null}">없음</c:if></td>
												<td>
													<button type="submit" class="btn btn-light px-5"
														id="requestToJoin" value="${team.teamId}">
														<i class="icon-lock"></i> 가입 신청
													</button>
												</td>
										</c:forEach>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>

			</div>






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
