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
<title>FootBallTogether - 매치 찾기</title>

<!-- loader-->
<link href="assets/css/pace.min.css" rel="stylesheet" />
<script src="assets/js/pace.min.js"></script>
<!--favicon-->
<link rel="icon" href="ours/img/logo.png" type="image/x-icon">
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
<!-- <script src="assets/js/jquery.loading-indicator.js"></script> -->
<!-- Custom scripts -->
<script src="assets/js/app-script.js"></script>
<!-- Chart js -->

<script src="assets/plugins/Chart.js/Chart.min.js"></script>

<script type="text/javascript">
var distance = 0;
var mannersScore=0;
var matchNum=0;
var memberNum=0;
var winningScore=0;
$(function(){
$('.index').on('keyup', function(){
	indexValue = $(this).val();
	if(indexValue>10){
		alert("10보다 작은 값을 넣어주시기 바랍니다.");
		$(this).val("");
		$(this).focus();
	}
	console.log(typeof Number($('#distance').val()));
	console.log(Number($('#distance').val())+Number($('#mannersScore').val())+Number($('#matchNum').val())+Number($('#memberNum').val())+Number($('#winningScore').val()));
	if(Number($('#distance').val())+Number($('#mannersScore').val())+Number($('#matchNum').val())+Number($('#memberNum').val())+Number($('#winningScore').val())>10){
		alert("전체 합은 10을 넘을 수 없습니다.");
		$(this).val("");
		$(this).focus();
	}
});
});//ready
var teamId = 0;
var matchId = 0;
$(function(){
	$('button[type=submit]').on('click', function() {
		teamId = $(this).attr('value');
		matchId = $(this).attr('name');
		console.log(matchId);
		$.ajax({
			type : 'post',
			url : 'requestToPlay.do',
			data : 'teamId=' + teamId+'&&matchId='+matchId,

			success : function(result) {
				if (result == "true") {
					alert(teamId + "에 대한 경기 신청이 완료되었습니다.");
				} else {
					alert("이미 해당 팀에 대한 경기를 신청한 상태입니다.");
				}
			}//callback
		});//ajax
	});
});

</script>


</head>
<c:set var="manager" value="${tVo.tmvList[0].manager}" />

<body class="bg-theme bg-theme1">

	<!-- Start wrapper-->
	<div id="wrapper">

		<!--Start sidebar-wrapper-->
		<div id="sidebar-wrapper" data-simplebar=""
			data-simplebar-auto-hide="true">
			<div class="brand-logo">
				<a href="login.jsp"> <img src="ours/img/logo.png"
					class="logo-icon" alt="logo icon">
				</a>
			</div>
			<ul class="sidebar-menu do-nicescrol">
				<li class="sidebar-header"><b style="font-size: large">Menu</b></li>
				<li style="margin-left: 50px; margin-bottom: 5px;">반갑습니다. <span><strong>${uVo.name}</strong></span>님
				</li>


				<!-- 매니저 / 일반회원인지에 따라 왼쪽 메뉴가 다르게 보여야 함 -->
				<li><a href="ToHome.do"> <i
						class="zmdi zmdi-view-dashboard"></i><span> 현재팀 홈으로</span>
				</a></li>
				<li><a href="showAllMember.do?teamId=${tVo.teamId}"> <i
						class="zmdi zmdi-accounts"></i> <span>멤버 보기</span>
				</a></li>
				<li><a href="matchHistory.do?teamId=${tVo.teamId}"> <i
						class="zmdi zmdi-file-text"></i> <span>전적 조회</span>
				</a></li>
				<li><a href="voteBulletin.do"> <i
						class="zmdi zmdi-check-square"></i><span>투표하기</span>
				</a></li>
				<li><a href="matchAndSquad.do" target="_blank"> <i
						class="icon-settings mr-2"></i> <span>매치</span>
				</a></li>
				<c:choose>
					<c:when test="${manager=='1'}">
						<li><a href="findMatch.jsp"> <i
								class="zmdi zmdi-search-for"></i> <span>매치 찾기</span>
						</a></li>
						<li><a href="AllJoinRequest.do" target="_blank"> <i
								class="zmdi zmdi-account-circle"></i> <span>가입신청 리스트</span>
						</a></li>
						<li><a href="makeVote.do"> <i
								class="zmdi zmdi-check-square"></i> <span>투표 만들기</span>
						</a></li>
						<li><a href="teamSetting.do" target="_blank"> <i
								class="icon-settings mr-2"></i> <span>팀 설정</span>
						</a></li>

					</c:when>
				</c:choose>
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
				<div class="row"
					style="text-align: center; background-color: rgba(0, 0, 0, .2); box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1)">
					<h5 style="margin: 20px auto">거리와 팀의 능력치에 따라서 매치를 추천해 줍니다.</h5>
				</div>
				<div class="row"
					style="background-color: rgba(0, 0, 0, .2); box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1)">
					<div class="col-lg-6"></div>
					<div class="col-lg-6">


						<form action="findMatch.do" method="post">
							<div class="form-group row">
								<div class="col-lg-3"></div>
							</div>
							<div class="form-group row">
								<div class="col-lg-3">거리 기준</div>
								<div class="col-lg-9">
									<input type="text" id="distance"
										name="distance" class="form-control index"
										value="">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-3">매너점수 기준</div>
								<div class="col-lg-9">
									<input type="text" id="mannersScore"
										name="mannersScore" class="form-control index"
										value="">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-3">경기 횟수</div>
								<div class="col-lg-9">
									<input type="text" id="matchNum"
										name="matchNum" class="form-control index"
										value="">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-3">회원수</div>
								<div class="col-lg-9">
									<input type="text" id="memberNum"
										name="memberNum" class="form-control index"
										value="">
								</div>
							</div>
							<div class="form-group row">
								<div class="col-lg-3">승점</div>
								<div class="col-lg-9">
									<input type="text" id="winningScore"
										name="winningScore" class="form-control index"
										value="">
								</div>
							</div>

							<div class="form-group row">
								<div class="col-lg-6"></div>
								<div class="col-lg-6" style="text-align: right">
									<input type="reset" id="playerInfoChageReset"
										class="btn btn-secondary" value="취소하기"> <input
										type="submit" id="playerInfoChangeSubmit"
										class="btn btn-primary" value="추천스쿼드">
								</div>


							</div>
						</form>

					</div>
				</div>
<br>
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
											<th scope="col" style="font-size: 15px;">경기 신청</th>
										</tr>
									</thead>
									<tbody id="resultView">
										<c:forEach items="${totalVO}" var="team">
											<tr>
												<th scope="row"><img src="${team.emblem}"
													style="width: 40px; height: 40px;"></th>
												<td>${team.teamName}</td>
												<td><c:if test="${team.ranking != '0'}">${team.ranking}</c:if>
													<c:if test="${team.ranking == '0'}">랭킹자료없음</c:if></td>
												<td>${team.memberNum}</td>
												<td><c:if test="${team.stadiumId != null}">있음</c:if> <c:if
														test="${team.stadiumId == null}">없음</c:if></td>
												<td>
													<button type="submit" class="btn btn-light px-5"
														id="requestToPlay" name = "${team.matchId}" value="${team.teamId}">
														<i class="icon-lock"></i> 경기 신청
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
